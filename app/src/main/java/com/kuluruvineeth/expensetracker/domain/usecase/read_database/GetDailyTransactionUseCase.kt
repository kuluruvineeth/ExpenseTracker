package com.kuluruvineeth.expensetracker.domain.usecase.read_database

import com.kuluruvineeth.expensetracker.data.local.entity.TransactionDto
import com.kuluruvineeth.expensetracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDailyTransactionUseCase @Inject constructor(private val repo: TransactionRepository) {

    operator fun invoke(entryDate: String): Flow<List<TransactionDto>?> {
        return repo.getDailyTransaction(entryDate)
    }
}