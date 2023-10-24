package com.btgpactual.banking.bankingApprove.domain.service.`interface`

import com.btgpactual.banking.bankingApprove.domain.entity.Approval
import com.btgpactual.banking.bankingApprove.domain.entity.ObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.User
import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum

interface InterfaceApprovalService {
    fun initializeApproval(objectApproval: ObjectApproval, objectUnderAnalysisId: String, user: User): Approval
    fun registerApproval(approval: Approval): Approval
    fun getApprovalByStatus(status: StatusApprovalEnum): List<Approval>
}
