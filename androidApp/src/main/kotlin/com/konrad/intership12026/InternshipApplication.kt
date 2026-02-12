package com.konrad.intership12026

import android.app.Application
import com.konrad.intership12026.di.initKoin
import org.koin.android.ext.koin.androidContext

class InternshipApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@InternshipApplication)
        }
    }
}
