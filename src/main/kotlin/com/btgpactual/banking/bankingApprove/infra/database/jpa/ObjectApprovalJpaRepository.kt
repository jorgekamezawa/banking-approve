package com.btgpactual.banking.bankingApprove.infra.database.jpa

import com.btgpactual.banking.bankingApprove.infra.database.entity.CategoryObjectApprovalEntity
import com.btgpactual.banking.bankingApprove.infra.database.entity.ObjectApprovalEntity
import com.btgpactual.banking.bankingApprove.infra.database.entity.SystemRequestedApprovalEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ObjectApprovalJpaRepository : JpaRepository<ObjectApprovalEntity, Long> {
    fun findBySystemRequestedApprovalEntityAndCategoryObjectApprovalEntityListInAndName(
        systemRequestedApprovalEntity: SystemRequestedApprovalEntity,
        categoryObjectApprovalEntityList: List<CategoryObjectApprovalEntity>,
        name: String
    ) : ObjectApprovalEntity
}
