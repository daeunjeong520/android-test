package com.daeun.matchingapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.daeun.matchingapp.AppDatabase
import com.daeun.matchingapp.databinding.ActivityProjectAddBinding
import com.daeun.matchingapp.domain.Project
import com.google.android.material.chip.Chip

class ProjectAddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProjectAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addProjectButton.setOnClickListener {
            add()
        }
    }

    // 프로젝트 추가
    private fun add() {
        val name = binding.nameText.text.toString()
        //val jobGroup = binding.jobGroupSpinner.get(1).toString()
        val job = binding.jobText.text.toString()
        val salary = binding.expectedSalaryText.text.toString()
        val startDate = binding.startDateText.text.toString()

        val project = Project(name, "개발", job, salary, startDate)

        Thread {
            AppDatabase.getInstance(this)?.projectDao()?.insert(project)
            runOnUiThread {
                Toast.makeText(this, "저장을 완료했습니다", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent().putExtra("isUpdated", true)
            setResult(RESULT_OK, intent)
            finish()

        }.start()
    }
}