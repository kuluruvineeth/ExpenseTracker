package com.kuluruvineeth.expensetracker.presentation.setting_screen.service

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.kuluruvineeth.expensetracker.domain.usecase.write_datastore.EditExpenseLimitUseCase

class LimitResetWorker(context: Context, workParams: WorkerParameters, val editExpenseLimitUseCase: EditExpenseLimitUseCase) :
    CoroutineWorker(context, workParams) {
    override suspend fun doWork(): Result {
        editExpenseLimitUseCase(0.0)
        return Result.success()
    }
}