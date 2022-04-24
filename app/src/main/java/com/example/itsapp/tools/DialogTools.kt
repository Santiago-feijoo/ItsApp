package com.example.itsapp.tools

import android.app.Activity
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.example.itsapp.R
import com.example.itsapp.databinding.DialogDetailsInfectionBinding
import com.example.itsapp.persistence.entities.Infections
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DialogTools @Inject constructor() {
    /** ATRIBUTOS **/
    lateinit var alertDialog: AlertDialog

    /** METODOS **/
    fun viewDetailsInfection(activity: Activity, infection: Infections, exit: () -> Unit) {
        val view = LayoutInflater.from(activity).inflate(R.layout.dialog_details_infection, activity.findViewById(android.R.id.content), false)
        val binding = DialogDetailsInfectionBinding.bind(view)

        binding.textViewNameInfection.text = infection.nameInfection
        binding.toolbarDetailsInfection.setNavigationOnClickListener {
            it.isEnabled = false
            exit()

        }

        val dialog = MaterialAlertDialogBuilder(activity)
        dialog.setView(binding.root)
        dialog.setCancelable(false)

        alertDialog = dialog.create()

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(alertDialog.window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        alertDialog.window?.attributes = lp
        alertDialog.create()
        alertDialog.show()

    }

}