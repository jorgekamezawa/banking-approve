package com.btgpactual.banking.bankingApprove.domain.service

import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.ObjectApproval
import com.btgpactual.banking.bankingApprove.domain.entity.SystemRequestedApproval
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceObjectApprovalDatabaseRepository
import com.btgpactual.banking.bankingApprove.domain.service.`interface`.InterfaceObjectApprovalService
import org.springframework.stereotype.Service

@Service
class ObjectApprovalService(
    private val objectApprovalDatabaseRepository: InterfaceObjectApprovalDatabaseRepository
) : InterfaceObjectApprovalService {
    override fun getObjectApprovalBySystemRequestedAndListOfCategoryObjectAndName(
        systemRequestedApproval: SystemRequestedApproval,
        categoryObjectApprovalList: List<CategoryObjectApproval>,
        name: String
    ): ObjectApproval {
        return objectApprovalDatabaseRepository.getObjectApprovalBySystemRequestedAndListOfCategoryObjectAndName(
            systemRequestedApproval,
            categoryObjectApprovalList,
            name
        )
    }
}