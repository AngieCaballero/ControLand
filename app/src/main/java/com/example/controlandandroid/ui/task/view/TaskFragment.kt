package com.example.controlandandroid.ui.task.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import com.example.controlandandroid.data.model.Task
import com.example.controlandandroid.databinding.FragmentTaskBinding
import com.example.controlandandroid.ui.utils.hideKeyboard
import com.example.controlandandroid.ui.base.BaseFragment
import com.example.controlandandroid.ui.task.view.adapter.TaskAdapter
import com.example.controlandandroid.ui.task.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class TaskFragment: BaseFragment<FragmentTaskBinding>(), TaskAdapter.TaskListeners {

    private val viewModel: TaskViewModel by viewModels()
    private var adapter: TaskAdapter? = null

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
            requireActivity().hideKeyboard()
            viewModel.saveTaskInDatabase(
                Task(
                    0,
                    name = binding.taskNameEditText.text.toString(),
                    client = binding.taskClienteEditText.text.toString(),
                    date = LocalDate.now().toString()
                )
            )
            binding.taskNameEditText.setText("")
            binding.taskClienteEditText.setText("")
        }

        binding.taskFilterButton.setOnClickListener {
            requireActivity().hideKeyboard()
            viewModel.fetchTasks(name = binding.taskFilterNameEditText.text.toString())
        }

        binding.taskShowAllButton.setOnClickListener {
            requireActivity().hideKeyboard()
            viewModel.fetchTasks()
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

    }
}