package com.btgpactual.banking.bankingApprove.infra.database.jpa

import com.btgpactual.banking.bankingApprove.infra.database.entity.SystemRequestedApprovalEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SystemRequestApprovalJpaRepository : JpaRepository<SystemRequestedApprovalEntity, Long> {
    fun findByName(name: String): SystemRequestedApprovalEntity
}
