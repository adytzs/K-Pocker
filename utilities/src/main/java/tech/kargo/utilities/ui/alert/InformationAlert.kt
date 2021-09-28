package tech.kargo.utilities.ui.alert

import android.content.Context
import kotlinx.android.synthetic.main.alert_information.*
import tech.kargo.utilities.R

class InformationAlert(context: Context, var title: String, var message: String) : BaseAlert(context) {

    override fun getLayoutId(): Int {
        return R.layout.alert_information
    }

    override fun initialize() {
        titleTextView.text = title
        messageTextView.text = message
    }
}