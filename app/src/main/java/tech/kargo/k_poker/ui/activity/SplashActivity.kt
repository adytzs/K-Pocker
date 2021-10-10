package tech.kargo.k_poker.ui.activity

import android.content.Intent
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import tech.kargo.k_poker.R
import tech.kargo.k_poker.presenter.SplashViewModel
import tech.kargo.utilities.ui.activity.BaseActivity

class SplashActivity : BaseActivity(R.layout.activity_splash) {

    private val vm: SplashViewModel by viewModel()

    override fun initialize() {
        vm.uiState.observe(this, Observer {
            val intent = when(it) {
                1 -> Intent(this@SplashActivity, HomeActivity::class.java)
                0 -> Intent(this@SplashActivity, LoginActivity::class.java)
                else -> null
            }

            intent?.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent?.let { activityIntent ->
                activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(activityIntent)
            }
        })

        vm.initiate()

    }


}