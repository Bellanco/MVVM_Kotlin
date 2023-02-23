package com.deromang.rick.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.deromang.rick.model.CharacterModel
import com.deromang.rick.ui.first.adapter.FirstAdapter
import com.deromang.rick.ui.first.adapter.FirstViewHolder
import com.deromang.rick.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val binding = FragmentFirstBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        viewModel.getCharacters()

        setupObservables(binding)

        return binding.root

    }

    private fun setupObservables(binding: FragmentFirstBinding) {

        viewModel.getCharacterResult.observe(viewLifecycleOwner) { result ->
            result.success?.let { model ->
                setupAdapterCharacters(binding, model.results)
            }
        }
    }

    private fun setupAdapterCharacters(binding: FragmentFirstBinding, results: MutableList<CharacterModel>) {

        binding.rvMain.layoutManager = LinearLayoutManager(context)
        val actualityAdapter =
            FirstAdapter(results, requireContext(), object : FirstViewHolder.OnItemClickListener {
                override fun onClick(model: CharacterModel) {
                    findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(model))
                }
            })

        binding.rvMain.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        binding.rvMain.adapter = actualityAdapter
    }

}