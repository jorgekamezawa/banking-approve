package com.btgpactual.banking.bankingApprove.domain.entity

data class ObjectApproval (
    val id: Long,
    val systemRequestedApproval: SystemRequestedApproval,
    val categoryObjectApprovalList: List<CategoryObjectApproval>,
    val name: String,
    val approverTypeList: List<ApproverType>
)
