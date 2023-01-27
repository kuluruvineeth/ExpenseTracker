package com.kuluruvineeth.expensetracker.domain.usecase.read_database

import com.kuluruvineeth.expensetracker.data.local.entity.AccountDto
import com.kuluruvineeth.expensetracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(private val repo: TransactionRepository) {

    operator fun invoke(account: String): Flow<AccountDto> {
        return repo.getAccount(account)
    }
}