package com.example.mvvm_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_app.databinding.ItemEyeLayoutBinding
import com.example.mvvm_app.utils.Extensions.colorList
import com.example.mvvm_app.utils.Utils

class EyeColorAdapter constructor(
    private val dataList: MutableList<String?> = mutableListOf()
) : RecyclerView.Adapter<EyeColorAdapter.EyeColorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EyeColorViewHolder {
        return EyeColorViewHolder(
            ItemEyeLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(data: List<String?>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: EyeColorViewHolder, position: Int) {
        dataList[position]?.let { holder.setData(it) }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class EyeColorViewHolder(private val binding: ItemEyeLayoutBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun setData(model: String) {
            binding.eyeCardItem.setCardBackgroundColor(
                binding.eyeCardItem.context.colorList(
                    Utils.nameToColor(
                        model
                    )
                )
            )
            binding.eyeTitleTV.text = String.format("Eye Color: $model")
        }
    }
}
