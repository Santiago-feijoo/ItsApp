package com.example.itsapp.tools

import android.app.Activity
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
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

        binding.buttonClose.setOnClickListener { button ->
            button.isEnabled = false
            exit()

        }

        binding.textViewNameInfection.text = infection.nameInfection

        if(infection.nameInfection == "Uretritis") {
            binding.textViewDescriptionInfection.text = activity.getText(R.string.descripcion_uretritis)
            binding.textViewDiagnosisInfection.text = activity.getText(R.string.diagnostico_uretritis)
            binding.textViewTitleDiagnosisTableOne.text = Html.fromHtml("<b>Tabla 1.</b> Exámenes de diagnóstico por agente etiológico y nivel de atención, en el paciente con uretritis")
            binding.diagnosisTableOneImage.setImageResource(R.drawable.diagnosis_table_one)

        } else {
            binding.textViewTitleDefinition.visibility = View.GONE
            binding.textViewTitleDiagnosis.visibility = View.GONE

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