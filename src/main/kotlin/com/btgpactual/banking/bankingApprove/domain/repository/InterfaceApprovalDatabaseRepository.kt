package com.btgpactual.banking.bankingApprove.domain.repository

import com.btgpactual.banking.bankingApprove.domain.entity.Approval
import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum

interface InterfaceApprovalDatabaseRepository {
    fun registerApproval(approval: Approval): Approval
    fun getApprovalByStatus(status: StatusApprovalEnum): List<Approval>
}
