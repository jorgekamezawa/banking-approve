package com.btgpactual.banking.bankingApprove.application.usecase

import com.btgpactual.banking.bankingApprove.application.dto.RequestApprovalDto
import com.btgpactual.banking.bankingApprove.application.usecase.`interface`.InterfaceRequestApproval
import com.btgpactual.banking.bankingApprove.application.view.RequestApprovalView
import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval
import com.btgpactual.banking.bankingApprove.domain.service.`interface`.InterfaceSystemRequestedApprovalService

class RequestApproval(
    private val systemRequestedApprovalService: InterfaceSystemRequestedApprovalService
): InterfaceRequestApproval {
    override fun registerApproval(requestApprovalDto: RequestApprovalDto): RequestApprovalView {
//        val systemRequestedApproval: SystemRequestedApproval = systemRequestedApprovalService
//            .getSystemRequestedApprovalByName(requestApprovalDto.objectApprovalDto.nameSystemRequestedApproval)
        TODO()
    }
}