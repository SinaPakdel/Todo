package com.sina.todo.data.models

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sina.todo.ui.theme.HighPriorityColor
import com.sina.todo.ui.theme.LowPriorityColor
import com.sina.todo.ui.theme.MediumPriorityColor
import com.sina.todo.ui.theme.NonePriorityColor
import com.sina.todo.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class TodoTask(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)


enum class Priority(val color: Color) {
    HIGH(HighPriorityColor), MEDIUM(MediumPriorityColor), LOW(LowPriorityColor), NONE(
        NonePriorityColor
    )
}