package com.example.loginsignupauth.ui

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import com.example.loginsignupauth.data.network.Resource
import com.example.loginsignupauth.ui.auth.LoginFragment
import com.example.loginsignupauth.ui.base.BaseFragment
import com.google.android.material.snackbar.Snackbar

fun <A : Activity> Activity.startNewActivity(activity: Class<A>){
    Intent(this, activity).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }
}

fun View.visible(isVisible: Boolean){
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enabled: Boolean){
    isEnabled = enabled
    alpha = if (enabled) 1f else 0.5f
    //alpha value 1f means visible and 0.5f means semi-disabled
}

fun View.snackBar(
    message: String,
    action: (() -> Unit)? =null
){
    val snackBar = Snackbar.make(this,message,Snackbar.LENGTH_LONG)
    action?.let {
        snackBar.setAction("Retry"){
            it()
        }
    }
    snackBar.show()
}
fun Fragment.handleApiError(
    failure: Resource.Failure,
    retry: (() -> Unit)? = null
){
    when {
        failure.isNetworkError == true -> requireView().snackBar("Please check your internet connection", retry)
        failure.errorCode == 401 -> {
            if(this is LoginFragment){
                requireView().snackBar("You have entered incorrect credentials")
            }
            else{
                //@todo perform logout here
                (this as BaseFragment<*,*,*>).logout()
            }
        }
        else -> {
            val error = failure.errorBody?.string().toString()
            requireView().snackBar(error)
        }
    }
}
