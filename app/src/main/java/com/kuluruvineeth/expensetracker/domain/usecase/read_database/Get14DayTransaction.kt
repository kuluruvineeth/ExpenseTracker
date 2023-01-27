package com.kuluruvineeth.expensetracker.domain.usecase.read_database

import com.kuluruvineeth.expensetracker.data.local.entity.TransactionDto
import com.kuluruvineeth.expensetracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Get14DayTransaction @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    operator fun invoke(transactionType: String) : Flow<List<TransactionDto>> {
        return transactionRepository.get14DayTransaction(transactionType)
    }
}