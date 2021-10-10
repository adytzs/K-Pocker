package tech.kargo.k_poker.ui

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tech.kargo.k_poker.di.*

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(cacheModule)
            modules(remoteModule)
            modules(dataModule)
            modules(domainModule)
            modules(viewModelModule)
        }
    }
}