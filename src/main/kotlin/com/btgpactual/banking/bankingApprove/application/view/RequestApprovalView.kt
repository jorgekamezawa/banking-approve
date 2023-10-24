package com.btgpactual.banking.bankingApprove.application.view

import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum

data class RequestApprovalView(
    val nameObjectApproval: String,
    val category: List<String>,
    val nameSystemRequestedApproval: String,
    val loginUserRequestedApproval: String,
    val objectUnderAnalysisId: String,
    val status: StatusApprovalEnum
)
