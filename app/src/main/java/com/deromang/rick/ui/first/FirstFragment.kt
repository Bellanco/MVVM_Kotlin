package com.deromang.rick.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.deromang.rick.R
import com.deromang.rick.data.Constants
import com.deromang.rick.databinding.FragmentFirstBinding
import com.deromang.rick.model.CharacterModel
import com.deromang.rick.model.CharactersResponseModel
import com.deromang.rick.ui.first.adapter.FirstAdapter
import com.deromang.rick.ui.first.adapter.FirstViewHolder
import com.deromang.rick.util.hideKeyboard

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val binding = FragmentFirstBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        setupObservables(binding)

        setupView(binding)

        setupAdapterCharacters(binding)

        viewModel.getCharacters()

        return binding.root
    }

    private fun setupView(binding: FragmentFirstBinding) {

        binding.fabFilter.setOnClickListener {
            binding.gpFilter.visibility =
                if (binding.gpFilter.visibility == View.GONE)
                    View.VISIBLE
                else
                    View.GONE
        }

        binding.btFilter.setOnClickListener {

            this@FirstFragment.hideKeyboard()

            binding.gpFilter.visibility = View.GONE

            val state: String? =
                when (binding.rgState.checkedRadioButtonId) {
                    R.id.rbAlive -> {
                        Constants.Status.KEY_ALIVE
                    }
                    R.id.rbDead -> {
                        Constants.Status.KEY_DEAD
                    }
                    R.id.rbUnknown -> {
                        Constants.Status.KEY_UNKNOWN
                    }
                    else -> null
                }

            val text : String? = binding.tilName.editText?.text?.toString() ?: run {
                null
            }

            viewModel.getCharacters(text, state)
        }
    }

    private fun setupObservables(binding: FragmentFirstBinding) {

        viewModel.getCharacterResult.observe(viewLifecycleOwner) { result ->
            result.success?.let { model ->
                updateCharacters(binding, model)
            }
            result.error?.let { error ->
                Toast.makeText(requireContext(), getString(error), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateCharacters(binding: FragmentFirstBinding, model: CharactersResponseModel) {
        (binding.rvMain.adapter as FirstAdapter).apply {
            addAll(model.results)
        }
    }

    private fun setupAdapterCharacters(binding: FragmentFirstBinding) {

        binding.rvMain.layoutManager = LinearLayoutManager(context)
        val actualityAdapter =
            FirstAdapter(requireContext(), object : FirstViewHolder.OnItemClickListener {
                override fun onClick(model: CharacterModel) {
                    findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(model))
                }
            })

        binding.rvMain.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        binding.rvMain.adapter = actualityAdapter
    }

}