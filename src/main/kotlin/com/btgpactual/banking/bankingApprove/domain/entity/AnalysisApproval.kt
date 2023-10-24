package com.btgpactual.banking.bankingApprove.domain.entity

import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum

data class AnalysisApproval(
    val id: Long? = null,
    val approver: User,
    val statusAnalysis: StatusApprovalEnum,
    val reasonRefusal: String? = null
)
