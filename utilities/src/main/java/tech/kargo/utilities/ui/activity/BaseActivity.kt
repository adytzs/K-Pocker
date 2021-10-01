package tech.kargo.utilities.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.kargo.utilities.R
import tech.kargo.utilities.ui.alert.InformationAlert
import tech.kargo.utilities.ui.alert.LoadingAlert

abstract class BaseActivity(var layoutId: Int) : AppCompatActivity() {

    abstract fun initialize()

    var alertDialog: LoadingAlert? = null

    fun showLoading() {
        alertDialog?.dismiss()
        alertDialog = LoadingAlert(this)
        alertDialog!!.show()
    }

    fun hideLoading() {
        alertDialog?.dismiss()
    }

    fun showDialog(title: String, message: String) {
        val alert = InformationAlert(this, title, message)
        alert.show()
    }

    fun showSuccessDialog(message: String) {
        showDialog(getString(R.string.success), message)
    }

    fun showErrorDialog(message: String) {
        showDialog(getString(R.string.error), message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initialize()
    }

}