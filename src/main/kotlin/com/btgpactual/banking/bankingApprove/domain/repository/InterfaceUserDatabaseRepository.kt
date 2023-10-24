package com.btgpactual.banking.bankingApprove.domain.repository

import com.btgpactual.banking.bankingApprove.domain.entity.User

interface InterfaceUserDatabaseRepository {
    fun getByLogin(login: String): User
}
