package com.example.mobilecodingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var user_name: String = ""
    var passw: String = ""
    
    //TextWatcher object
    private var mTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            //set value of user_name and passw
            user_name = username.text.toString()
            passw = password.text.toString()
            //check whether username or password is empty
            loginBtn.isEnabled = !(user_name.isEmpty() || passw.isEmpty())
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //set listeners
        username.addTextChangedListener(mTextWatcher)
        password.addTextChangedListener(mTextWatcher)
    }

}