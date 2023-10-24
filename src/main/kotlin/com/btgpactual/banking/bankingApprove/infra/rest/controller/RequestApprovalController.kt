package com.btgpactual.banking.bankingApprove.infra.rest.controller

import com.btgpactual.banking.bankingApprove.application.dto.RequestApprovalDto
import com.btgpactual.banking.bankingApprove.application.usecase.`interface`.InterfaceRequestApproval
import com.btgpactual.banking.bankingApprove.application.view.RequestApprovalView
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/approval")
class RequestApprovalController(
    private val requestApproval: InterfaceRequestApproval
) {

    @PostMapping
    fun requestApproval(@RequestBody requestApprovalDto: RequestApprovalDto): ResponseEntity<RequestApprovalView> {
        val registerApproval = requestApproval.registerApproval(requestApprovalDto)
        return ResponseEntity.ok(registerApproval)
    }

    @GetMapping("/pending")
    fun getApprovalPending(
        @RequestParam login: String,
        @RequestParam area: String,
        @RequestParam profile: String
    ): ResponseEntity<List<RequestApprovalView>> {
        val registerApprovalList: List<RequestApprovalView> = requestApproval.getApprovalPending(login, profile, area)
        return ResponseEntity.ok(registerApprovalList)
    }
}