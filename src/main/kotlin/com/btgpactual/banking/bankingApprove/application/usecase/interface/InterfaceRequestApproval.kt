package com.btgpactual.banking.bankingApprove.application.usecase.`interface`

import com.btgpactual.banking.bankingApprove.application.dto.RequestApprovalDto
import com.btgpactual.banking.bankingApprove.application.view.RequestApprovalView

interface InterfaceRequestApproval {
    fun registerApproval(requestApprovalDto: RequestApprovalDto): RequestApprovalView
    fun getApprovalPending(login: String, profile: String, area: String): List<RequestApprovalView>
}