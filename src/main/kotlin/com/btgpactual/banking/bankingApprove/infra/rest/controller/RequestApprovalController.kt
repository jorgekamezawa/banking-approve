package com.btgpactual.banking.bankingApprove.infra.rest.controller

import com.btgpactual.banking.bankingApprove.application.usecase.`interface`.InterfaceRequestApproval
import com.btgpactual.banking.bankingApprove.application.view.RequestApprovalView
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/approval")
class RequestApprovalController(
    private val requestApproval: InterfaceRequestApproval
) {

    @PostMapping
    fun requestApproval(): ResponseEntity<RequestApprovalView> {
        return ResponseEntity.ok().build()
    }
}