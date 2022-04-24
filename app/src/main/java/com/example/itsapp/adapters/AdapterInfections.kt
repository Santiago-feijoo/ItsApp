package com.example.itsapp.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.itsapp.R
import com.example.itsapp.databinding.ItemInfectionBinding
import com.example.itsapp.persistence.entities.Infections
import javax.inject.Inject

class AdapterInfections @Inject constructor(): RecyclerView.Adapter<AdapterInfections.ViewHolder>() {
    /** ATRIBUTOS **/
    private val oldInfectionsList: ArrayList<Infections> = ArrayList()
    private val newInfectionsList: ArrayList<Infections> = ArrayList()

    /** METODOS **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_infection, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newInfectionsList[position])

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)

        if(payloads.isNotEmpty()) {
            val bundle = payloads[0] as Bundle

            if(bundle.getString("update") != null) {
                holder.bind(newInfectionsList[position])

            }

        }

    }

    override fun getItemCount(): Int {
        return newInfectionsList.size
    }

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding: ItemInfectionBinding = ItemInfectionBinding.bind(item)

        fun bind(infection: Infections) {
            binding.textViewNameInfection.text = infection.nameInfection

        }

    }

    fun setData(newList: ArrayList<Infections>) {
        val diffUtil = DiffUtilInfection(oldInfectionsList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)

        oldInfectionsList.clear()
        oldInfectionsList.addAll(newList)
        newInfectionsList.clear()
        newInfectionsList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)

    }

}

class DiffUtilInfection(
    private val oldList: ArrayList<Infections>,
    private val newList: ArrayList<Infections>
    ): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].idInfection == newList[newItemPosition].idInfection
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any {
        val bundle = Bundle()
        bundle.putString("update", "update")

        return bundle
    }

}