package com.example.controlandandroid.di.module

import com.example.controlandandroid.data.repository.docs.DocsRepository
import com.example.controlandandroid.data.repository.docs.DocsRepositoryImpl
import com.example.controlandandroid.data.repository.task.TaskRepository
import com.example.controlandandroid.data.repository.task.TaskRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTaskRepository(taskRepository: TaskRepositoryImpl): TaskRepository

    @Binds
    abstract fun bindDocsRepository(docsRepository: DocsRepositoryImpl): DocsRepository

}