package com.kuluruvineeth.expensetracker.domain.usecase.read_datastore

import com.kuluruvineeth.expensetracker.domain.repository.DatastoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLimitKeyUseCase @Inject constructor(
    private val datastoreRepository: DatastoreRepository
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return datastoreRepository.readLimitKeyFromDataStore()
    }
}