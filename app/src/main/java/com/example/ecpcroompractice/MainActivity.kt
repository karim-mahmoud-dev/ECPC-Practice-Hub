package com.example.ecpcroompractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.ecpcroompractice.ui.theme.ECPCRoomPracticeTheme

class MainActivity : ComponentActivity() {

    private lateinit var database: ProblemDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = Room.databaseBuilder(
            applicationContext,
            ProblemDatabase::class.java,
            "ecpc_problems_db"
        ).build()

        setContent {
            ECPCRoomPracticeTheme {

                val problemList by database.problemDao.getAllProblems().collectAsState(initial = emptyList())

                ECPCHubScreen(
                    problems = problemList,

                    onAddProblem = { name, platform ->
                        lifecycleScope.launch(Dispatchers.IO) {
                            val newProblem = ProblemEntity(
                                problemName = name,
                                platform = platform,
                                isSolved = false
                            )
                            database.problemDao.insertProblem(newProblem)
                        }
                    },

                    onDeleteProblem = { problemToDelete ->
                        lifecycleScope.launch(Dispatchers.IO) {
                            database.problemDao.deleteProblem(problemToDelete)
                        }
                    }
                )
            }
        }
    }
}