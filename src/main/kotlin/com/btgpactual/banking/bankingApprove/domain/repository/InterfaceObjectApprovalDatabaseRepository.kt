package com.btgpactual.banking.bankingApprove.domain.repository

import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.ObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval

interface InterfaceObjectApprovalDatabaseRepository {
    fun getObjectApprovalBySystemRequestedAndListOfCategoryObjectAndName(
        systemRequestedApproval: SystemRequestedApproval,
        categoryObjectApprovalList: List<CategoryObjectApproval>,
        name: String
    ): ObjectApproval
}
