package com.example.application.ui.first.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.application.model.CharacterModel

class FirstAdapter(
    private val modelList: MutableList<CharacterModel>,
    private val context: Context,
    private val listener: FirstViewHolder.OnItemClickListener
) :
    RecyclerView.Adapter<FirstViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder =
        FirstViewHolder.from(parent, listener)

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.bindView(modelList[position], context)
    }

    override fun getItemCount(): Int = modelList.size

}