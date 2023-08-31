package com.example.controlandandroid.ui.task.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.controlandandroid.R
import com.example.controlandandroid.data.model.Task
import com.example.controlandandroid.databinding.FragmentTaskBinding
import com.example.controlandandroid.ui.utils.hideKeyboard
import com.example.controlandandroid.ui.base.BaseFragment
import com.example.controlandandroid.ui.task.view.adapter.TaskAdapter
import com.example.controlandandroid.ui.task.viewmodel.TaskViewModel
import com.example.controlandandroid.ui.utils.animateHideAction
import com.example.controlandandroid.ui.utils.animateShowAction
import com.example.controlandandroid.ui.utils.setGone
import com.example.controlandandroid.ui.utils.setVisible
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class TaskFragment: BaseFragment<FragmentTaskBinding>(), TaskAdapter.TaskListeners {

    private val viewModel: TaskViewModel by viewModels()
    private var adapter: TaskAdapter? = null
    private var isFilterLayoutVisible = false

    override fun onCreateBinding(inflater: LayoutInflater): FragmentTaskBinding {
        return FragmentTaskBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setObservers()
        setupRecycler()
        viewModel.fetchTasks()
    }

    private fun setupRecycler() {
        adapter = TaskAdapter(this)
        binding.taskRecyclerView.adapter = adapter
    }

    private fun setListeners() {
        binding.taskAddButton.setOnClickListener {
            AddTaskDialogFragment
                .newInstance()
                .show(
                    childFragmentManager,
                    AddTaskDialogFragment.TAG
                )
        }

        binding.taskFilterButton.setOnClickListener {
            requireActivity().hideKeyboard()
            viewModel.fetchTasks(
                name = binding.taskFilterNameEditText.text.toString(),
                client = binding.taskFilterClientEditText.text.toString()
            )
        }

        binding.taskShowAllButton.setOnClickListener {
            requireActivity().hideKeyboard()
            viewModel.fetchTasks()
        }

        binding.taskFilterCollapseIcon.setOnClickListener {
            isFilterLayoutVisible = !isFilterLayoutVisible
            if (isFilterLayoutVisible) {
                binding.taskFilterLinearLayout.setVisible()
            } else {
                binding.taskFilterLinearLayout.setGone()
            }

            val icArrow = ResourcesCompat.getDrawable(
                resources,
                if (isFilterLayoutVisible) R.drawable.ic_arrow_down
                else R.drawable.ic_arrow_right,
                null
            )

            Glide.with(requireContext())
                .load(icArrow)
                .useAnimationPool(true)
                .into(binding.taskFilterCollapseIcon)
        }
    }

    private fun setObservers() {
        viewModel.taskList.observe(viewLifecycleOwner) { taskList ->
            adapter?.updateTaskList(taskList ?: listOf())
        }
    }

    override fun onSelectTask(task: Task) {
        /*  */
    }

    companion object {
        const val TAG = "taskFragmentArg"
    }
}