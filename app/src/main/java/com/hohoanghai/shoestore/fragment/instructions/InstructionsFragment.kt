package com.hohoanghai.shoestore.fragment.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hohoanghai.shoestore.R
import com.hohoanghai.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    private lateinit var binding: FragmentInstructionsBinding
    private val viewModel: InstructionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstructionsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.index.observe(
            viewLifecycleOwner
        ) { index ->
            if (index == viewModel.instructions.size - 1) {
                binding.btnNext.text = getText(R.string.shopping_now)
            } else {
                binding.btnNext.text = getText(R.string.next)
            }
        }
        viewModel.isFinish.observe(
            viewLifecycleOwner
        ) { isFinish ->
            if (isFinish) {
                findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToListingFragment())
            }
        }
        return binding.root
    }
}