package tech.kargo.utilities.ui.alert

import android.content.Context
import tech.kargo.utilities.R

class LoadingAlert(context: Context) : BaseAlert(context) {

    override fun getLayoutId(): Int {
        return R.layout.alert_loading
    }

    override fun initialize() {

    }
}