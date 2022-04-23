package com.example.itsapp.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.itsapp.R
import com.example.itsapp.databinding.FragmentMenuBinding

class MenuFragment: Fragment() {
    /** ATRIBUTOS **/
    private lateinit var binding: FragmentMenuBinding
    private lateinit var navController: NavController

    /** METODOS **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        binding = FragmentMenuBinding.bind(view)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

    }

}