package info.sergeikolinichenko.cryptorates.di

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

/** Created by Sergei Kolinichenko on 25.11.2022 at 17:33 (GMT+3) **/

interface ChildWorkerFactory {

    fun create(
        context: Context,
        workerParameters: WorkerParameters
    ): ListenableWorker
}