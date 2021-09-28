package tech.kargo.utilities.ui.alert

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

abstract class BaseAlert(context: Context) : AlertDialog(context) {

    abstract fun getLayoutId() : Int
    abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initialize()
    }
}