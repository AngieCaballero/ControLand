package com.example.controlandandroid.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.controlandandroid.databinding.FragmentHomeBinding
import com.example.controlandandroid.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    override fun onCreateBinding(inflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        binding.homeGoToTaskButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.toTaskFragment())
        }

        binding.homeGoToDocsButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.toDocsFragment())
        }
    }
}