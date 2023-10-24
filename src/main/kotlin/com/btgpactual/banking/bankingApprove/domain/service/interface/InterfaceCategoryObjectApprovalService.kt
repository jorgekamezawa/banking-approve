package com.btgpactual.banking.bankingApprove.domain.service.`interface`

import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval

interface InterfaceCategoryObjectApprovalService {
    fun getCategoryObjectApprovalByListOfNames(nameList: List<String>): List<CategoryObjectApproval>
}
