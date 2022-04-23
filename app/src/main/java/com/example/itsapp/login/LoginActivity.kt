package com.example.itsapp.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.itsapp.BuildConfig
import com.example.itsapp.menu.MenuActivity
import com.example.itsapp.create_account.CreateAccountActivity
import com.example.itsapp.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity: AppCompatActivity() {
    /** ATRIBUTOS **/
    private lateinit var binding: ActivityLoginBinding

    /** METODOS **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()

    }

    private fun initComponents() {
        "Versión ${BuildConfig.VERSION_NAME}".apply {
            binding.textViewVersionApp.text = this

        }

        initListener()

    }

    private fun initListener() {
        binding.buttonLogin.setOnClickListener {
            intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

        }

        binding.textViewCreateAccount.setOnClickListener {
            intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)

        }

    }

}