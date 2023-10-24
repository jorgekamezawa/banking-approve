package com.btgpactual.banking.bankingApprove.infra.database.impl

import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceCategoryObjectApprovalDatabaseRepository
import com.btgpactual.banking.bankingApprove.infra.database.entity.toDomain
import com.btgpactual.banking.bankingApprove.infra.database.jpa.CategoryObjectApprovalJpaRepository
import org.springframework.stereotype.Component

@Component
class CategoryObjectApprovalDatabaseRepositoryImpl(
    private val categoryObjectApprovalJpaRepository: CategoryObjectApprovalJpaRepository
) : InterfaceCategoryObjectApprovalDatabaseRepository {

    override fun getCategoryObjectApprovalByListOfNames(nameList: List<String>): List<CategoryObjectApproval> {
        return categoryObjectApprovalJpaRepository.findByNameIn(nameList).map { it.toDomain() }
    }
}
