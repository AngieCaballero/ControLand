package com.example.controlandandroid.ui.task.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controlandandroid.data.model.Filters
import com.example.controlandandroid.data.model.Task
import com.example.controlandandroid.data.repository.task.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
): ViewModel() {

    private val _taskList = MutableLiveData<List<Task>?>()
    val taskList: LiveData<List<Task>?>
        get() = _taskList

    fun fetchTasks(name: String = "", client: String = "") {
        val filters = Filters(name, client)
        viewModelScope.launch(Dispatchers.IO) {
            val taskList = if (name.isEmpty() && client.isEmpty()) taskRepository.getAllTasks()
            else taskRepository.filterTask(filters)
            _taskList.postValue(taskList)
        }
    }

    fun saveTaskInDatabase(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.insertTask(task)
            fetchTasks()
        }
    }

}