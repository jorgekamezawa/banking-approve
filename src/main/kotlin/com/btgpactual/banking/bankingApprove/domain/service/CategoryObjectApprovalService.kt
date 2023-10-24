package com.btgpactual.banking.bankingApprove.domain.service

import com.btgpactual.banking.bankingApprove.domain.entity.CategoryObjectApproval
import com.btgpactual.banking.bankingApprove.domain.repository.InterfaceCategoryObjectApprovalDatabaseRepository
import com.btgpactual.banking.bankingApprove.domain.service.`interface`.InterfaceCategoryObjectApprovalService
import org.springframework.stereotype.Service

@Service
class CategoryObjectApprovalService(
    private val interfaceCategoryObjectApprovalDatabaseRepository: InterfaceCategoryObjectApprovalDatabaseRepository
): InterfaceCategoryObjectApprovalService {
    override fun getCategoryObjectApprovalByListOfNames(nameList: List<String>): List<CategoryObjectApproval> {
        return interfaceCategoryObjectApprovalDatabaseRepository.getCategoryObjectApprovalByListOfNames(nameList)
    }
}