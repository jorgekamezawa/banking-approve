package com.btgpactual.banking.bankingApprove.infra.database.entity

import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval
import javax.persistence.*

@Entity
@Table(name = "tb_category_object_approval")
data class CategoryObjectApprovalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @Column(name = "name")
    val name: String,
    @ManyToMany(mappedBy = "categoryObjectApprovalEntityList")
    val objectApprovalEntityList: List<ObjectApprovalEntity> = emptyList()
)

fun CategoryObjectApprovalEntity.toDomain(): CategoryObjectApproval =
    CategoryObjectApproval(
        id = id,
        name = name
    )

fun CategoryObjectApproval.toEntity(): CategoryObjectApprovalEntity =
    CategoryObjectApprovalEntity(
        id = id,
        name = name
    )
