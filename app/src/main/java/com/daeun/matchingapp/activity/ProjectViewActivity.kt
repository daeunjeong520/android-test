package com.daeun.matchingapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daeun.matchingapp.R
import com.daeun.matchingapp.databinding.ActivityProjectManageBinding
import com.daeun.matchingapp.databinding.ActivityProjectViewBinding

class ProjectViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProjectViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val jobGroup = intent.getStringExtra("jobGroup")
        val job = intent.getStringExtra("job")
        val salary = intent.getStringExtra("salary")
        val startDate = intent.getStringExtra("startDate")

        binding.projectName.text = name
        binding.jobGroup.text = jobGroup
        binding.job.text = job
        binding.salary.text = salary
        binding.startDate.text = startDate

    }
}