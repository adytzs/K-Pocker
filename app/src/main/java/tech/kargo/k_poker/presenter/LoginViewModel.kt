package tech.kargo.k_poker.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.kargo.k_poker.domain.user.LoginUseCase
import java.lang.Exception

class LoginViewModel(var loginUseCase: LoginUseCase) : ViewModel() {

    val uiState: MutableLiveData<Int> = MutableLiveData()
    val errorAlert: MutableLiveData<String> = MutableLiveData()

    fun doLogin(username: String, password: String) {
        try {
            loginUseCase.execute(username, password)
            uiState.postValue(1)
        } catch (e: Exception) {
            errorAlert.postValue(e.toString())
        }
    }
}