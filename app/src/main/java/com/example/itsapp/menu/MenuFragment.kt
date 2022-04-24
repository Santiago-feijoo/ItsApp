package com.example.itsapp.menu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.itsapp.R
import com.example.itsapp.adapters.AdapterInfections
import com.example.itsapp.databinding.FragmentMenuBinding
import com.example.itsapp.persistence.entities.Infections
import com.example.itsapp.tools.DialogTools
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MenuFragment: Fragment(), AdapterInfections.OnClick {
    /** ATRIBUTOS **/
    private lateinit var binding: FragmentMenuBinding
    private lateinit var navController: NavController
    private val viewModel: MenuViewModel by viewModels()
    private lateinit var adapterInfections: AdapterInfections
    @Inject lateinit var dialogTools: DialogTools

    /** METODOS **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }

        adapterInfections = AdapterInfections(this)

        observer()
        viewModel.setInfections(resources.getStringArray(R.array.infections))

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
        initComponents()

    }

    private fun initComponents() {
        binding.recycleViewOfResults.adapter = adapterInfections
        initListener()

    }

    private fun initListener() {
        binding.toolbarMenu.setNavigationOnClickListener {
            requireActivity().finish()

        }

        binding.editTextSearch.doAfterTextChanged {
            val filter = it.toString()

            if(filter.isEmpty()) {
                viewModel.getInfections()

            } else {
                viewModel.getInfections(filter)

            }

        }

    }

    private fun observer() {
        viewModel.infectionsInserted.observe(this) { message ->
            Log.i("MenuFragment", message)
            viewModel.getInfections()

        }

        viewModel.loadInfections.observe(this) { data ->
            Log.i("MenuFragment", "¡Infecciones cargadas correctamente!")
            adapterInfections.setData(data)

        }

    }

    override fun onClickInfection(infection: Infections) {
        dialogTools.viewDetailsInfection(requireActivity(), infection) {
            dialogTools.alertDialog.dismiss()

        }

    }

}