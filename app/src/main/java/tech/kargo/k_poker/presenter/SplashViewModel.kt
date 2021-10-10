package tech.kargo.k_poker.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tech.kargo.k_poker.domain.user.CheckUserLoggedInUseCase

class SplashViewModel(var checkUserLoggedInUseCase: CheckUserLoggedInUseCase) : ViewModel() {

    val uiState: MutableLiveData<Int> = MutableLiveData()

    @DelicateCoroutinesApi
    fun initiate() {
        GlobalScope.launch {
            delay(2000L)
            if (checkUserLoggedInUseCase.execute()) {
                uiState.postValue(1)
            } else {
                uiState.postValue(0)
            }
        }
    }

}