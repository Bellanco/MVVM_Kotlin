package com.deromang.rick.ui.first.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deromang.rick.databinding.RowMainBinding
import com.deromang.rick.model.CharacterModel
import com.deromang.rick.util.setImageUrl

class FirstViewHolder private constructor(
    private val binding: RowMainBinding,
    private val listener: OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bindView(model: CharacterModel, context: Context) {

        binding.tvName.text = model.name

        binding.tvSpecies.text = model.species

        binding.ivMain.setImageUrl(context, model.image)

        binding.clContainer.setOnClickListener {
            listener.onClick(model)
        }

    }

    companion object {
        fun from(parent: ViewGroup, listener: OnItemClickListener): FirstViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = RowMainBinding.inflate(inflater, parent, false)
            return FirstViewHolder(binding, listener)
        }
    }


    interface OnItemClickListener {
        fun onClick(model: CharacterModel)
    }
}