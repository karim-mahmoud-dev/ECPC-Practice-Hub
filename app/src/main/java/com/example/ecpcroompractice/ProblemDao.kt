package com.example.ecpcroompractice

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProblemDao {

    @Insert
    fun insertProblem(problem: ProblemEntity): Long

    @Delete
    fun deleteProblem(problem: ProblemEntity): Int

    @Query("SELECT * FROM ecpc_problems")
    fun getAllProblems(): Flow<List<ProblemEntity>>
}