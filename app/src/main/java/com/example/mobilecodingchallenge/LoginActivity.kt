package com.example.mobilecodingchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var username: String = ""
    var password: String = ""
    private val passwordPattern =
        Regex("(((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*?)(?=.*!)(?=.*_)(?=.*@)).{5,})")
    private val usernamePattern = Regex("[A-Za-z0-9]+")

    //TextWatcher object
    private var mTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            //set value of user_name and passw
            username = usernameEdt.text.toString()
            password = passwordEdt.text.toString()

            //check whether username or password is empty
            val isUsernameValid: Boolean = checkUsername(username)
            val isPasswordValid: Boolean = checkPassword(password)
            loginBtn.isEnabled = isPasswordValid && isUsernameValid
            Log.e("Done", "${loginBtn.isEnabled}")
        }

    }

    private fun checkUsername(userName: String): Boolean {
        if (userName.isEmpty()) {
            return false
        }
        if (!usernamePattern.matches(userName)) {
            usernameEdt.error = "Enter proper user name"
            return false
        }
        return true
    }

    private fun checkPassword(password: String): Boolean {
        if (password.isEmpty()) {
            return false
        }
        if (password.length < 5 || !passwordPattern.matches(password)) {
            passwordEdt.error = "Password not meeting the criteria"
            return false
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //set listeners
        usernameEdt.addTextChangedListener(mTextWatcher)
        passwordEdt.addTextChangedListener(mTextWatcher)

        //Start Main Activity on Clicking the Login Button
        loginBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}