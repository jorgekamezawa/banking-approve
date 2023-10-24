package com.btgpactual.banking.bankingApprove.domain.repository

import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval

interface InterfaceCategoryObjectApprovalDatabaseRepository {
    fun getCategoryObjectApprovalByListOfNames(nameList: List<String>): List<CategoryObjectApproval>
}
