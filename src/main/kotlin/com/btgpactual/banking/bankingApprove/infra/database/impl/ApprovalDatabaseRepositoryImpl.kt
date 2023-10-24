package com.btgpactual.banking.bankingApprove.infra.database.impl

import com.btgpactual.banking.bankingApprove.domain.entity.Approval
import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceApprovalDatabaseRepository
import com.btgpactual.banking.bankingApprove.infra.database.entity.toDomain
import com.btgpactual.banking.bankingApprove.infra.database.entity.toEntity
import com.btgpactual.banking.bankingApprove.infra.database.jpa.ApprovalJpaRepository
import org.springframework.stereotype.Component

@Component
class ApprovalDatabaseRepositoryImpl(
    private val approvalJpaRepository: ApprovalJpaRepository
) : InterfaceApprovalDatabaseRepository {
    override fun registerApproval(approval: Approval): Approval {
        return approvalJpaRepository.save(approval.toEntity()).toDomain()
    }

    override fun getApprovalByStatus(status: StatusApprovalEnum): List<Approval> {
        return approvalJpaRepository.findByStatus(status).map { it.toDomain() }
    }
}