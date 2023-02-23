package com.deromang.rick.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.deromang.rick.R
import com.deromang.rick.databinding.SecondFragmentBinding
import com.deromang.rick.model.CharacterModel
import com.deromang.rick.util.setImageUrl
import com.deromang.rick.util.share

class SecondFragment : Fragment() {

    val args: SecondFragmentArgs by navArgs()

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val binding = SecondFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        args.model?.let { model : CharacterModel ->

                binding.tvName.text = model.name
                binding.ivDetail.setImageUrl(requireContext(), model.image)
                binding.tvSpecies.text = model.species
                binding.tvType.text = model.type

                binding.tvLocation.text = getString(R.string.label_location, model.location.name)

                binding.fabShare.setOnClickListener {
                    share(requireContext(), model.url)
                }
        }




        return binding.root
    }


}