package com.kuluruvineeth.expensetracker.domain.usecase.write_database

import com.kuluruvineeth.expensetracker.data.local.entity.AccountDto
import com.kuluruvineeth.expensetracker.domain.repository.TransactionRepository
import javax.inject.Inject

class InsertAccountsUseCase @Inject constructor(private val repo: TransactionRepository) {

    suspend operator fun invoke(account: List<AccountDto>) {
        repo.insertAccount(account)
    }
}