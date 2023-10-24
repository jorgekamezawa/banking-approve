package com.btgpactual.banking.bankingApprove.domain.service

import com.btgpactual.banking.bankingApprove.domain.entity.User
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceUserDatabaseRepository
import com.btgpactual.banking.bankingApprove.domain.service.`interface`.InterfaceUserService
import org.springframework.stereotype.Component

@Component
class UserService(
    private val userDatabaseRepository: InterfaceUserDatabaseRepository
) : InterfaceUserService {
    override fun getByLogin(login: String): User {
        return userDatabaseRepository.getByLogin(login)
    }
}