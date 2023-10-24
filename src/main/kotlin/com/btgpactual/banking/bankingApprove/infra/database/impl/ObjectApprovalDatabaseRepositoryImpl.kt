package com.btgpactual.banking.bankingApprove.infra.database.impl

import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.ObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceObjectApprovalDatabaseRepository
import com.btgpactual.banking.bankingApprove.infra.database.entity.toDomain
import com.btgpactual.banking.bankingApprove.infra.database.entity.toEntity
import com.btgpactual.banking.bankingApprove.infra.database.jpa.ObjectApprovalJpaRepository
import org.springframework.stereotype.Component

@Component
class ObjectApprovalDatabaseRepositoryImpl(
    private val objectApprovalJpaRepository: ObjectApprovalJpaRepository
) : InterfaceObjectApprovalDatabaseRepository {
    override fun getObjectApprovalBySystemRequestedAndListOfCategoryObjectAndName(
        systemRequestedApproval: SystemRequestedApproval,
        categoryObjectApprovalList: List<CategoryObjectApproval>,
        name: String
    ): ObjectApproval {
        return objectApprovalJpaRepository.findBySystemRequestedApprovalEntityAndCategoryObjectApprovalEntityListInAndName(
            systemRequestedApproval.toEntity(),
            categoryObjectApprovalList.map { it.toEntity() },
            name
        ).toDomain()
//        TODO()
    }
}