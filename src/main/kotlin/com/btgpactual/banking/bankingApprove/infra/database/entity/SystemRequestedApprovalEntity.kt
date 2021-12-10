package com.btgpactual.banking.bankingApprove.infra.database.entity

import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval
import javax.persistence.*

@Entity
@Table(name = "tb_system_requested_approval")
data class SystemRequestedApprovalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,
    @Column(name = "name")
    val name: String
)

fun SystemRequestedApprovalEntity.toDomain(): SystemRequestedApproval {
    return SystemRequestedApproval(
        id = id,
        name = name
    )
}
