package tech.kargo.k_poker.ui.activity

import android.content.Intent
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import tech.kargo.k_poker.R
import tech.kargo.k_poker.presenter.LoginViewModel
import tech.kargo.utilities.ui.activity.BaseActivity

class LoginActivity : BaseActivity(R.layout.activity_login) {

    private val vm: LoginViewModel by viewModel()

    override fun initialize() {
        vm.errorAlert.observe(this, Observer {
            showErrorDialog(it)
        })

        vm.uiState.observe(this, Observer {
            val intent = when(it) {
                1 -> Intent(this@LoginActivity, HomeActivity::class.java)
                else -> null
            }

            intent?.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent?.let { activityIntent ->
                activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(activityIntent)
            }
        })


        loginButton.setOnClickListener {
            vm.doLogin(usernameEditText.text.toString(), passwordEditText.text.toString())
        }
    }
}