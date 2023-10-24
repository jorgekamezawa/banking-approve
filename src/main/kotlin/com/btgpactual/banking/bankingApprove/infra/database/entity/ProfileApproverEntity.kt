package com.btgpactual.banking.bankingApprove.infra.database.entity

import com.btgpactual.banking.bankingApprove.domain.entity.ProfileApprover
import javax.persistence.*

@Entity
@Table(name = "tb_profile_approver")
data class ProfileApproverEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @Column(name = "name")
    val name: String,
    @ManyToMany(mappedBy = "profileApproverEntityList")
    val approvalRoleEntityList: List<ApproverRoleEntity> = emptyList()
)

fun ProfileApproverEntity.toDomain(): ProfileApprover =
    ProfileApprover(
        id = id,
        name = name
    )

fun ProfileApprover.toEntity(): ProfileApproverEntity =
    ProfileApproverEntity(
        id = id,
        name = name
    )
