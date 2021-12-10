package com.btgpactual.banking.bankingApprove.domain.service.`interface`

import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval

interface InterfaceSystemRequestedApprovalService {
    fun getSystemRequestedApprovalByName(name: String): SystemRequestedApproval
}
