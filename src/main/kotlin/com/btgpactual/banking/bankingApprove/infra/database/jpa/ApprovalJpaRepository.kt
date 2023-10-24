package com.btgpactual.banking.bankingApprove.infra.database.jpa

import com.btgpactual.banking.bankingApprove.domain.enum.StatusApprovalEnum
import com.btgpactual.banking.bankingApprove.infra.database.entity.ApprovalEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ApprovalJpaRepository : JpaRepository<ApprovalEntity, Long> {
    fun findByStatus(status: StatusApprovalEnum): List<ApprovalEntity>
//    @Query("SELECT a FROM ApprovalEntity a WHERE " +
//            "a.status = :status" +
//            "a.objectApprovalEntity.approverRoleEntityList.areaApproverEntityList.name = :area")
//    fun getApprovalByStatusAndAreaAndProfile(
//        @Param("status") status: StatusApprovalEnum,
//        @Param("area") area: String,
//        @Param("profile") profile: String
//    ): List<ApprovalEntity>
}
