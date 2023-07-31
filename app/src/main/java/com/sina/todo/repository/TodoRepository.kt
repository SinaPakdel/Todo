package com.sina.todo.repository

import com.sina.todo.data.TodoDao
import com.sina.todo.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    val getAllTask: Flow<List<TodoTask>> = todoDao.getAllTask()
    val sortByLowPriority: Flow<List<TodoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<TodoTask>> = todoDao.sortByHighPriority()


    fun selectTask(taskId: Int): Flow<TodoTask> {
        return todoDao.getSelectTask(taskId)
    }


    suspend fun addTask(todoTask: TodoTask) {
        todoDao.addTask(todoTask)
    }

    suspend fun updateTask(todoTask: TodoTask) {
        todoDao.updateTask(todoTask)
    }

    suspend fun deleteTask(todoTask: TodoTask) {
        todoDao.deleteTask(todoTask)
    }

    suspend fun deleteAllTasks() {
        todoDao.deleteAllTask()
    }

    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>> {
        return todoDao.searchDatabase(searchQuery)
    }
}