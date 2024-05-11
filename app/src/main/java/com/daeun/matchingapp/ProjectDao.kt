package com.daeun.matchingapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.daeun.matchingapp.domain.Project

@Dao
interface ProjectDao {

    @Query("SELECT * FROM project ORDER BY id DESC")
    fun getAll(): List<Project>

    @Query("SELECT * FROM project ORDER BY id DESC LIMIT 1")
    fun getLatestProject() : Project

    @Insert
    fun insert(project: Project)

    @Delete
    fun delete(project: Project)

    @Update
    fun update(project: Project)
}