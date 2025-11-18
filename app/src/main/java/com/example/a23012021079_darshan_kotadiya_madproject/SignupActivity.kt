package com.example.a23012021079_darshan_kotadiya_madproject
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        findViewById<Button>(R.id.btnSignup).setOnClickListener {

            finish()
        }
    }
}
