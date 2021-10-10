package tech.kargo.k_poker.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tech.kargo.k_poker.cache.user.AuthCache
import tech.kargo.k_poker.data.AuthRepository
import tech.kargo.k_poker.domain.user.CheckUserLoggedInUseCase
import tech.kargo.k_poker.domain.user.LoginUseCase
import tech.kargo.k_poker.domain.user.LogoutUseCase
import tech.kargo.k_poker.presenter.HomeViewModel
import tech.kargo.k_poker.presenter.LoginViewModel
import tech.kargo.k_poker.presenter.SplashViewModel
import tech.kargo.k_poker.remote.user.AuthRemote
import tech.kargo.utilities.cache.CacheSharedPreferences

val cacheModule = module {
    single { CacheSharedPreferences(androidContext()) }
    factory { AuthCache(get()) }
}

val remoteModule = module {
    factory { AuthRemote() }
}

val dataModule = module {
    factory { AuthRepository(get(), get()) }
}

val domainModule = module {
    factory { CheckUserLoggedInUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { LogoutUseCase(get()) }
}

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}