package com.udacity.shoestore.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    fun login(email: String, password: String) {
        Log.d(TAG, "login: Email: $email, Password: $password")
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}

