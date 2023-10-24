package com.btgpactual.banking.bankingApprove.infra.database.entity

import com.btgpactual.banking.bankingApprove.domain.entity.Approval
import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_approval")
class ApprovalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val idApproval: Long? = null,
    @ManyToOne
    @JoinColumn(name = "object_approval_id", referencedColumnName = "id")
    val objectApprovalEntity: ObjectApprovalEntity,
    @ManyToOne
    @JoinColumn(name = "user_requested_approval_id", referencedColumnName = "id")
    val userRequestedApproval: UserEntity,
    @Column(name = "object_under_analysis_id")
    val objectUnderAnalysisId: String,
    @Enumerated(EnumType.STRING)
    val status: StatusApprovalEnum,
    @Column(name = "date_time_last_update_of_status")
    val dateTimeLastUpdateOfStatus: LocalDateTime
)

fun ApprovalEntity.toDomain(): Approval =
    Approval(
        idApproval = idApproval,
        objectApproval = objectApprovalEntity.toDomain(),
        userRequestedApproval = userRequestedApproval.toDomain(),
        objectUnderAnalysisId = objectUnderAnalysisId,
        status = status,
        dateTimeLastUpdateOfStatus = dateTimeLastUpdateOfStatus
    )

fun Approval.toEntity(): ApprovalEntity =
    ApprovalEntity(
        idApproval = idApproval,
        objectApprovalEntity = objectApproval.toEntity(),
        userRequestedApproval = userRequestedApproval.toEntity(),
        objectUnderAnalysisId = objectUnderAnalysisId,
        status = status,
        dateTimeLastUpdateOfStatus = dateTimeLastUpdateOfStatus
    )
