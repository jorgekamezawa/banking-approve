package com.btgpactual.banking.bankingApprove.infra.database.entity

import com.btgpactual.banking.bankingApprove.domain.entity.AreaApprover
import javax.persistence.*

@Entity
@Table(name = "tb_area_approver")
data class AreaApproverEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @Column(name = "name")
    val name: String,
    @ManyToMany(mappedBy = "areaApproverEntityList")
    val approvalRoleEntityList: List<ApproverRoleEntity> = emptyList()
)

fun AreaApproverEntity.toDomain(): AreaApprover =
    AreaApprover(
        id = id,
        name = name
    )

fun AreaApprover.toEntity(): AreaApproverEntity =
    AreaApproverEntity(
        id = id,
        name = name
    )
