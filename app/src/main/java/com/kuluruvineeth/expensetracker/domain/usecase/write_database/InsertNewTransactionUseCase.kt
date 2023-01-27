package com.kuluruvineeth.expensetracker.domain.usecase.write_database

import com.kuluruvineeth.expensetracker.data.local.entity.TransactionDto
import com.kuluruvineeth.expensetracker.domain.repository.TransactionRepository
import javax.inject.Inject

class InsertNewTransactionUseCase @Inject constructor(private val repo: TransactionRepository) {

    suspend operator fun invoke(dailyExpense: TransactionDto) {
        repo.insertTransaction(dailyExpense)
    }
}