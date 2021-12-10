package com.btgpactual.banking.bankingApprove.infra.database.impl

import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceSystemRequestedApprovalDatabaseRepository
import com.btgpactual.banking.bankingApprove.infra.database.entity.toDomain
import com.btgpactual.banking.bankingApprove.infra.database.jpa.SystemRequestApprovalJpaRepository
import org.springframework.stereotype.Component

@Component
class SystemRequestedApprovalDatabaseRepositoryImpl(
    private val systemRequestApprovalJpaRepository: SystemRequestApprovalJpaRepository
) : InterfaceSystemRequestedApprovalDatabaseRepository {
    override fun getSystemRequestedApprovalByName(name: String): SystemRequestedApproval {
        return systemRequestApprovalJpaRepository.findByName(name).toDomain()
    }
}