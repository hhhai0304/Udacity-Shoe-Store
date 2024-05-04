package com.hohoanghai.shoestore.fragment.login

data class LoginState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isSuccess: Boolean = false,
)