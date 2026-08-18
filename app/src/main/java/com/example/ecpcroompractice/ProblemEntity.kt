package com.example.ecpcroompractice

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ecpc_problems")
data class ProblemEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val problemName: String,
    val platform: String,
    val isSolved: Boolean = false

)
