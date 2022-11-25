package info.sergeikolinichenko.cryptorates.di

import androidx.lifecycle.ViewModel
import androidx.work.ListenableWorker
import dagger.MapKey
import kotlin.reflect.KClass

/** Created by Sergei Kolinichenko on 23.11.2022 at 20:17 (GMT+3) **/

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkerKey(val value: KClass<out ListenableWorker>)
