package com.btgpactual.banking.bankingApprove.domain.service

import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceSystemRequestedApprovalDatabaseRepository
import com.btgpactual.banking.bankingApprove.domain.service.`interface`.InterfaceSystemRequestedApprovalService

class SystemRequestedApprovalService(
    private val systemRequestedApprovalDatabaseRepository: InterfaceSystemRequestedApprovalDatabaseRepository
) : InterfaceSystemRequestedApprovalService {
    override fun getSystemRequestedApprovalByName(name: String): SystemRequestedApproval {
        return systemRequestedApprovalDatabaseRepository.getSystemRequestedApprovalByName(name)
    }
}