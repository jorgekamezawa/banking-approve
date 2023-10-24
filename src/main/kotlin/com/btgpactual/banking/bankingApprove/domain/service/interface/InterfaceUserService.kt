package com.btgpactual.banking.bankingApprove.domain.service.`interface`

import com.btgpactual.banking.bankingApprove.domain.entity.User

interface InterfaceUserService {
    fun getByLogin(login: String): User
}
