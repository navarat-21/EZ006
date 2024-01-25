package com.example.ez006

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ez006.databinding.ActivitySignupBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        databaseHelper = DatabaseHelper(this)

        binding.loginButton
        val loginUsername = binding.loginUsername.text.toString()
        val loginPassword = binding.loginPassword.text.toString()
        loginDatabase(loginUsername, loginPassword)
    }
    binding.loginRedirect.setOnClickListener {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
        finish()
    }


    }

    private fun loginDatabase(username: String, password: String){
        val userExists = databaseHelper.readUser(username, password)
        if (userExists){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }


}