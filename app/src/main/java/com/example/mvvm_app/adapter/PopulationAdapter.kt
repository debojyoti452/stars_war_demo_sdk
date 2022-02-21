package com.example.mvvm_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_app.databinding.ItemPlanetLayoutBinding

class PopulationAdapter constructor(
    private val dataList: MutableList<Pair<String?, String?>> = mutableListOf()
) : RecyclerView.Adapter<PopulationAdapter.FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            ItemPlanetLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(data: List<Pair<String?, String?>>) {
        if(data.isNotEmpty()) {
            dataList.clear()
            dataList.addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.setData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class FilmViewHolder(private val binding: ItemPlanetLayoutBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun setData(model: Pair<String?, String?>) {
            binding.populationTitleTV.text = String.format("Population Count: ${model.first}")
            binding.populationClimateTV.text = String.format("Climate: ${model.second}")
        }
    }
}
