package com.konrad.intership12026.di

import com.konrad.network.di.module.NetworkModule
import org.koin.core.annotation.KoinApplication
import org.koin.dsl.KoinAppDeclaration
import org.koin.plugin.module.dsl.startKoin

@KoinApplication(modules = [AppModule::class, PlatformModule::class, NetworkModule::class])
class KoinApp

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin<KoinApp> {
        config?.invoke(this)
    }
}