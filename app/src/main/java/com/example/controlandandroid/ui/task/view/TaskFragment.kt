package com.example.controlandandroid.ui.task.view

import android.view.LayoutInflater
import com.example.controlandandroid.databinding.FragmentTaskBinding
import com.example.controlandandroid.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskFragment: BaseFragment<FragmentTaskBinding>() {

    override fun onCreateBinding(inflater: LayoutInflater): FragmentTaskBinding {
        return FragmentTaskBinding.inflate(inflater)
    }


}