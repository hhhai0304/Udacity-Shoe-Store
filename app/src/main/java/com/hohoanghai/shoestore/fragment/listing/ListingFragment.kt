package com.hohoanghai.shoestore.fragment.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.hohoanghai.shoestore.R
import com.hohoanghai.shoestore.databinding.FragmentListingBinding
import com.hohoanghai.shoestore.databinding.ItemShoeBinding

class ListingFragment : Fragment() {
    private lateinit var binding: FragmentListingBinding
    private val listingViewModel: ListingViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListingBinding.inflate(inflater, container, false)
        binding.viewModel = listingViewModel
        binding.lifecycleOwner = this
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment())
        }

        listingViewModel.shoes.observe(
            viewLifecycleOwner
        ) { shoes ->
            shoes.forEach {
                val itemLayout: View =
                    LayoutInflater.from(context)
                        .inflate(R.layout.item_shoe, binding.llListing, false)
                val itemBinding = ItemShoeBinding.bind(itemLayout)
                itemBinding.shoe = it
                binding.llListing.addView(itemLayout)
            }
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mLogout -> {
                findNavController().navigate(ListingFragmentDirections.actionListingFragmentToLoginFragment())
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}