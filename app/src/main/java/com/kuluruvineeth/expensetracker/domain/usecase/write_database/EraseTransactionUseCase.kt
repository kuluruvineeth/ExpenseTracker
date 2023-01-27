package com.kuluruvineeth.expensetracker.domain.usecase.write_database

import com.kuluruvineeth.expensetracker.domain.repository.TransactionRepository
import javax.inject.Inject

class EraseTransactionUseCase @Inject constructor(
    private val repository: TransactionRepository
) {
    operator fun invoke() {
        repository.eraseTransaction()
    }
}