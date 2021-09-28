package tech.kargo.utilities.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.kargo.utilities.ui.activity.BaseActivity

abstract class BaseFragment : Fragment() {

    abstract fun getLayoutId() : Int
    abstract fun initialize()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        super.onViewCreated(view, savedInstanceState)
    }

    fun showLoading() {
        if (activity is BaseActivity) {
            (activity as BaseActivity).showLoading()
        }
    }

    fun hideLoading() {
        if (activity is BaseActivity) {
            (activity as BaseActivity).hideLoading()
        }
    }

    fun showDialog(title: String, message: String) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).showDialog(title, message)
        }
    }

    fun showSuccessDialog(message: String) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).showSuccessDialog(message)
        }
    }

    fun showErrorDialog(message: String) {
        if (activity is BaseActivity) {
            (activity as BaseActivity).showErrorDialog(message)
        }
    }

}