package com.elitecodecamp.mausam.presentation.sign_in

data class SignInState(
    val isSignInSuccess: Boolean = false,
    val signInError: String? = null
)
