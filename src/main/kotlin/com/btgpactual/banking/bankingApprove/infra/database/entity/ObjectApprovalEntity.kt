package com.btgpactual.banking.bankingApprove.infra.database.entity

import com.btgpactual.banking.bankingApprove.domain.entity.ObjectApproval
import javax.persistence.*

@Entity
@Table(name = "tb_object_approval")
data class ObjectApprovalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @ManyToOne
    @JoinColumn(name = "system_requested_approval_id")
    val systemRequestedApprovalEntity: SystemRequestedApprovalEntity,
    @ManyToMany
    @JoinTable(
        name = "object_approval_category_object_approval",
        joinColumns = [JoinColumn(name = "objetc_approval_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "category_object_approval_id", referencedColumnName = "id")]
    )
    val categoryObjectApprovalEntityList: List<CategoryObjectApprovalEntity>,
    @Column(name = "name")
    val name: String,
    @OneToMany(mappedBy = "objectApprovalEntity", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val approverRoleEntityList: List<ApproverRoleEntity>
)

fun ObjectApprovalEntity.toDomain(): ObjectApproval =
    ObjectApproval(
        id = id,
        systemRequestedApproval = systemRequestedApprovalEntity.toDomain(),
        categoryObjectApprovalList = categoryObjectApprovalEntityList.map { it.toDomain() },
        name = name,
        approverRoleList = approverRoleEntityList.map { it.toDomain() }
    )

fun ObjectApprovalEntity.addApproverRoleEntity(approverRolerEntityList: List<ApproverRoleEntity>) {
    approverRolerEntityList.forEach {
        if (!this.approverRoleEntityList.contains(it)) {
            this.approverRoleEntityList.plus(it)
        }
        it.addObjectApprovalEntity(this)
    }
}

fun ObjectApproval.toEntity(): ObjectApprovalEntity =
    ObjectApprovalEntity(
        id = id,
        systemRequestedApprovalEntity = systemRequestedApproval.toEntity(),
        categoryObjectApprovalEntityList = categoryObjectApprovalList.map { it.toEntity() },
        name = name,
        approverRoleEntityList = approverRoleList.map { it.toEntity() }
    )


