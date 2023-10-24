package com.btgpactual.banking.bankingApprove.infra.database.impl

import com.btgpactual.banking.bankingApprove.domain.entity.User
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceUserDatabaseRepository
import com.btgpactual.banking.bankingApprove.infra.database.entity.toDomain
import com.btgpactual.banking.bankingApprove.infra.database.jpa.UserJpaRepository
import org.springframework.stereotype.Component

@Component
class UserDatabaseRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : InterfaceUserDatabaseRepository {
    override fun getByLogin(login: String): User {
        return userJpaRepository.findByLogin(login).toDomain()
    }
}