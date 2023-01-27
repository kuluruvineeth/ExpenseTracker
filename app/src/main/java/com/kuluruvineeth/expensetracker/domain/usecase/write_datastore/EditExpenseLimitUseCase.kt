package com.kuluruvineeth.expensetracker.domain.usecase.write_datastore

import com.kuluruvineeth.expensetracker.domain.repository.DatastoreRepository
import javax.inject.Inject

class EditExpenseLimitUseCase @Inject constructor(private val datastoreRepository: DatastoreRepository) {
    suspend operator fun invoke(amount: Double) {
        datastoreRepository.writeExpenseLimitToDataStore(amount)
    }
}