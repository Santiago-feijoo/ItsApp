package com.example.itsapp.create_account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.itsapp.databinding.ActivityCreateAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateAccountActivity : AppCompatActivity() {
    /** ATRIBUTOS **/
    private lateinit var binding: ActivityCreateAccountBinding

    /** METODOS **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()

    }

    private fun initComponents() {
        initListener()

    }

    private fun initListener() {
        binding.toolbarCreateAccount.setNavigationOnClickListener {
            this.finish()

        }

    }

}