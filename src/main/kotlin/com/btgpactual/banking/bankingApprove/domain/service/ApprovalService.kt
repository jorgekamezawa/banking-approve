package com.btgpactual.banking.bankingApprove.domain.service

import com.btgpactual.banking.bankingApprove.domain.entity.Approval
import com.btgpactual.banking.bankingApprove.domain.entity.ObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.User
import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceApprovalDatabaseRepository
import com.btgpactual.banking.bankingApprove.domain.service.`interface`.InterfaceApprovalService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ApprovalService(
    private val approvalDatabaseRepository: InterfaceApprovalDatabaseRepository
) : InterfaceApprovalService {

    override fun initializeApproval(
        objectApproval: ObjectApproval,
        objectUnderAnalysisId: String,
        user: User
    ): Approval =
        Approval(
            objectApproval = objectApproval,
            userRequestedApproval = user,
            objectUnderAnalysisId = objectUnderAnalysisId,
            status = StatusApprovalEnum.PENDING_APPROVAL,
            dateTimeLastUpdateOfStatus = LocalDateTime.now()
        )

    override fun registerApproval(approval: Approval): Approval {
        return approvalDatabaseRepository.registerApproval(approval)
    }

    override fun getApprovalByStatus(status: StatusApprovalEnum): List<Approval> {
        return approvalDatabaseRepository.getApprovalByStatus(status)
    }
}