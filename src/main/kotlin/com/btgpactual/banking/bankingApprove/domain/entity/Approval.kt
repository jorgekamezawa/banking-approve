package com.btgpactual.banking.bankingApprove.domain.entity

import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum
import java.time.LocalDateTime
import java.util.Collections.emptyList

data class Approval(
    val idApproval: Long? = null,
    val objectApproval: ObjectApproval,
    val userRequestedApproval: User,
    val objectUnderAnalysisId: String = "",
    val analysisApprovalList: List<AnalysisApproval> = emptyList(),
    val status: StatusApprovalEnum,
    val dateTimeLastUpdateOfStatus: LocalDateTime
)
