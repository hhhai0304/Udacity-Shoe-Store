package com.hohoanghai.shoestore.fragment.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hohoanghai.shoestore.R
import com.hohoanghai.shoestore.UserManager

class LoginViewModel : ViewModel() {
    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState> = _loginState
    val edtUsernameText = MutableLiveData<String>()
    val edtPasswordText = MutableLiveData<String>()

    fun login() {
        if (!isUserNameValid(edtUsernameText.value ?: "")) {
            _loginState.value = LoginState(usernameError = R.string.invalid_username)
            return
        } else if (!isPasswordValid(edtPasswordText.value ?: "")) {
            _loginState.value = LoginState(passwordError = R.string.invalid_password)
            return
        }
        UserManager.username = edtUsernameText.value
        _loginState.value = LoginState(isSuccess = true)
    }

    private fun isUserNameValid(username: String): Boolean {
        return username.isNotBlank()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.isNotBlank()
    }
}