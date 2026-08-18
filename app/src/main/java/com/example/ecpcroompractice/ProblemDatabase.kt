package com.example.ecpcroompractice

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ProblemEntity::class],
    version = 1
)
abstract class ProblemDatabase : RoomDatabase() {

    abstract val problemDao: ProblemDao

}