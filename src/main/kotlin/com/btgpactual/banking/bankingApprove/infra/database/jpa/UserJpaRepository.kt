package com.btgpactual.banking.bankingApprove.infra.database.jpa

import com.btgpactual.banking.bankingApprove.infra.database.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository : JpaRepository<UserEntity, Long> {
    fun findByLogin(login: String): UserEntity
}
