package com.btgpactual.banking.bankingApprove.application.usecase

import com.btgpactual.banking.bankingApprove.application.dto.RequestApprovalDto
import com.btgpactual.banking.bankingApprove.application.usecase.`interface`.InterfaceRequestApproval
import com.btgpactual.banking.bankingApprove.application.view.RequestApprovalView
import com.btgpactual.banking.bankingApprove.domain.entity.Approval
import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.ObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval
import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum
import com.btgpactual.banking.bankingApprove.domain.service.`interface`.*
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class RequestApproval(
    private val systemRequestedApprovalService: InterfaceSystemRequestedApprovalService,
    private val categoryObjectApprovalService: InterfaceCategoryObjectApprovalService,
    private val objectApprovalService: InterfaceObjectApprovalService,
    private val userService: InterfaceUserService,
    private val approvalService: InterfaceApprovalService
) : InterfaceRequestApproval {
    override fun registerApproval(requestApprovalDto: RequestApprovalDto): RequestApprovalView {
        val systemRequestedApproval: SystemRequestedApproval = systemRequestedApprovalService
            .getSystemRequestedApprovalByName(requestApprovalDto.objectApprovalDto.nameSystemRequestedApproval)
        val categoryObjectApprovalList: List<CategoryObjectApproval> = categoryObjectApprovalService
            .getCategoryObjectApprovalByListOfNames(requestApprovalDto.objectApprovalDto.nameCategoryObjectApprovalList)
        val objectApproval: ObjectApproval =
            objectApprovalService.getObjectApprovalBySystemRequestedAndListOfCategoryObjectAndName(
                systemRequestedApproval,
                categoryObjectApprovalList,
                requestApprovalDto.objectApprovalDto.name
            )
        val userRequestedApproval = userService.getByLogin(requestApprovalDto.loginUserRequested)
        val approval = approvalService.initializeApproval(
            objectApproval,
            requestApprovalDto.objectUnderAnalysisId,
            userRequestedApproval
        )
        val registeredApproval = approvalService.registerApproval(approval)
        return RequestApprovalView(
            nameObjectApproval = registeredApproval.objectApproval.name,
            category = registeredApproval.objectApproval.categoryObjectApprovalList.map { it.name },
            nameSystemRequestedApproval = registeredApproval.objectApproval.systemRequestedApproval.name,
            loginUserRequestedApproval = registeredApproval.userRequestedApproval.login,
            objectUnderAnalysisId = registeredApproval.objectUnderAnalysisId,
            status = registeredApproval.status
        )
    }

    override fun getApprovalPending(login: String, profile: String, area: String): List<RequestApprovalView> {
        val approvalPendingList: List<Approval> =
            approvalService.getApprovalByStatus(StatusApprovalEnum.PENDING_APPROVAL)

        val filteredApproval = approvalPendingList.filter { approval ->
            val te4ste: Long  = approval.objectApproval?.id ?: throw RuntimeException("")
            approval.objectApproval.approverRoleList.any { approverRole ->
                when {
                    approverRole.userApprover.isNotEmpty() -> {
                        approverRole.userApprover.map { it.login }.contains(login)
                    }
                    approverRole.profileApprover.isNotEmpty() -> {
                        approverRole.profileApprover.map { it.name }.contains(profile)
                    }
                    approverRole.areaApprover.isNotEmpty() -> {
                        approverRole.areaApprover.map { it.name }.contains(area)
                    }
                    else -> {
                        false
                    }
                }
            }
        }
        return filteredApproval.map {
            RequestApprovalView(
                nameObjectApproval = it.objectApproval.name,
                category = it.objectApproval.categoryObjectApprovalList.map { it.name },
                nameSystemRequestedApproval = it.objectApproval.systemRequestedApproval.name,
                loginUserRequestedApproval = it.userRequestedApproval.login,
                objectUnderAnalysisId = it.objectUnderAnalysisId,
                status = it.status
            )
        }
    }
}
