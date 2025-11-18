package com.example.a23012021079_darshan_kotadiya_madproject

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }


        findViewById<TextView>(R.id.txtForgotPassword).setOnClickListener {
            // TODO: Handle forgot password action
        }
    }
}
