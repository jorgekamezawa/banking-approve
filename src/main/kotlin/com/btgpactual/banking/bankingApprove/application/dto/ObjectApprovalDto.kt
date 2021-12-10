package com.btgpactual.banking.bankingApprove.application.dto

data class ObjectApprovalDto(
    val nameSystemRequestedApproval: String,
    val nameCategoryObjectApprovalList: List<String>,
    val name: String
)
