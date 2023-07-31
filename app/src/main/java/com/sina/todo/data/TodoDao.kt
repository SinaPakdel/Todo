package com.sina.todo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sina.todo.data.models.TodoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("select * from todo_table order by id asc")
    fun getAllTask(): Flow<List<TodoTask>>

    @Query("select * from todo_table where id = :taskId")
    fun getSelectTask(taskId: Int): Flow<TodoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(todoTask: TodoTask)

    @Update
    suspend fun updateTask(todoTask: TodoTask)

    @Delete
    suspend fun deleteTask(todoTask: TodoTask)

    @Query("delete from todo_table")
    suspend fun deleteAllTask()

    @Query("select * from todo_table where title like :searchQuery or description like :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>>


    @Query("select * from todo_table order by case when priority like 'L%' then 1 when priority like 'M%' then 2 when priority like 'H%' then 3 end ")
    fun sortByLowPriority():Flow<List<TodoTask>>

    @Query("select * from todo_table order by case when priority like 'H%' then 1 when priority like 'M%' then 2 when priority like 'L%' then 3 end ")
    fun sortByHighPriority():Flow<List<TodoTask>>
}