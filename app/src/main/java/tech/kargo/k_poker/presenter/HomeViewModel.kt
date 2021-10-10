package tech.kargo.k_poker.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.kargo.k_poker.domain.user.LogoutUseCase

class HomeViewModel(var logoutUseCase: LogoutUseCase) : ViewModel() {

    val uiState: MutableLiveData<Int> = MutableLiveData()

    fun doLogout() {
        logoutUseCase.execute()
        uiState.postValue(1)
    }
}