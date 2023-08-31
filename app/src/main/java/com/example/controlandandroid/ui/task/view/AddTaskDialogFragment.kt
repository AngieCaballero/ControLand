package com.example.controlandandroid.ui.task.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import com.example.controlandandroid.R
import com.example.controlandandroid.data.model.Task
import com.example.controlandandroid.databinding.DialogFragmentAddTaskBinding
import com.example.controlandandroid.ui.base.BaseDialogFragment
import com.example.controlandandroid.ui.task.viewmodel.TaskViewModel
import com.example.controlandandroid.ui.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class AddTaskDialogFragment: BaseDialogFragment<DialogFragmentAddTaskBinding>() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateBinding(inflater: LayoutInflater): DialogFragmentAddTaskBinding {
        return DialogFragmentAddTaskBinding.inflate(inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Dialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        binding.taskDialogClose.setOnClickListener {
            dismiss()
        }

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
    }

    private fun setObservers() {

    }

    companion object {
        const val TAG = "addTaskDialogTag"

        fun newInstance(
            args: Bundle? = null
        ): AddTaskDialogFragment {
            return AddTaskDialogFragment().apply {
                arguments = args
            }
        }
    }
}