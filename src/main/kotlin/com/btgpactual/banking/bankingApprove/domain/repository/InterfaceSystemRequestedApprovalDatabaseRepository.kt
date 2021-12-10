package com.btgpactual.banking.bankingApprove.domain.repository

import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval

interface InterfaceSystemRequestedApprovalDatabaseRepository {
    fun getSystemRequestedApprovalByName(name: String): SystemRequestedApproval
}
