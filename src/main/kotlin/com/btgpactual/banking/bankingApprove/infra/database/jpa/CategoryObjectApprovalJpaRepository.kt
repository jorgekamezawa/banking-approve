package com.btgpactual.banking.bankingApprove.infra.database.jpa

import com.btgpactual.banking.bankingApprove.infra.database.entity.CategoryObjectApprovalEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryObjectApprovalJpaRepository : JpaRepository<CategoryObjectApprovalEntity, Long> {
    fun findByNameIn(nameList: List<String>): List<CategoryObjectApprovalEntity>
}
