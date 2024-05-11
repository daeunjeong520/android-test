package com.daeun.matchingapp.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project")
data class Project(

    val name: String,
    val jobGroup: String,
    val job: String,
    val salary: String,
    val startDate: String,
    @PrimaryKey(autoGenerate = true)val id: Int = 0
)