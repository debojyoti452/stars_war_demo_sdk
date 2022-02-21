package com.example.mvvm_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lib.src.remote.model.FilmData
import com.example.mvvm_app.databinding.ItemFilmLayoutBinding

class FilmAdapter constructor(
    private val dataList: MutableList<FilmData> = mutableListOf()
) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            ItemFilmLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(data: List<FilmData>) {
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

    inner class FilmViewHolder(private val binding: ItemFilmLayoutBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun setData(model: FilmData) {
            binding.filmTitleTV.text = String.format("Movie Title: ${model.title}")
            binding.filmYearTV.text = String.format("Release Date: ${model.releaseDate}\n\n")
            binding.filmOpeningCrawlTV.text = String.format("Description:\n${model.openingCrawl}")
        }
    }
}
