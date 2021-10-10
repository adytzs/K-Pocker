package tech.kargo.k_poker.ui.activity


import android.content.Intent
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import tech.kargo.k_poker.R
import tech.kargo.k_poker.presenter.HomeViewModel
import tech.kargo.utilities.ui.activity.BaseActivity

class HomeActivity : BaseActivity(R.layout.activity_home) {

    private val vm: HomeViewModel by viewModel()

    override fun initialize() {
        vm.uiState.observe(this, Observer {
            val intent = when(it) {
                1 -> Intent(this@HomeActivity, LoginActivity::class.java)
                else -> null
            }

            intent?.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent?.let { activityIntent ->
                activityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(activityIntent)
            }
        })

        logoutButton.setOnClickListener {
            vm.doLogout()
        }
    }
}