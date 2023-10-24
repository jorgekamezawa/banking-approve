package com.btgpactual.banking.bankingApprove.infra.database.entity

import com.btgpactual.banking.bankingApprove.domain.entity.ApproverRole
import com.btgpactual.banking.bankingApprove.domain.enum.PriorityApprovalEnum
import javax.persistence.*

@Entity
@Table(name = "tb_approver_role")
data class ApproverRoleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @ManyToMany
    @JoinTable(
        name = "approver_role_area_approver",
        joinColumns = [JoinColumn(name = "approver_role_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "area_approver_id", referencedColumnName = "id")]
    )
    val areaApproverEntityList: List<AreaApproverEntity>,
    @ManyToMany
    @JoinTable(
        name = "approver_role_profile_approver",
        joinColumns = [JoinColumn(name = "approver_role_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "profile_approver_id", referencedColumnName = "id")]
    )
    val profileApproverEntityList: List<ProfileApproverEntity>,
    @ManyToMany
    @JoinTable(
        name = "approver_role_user_approver",
        joinColumns = [JoinColumn(name = "approver_role_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "user_approver_id", referencedColumnName = "id")]
    )
    val userApproverEntityList: List<UserEntity>,
    @Column(name = "quantity_approval")
    val quantityApproval: Long,
    @Enumerated(EnumType.STRING)
    @Column(name = "priority_approval")
    val priorityApproval: PriorityApprovalEnum,
    @ManyToOne
    @JoinColumn(name = "object_approval_id", referencedColumnName = "id")
    var objectApprovalEntity: ObjectApprovalEntity? = null
)

fun ApproverRoleEntity.toDomain(): ApproverRole =
    ApproverRole(
        id = id,
        areaApprover = areaApproverEntityList.map { it.toDomain() },
        profileApprover = profileApproverEntityList.map { it.toDomain() },
        userApprover = userApproverEntityList.map { it.toDomain() },
        quantityApproval = quantityApproval,
        priorityApproval = priorityApproval
    )

fun ApproverRole.toEntity(): ApproverRoleEntity =
    ApproverRoleEntity(
        id = id,
        areaApproverEntityList = areaApprover.map { it.toEntity() },
        profileApproverEntityList = profileApprover.map { it.toEntity() },
        userApproverEntityList = userApprover.map { it.toEntity() },
        quantityApproval = quantityApproval,
        priorityApproval = priorityApproval
    )

fun ApproverRoleEntity.addObjectApprovalEntity(objectApprovalEntity: ObjectApprovalEntity) {
    this.objectApprovalEntity = objectApprovalEntity
}
