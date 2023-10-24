package com.btgpactual.banking.bankingApprove.infra.database.entity

import com.btgpactual.banking.bankingApprove.domain.entity.User
import javax.persistence.*

@Entity
@Table(name = "tb_user")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @Column(name = "name")
    val name: String,
    @Column(name = "login")
    val login: String,
    @Column(name = "email")
    val email: String,
    @ManyToMany(mappedBy = "userApproverEntityList")
    val approvalRoleEntityList: List<ApproverRoleEntity> = emptyList()
)

fun UserEntity.toDomain(): User =
    User(
        id = id,
        name = name,
        login = login,
        email = email
    )

fun User.toEntity(): UserEntity =
    UserEntity(
        id = id,
        name = name,
        login = login,
        email = email
    )
