package com.btgpactual.banking.bankingApprove.domain.entity

import com.btgpactual.banking.bankingApprove.domain.enum.PriorityApprovalEnum

data class ApproverRole(
    val id: Long,
    val areaApprover: List<AreaApprover>,
    val profileApprover: List<ProfileApprover>,
    val userApprover: List<User>,
    val quantityApproval: Long,
    val priorityApproval: PriorityApprovalEnum
)
