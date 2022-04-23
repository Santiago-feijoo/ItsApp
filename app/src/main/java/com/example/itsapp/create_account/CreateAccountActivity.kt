package com.example.itsapp.create_account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.itsapp.R
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
        addListOfProfessions(resources.getStringArray(R.array.profesiones))
        initListener()

    }

    private fun initListener() {
        binding.toolbarCreateAccount.setNavigationOnClickListener {
            this.finish()

        }

    }

    private fun addListOfProfessions(listOfProfessions: Array<String>) {
        val professionAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listOfProfessions)
        binding.listOfProfessions.setAdapter(professionAdapter)

    }

}