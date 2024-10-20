package com.assessmentfinal.assessmentfinal.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.assessmentfinal.assessmentfinal.R
import com.assessmentfinal.assessmentfinal.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        val usernameInput = findViewById<EditText>(R.id.username)
        val passwordInput = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            val location = "sydney" // Set location dynamically if needed

            viewModel.login(username, password, location)
        }

        viewModel.loginResult.observe(this) { result ->
            result.onSuccess { loginResponse ->
                // Ensuring loginResponse is of type LoginResponse and contains keypass
                handleLoginSuccess(loginResponse.keypass)
            }.onFailure { exception ->
                // Handle failure
                Toast.makeText(this, "Wrong Username or Password! Try Again: ${exception.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun handleLoginSuccess(keypass: String) {
        val intent = Intent(this, DashboardActivity::class.java)
        intent.putExtra("KEYPASS", keypass) // Pass keypass to the next activity
        startActivity(intent)


    }
}