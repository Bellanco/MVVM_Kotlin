package com.example.application.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.application.R
import com.example.application.databinding.SecondFragmentBinding
import com.example.application.util.setImageUrl
import com.example.application.util.share

class SecondFragment : Fragment() {

    val args: SecondFragmentArgs by navArgs()

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: SecondViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val binding = SecondFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        args.model?.let { model ->
            context?.let { context ->

                binding.tvName.text = model.name
                binding.ivDetail.setImageUrl(context, model.image)
                binding.tvSpecies.text = model.species
                binding.tvType.text = model.type

                binding.tvLocation.text = getString(R.string.label_location, model.location.name)

                binding.fabShare.setOnClickListener {
                    share(context, model.url)
                }
            }
        }




        return binding.root
    }


}