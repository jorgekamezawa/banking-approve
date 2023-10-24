package com.btgpactual.banking.bankingApprove.domain.service.`interface`

import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.ObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval

interface InterfaceObjectApprovalService {
    fun getObjectApprovalBySystemRequestedAndListOfCategoryObjectAndName(
        systemRequestedApproval: SystemRequestedApproval,
        categoryObjectApprovalList: List<CategoryObjectApproval>,
        name: String
    ): ObjectApproval
}
