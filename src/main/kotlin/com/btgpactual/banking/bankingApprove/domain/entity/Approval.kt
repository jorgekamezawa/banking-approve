package com.btgpactual.banking.bankingApprove.domain.entity

import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum
import java.time.LocalDateTime

data class Approval(
    val idApproval: Long,
    val objectApproval: ObjectApproval,
    val objectUnderAnalysisId: String,
    val status: StatusApprovalEnum,
    val dateTimeLastUpdateOfStatus: LocalDateTime
)
