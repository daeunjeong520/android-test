package com.daeun.matchingapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.daeun.matchingapp.AppDatabase
import com.daeun.matchingapp.R
import com.daeun.matchingapp.adapter.FreelancerAdapter
import com.daeun.matchingapp.adapter.ProjectAdapter
import com.daeun.matchingapp.databinding.ActivityProjectManageBinding
import com.daeun.matchingapp.domain.Freelancer
import com.daeun.matchingapp.domain.Project

class ProjectManageActivity : AppCompatActivity(), ProjectAdapter.ItemClickListener {

    private lateinit var binding: ActivityProjectManageBinding
    private lateinit var projectAdapter: ProjectAdapter
    private var selectedProject: Project?= null

    private val updateAddProjectResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        val isUpdated = result.data?.getBooleanExtra("isUpdated", false)
        if(result.resultCode == RESULT_OK && isUpdated == true) {
            updatedAddProject()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectManageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // list
        initRecyclerView()

        // project list -> project add Activity
        binding.addProjectButton.setOnClickListener {
            Intent(this, ProjectAddActivity::class.java).let {
                updateAddProjectResult.launch(it)
            }
        }
    }

    private fun initRecyclerView() {
        val projectList = mutableListOf<Project>(
            //Project("ProjectA", "개발", "안드로이드 개발자", "500만원", "2024-05-30"),
            //Project("ProjectA", "디자인", "UI/UX 디자인", "400만원", "2024-05-30"),
            //Project("ProjectA", "개발", "서버 개발자", "700만원", "2024-05-30")
        )

        projectAdapter = ProjectAdapter(mutableListOf(), this)
        binding.projectRecyclerView.apply {
            adapter = projectAdapter
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }

        Thread {
            val list = AppDatabase.getInstance(this)?.projectDao()?.getAll() ?: emptyList()
            Thread.sleep(1000)
            projectAdapter.list.addAll(list)
            runOnUiThread { projectAdapter.notifyDataSetChanged() }
        }.start()
    }

    // List Activity -> Detail Activity
    override fun onClick(project: Project) {
        selectedProject = project
        val intent = Intent(this, ProjectViewActivity::class.java)

        intent.putExtra("name", project.name)
        intent.putExtra("jobGroup", project.jobGroup)
        intent.putExtra("job", project.job)
        intent.putExtra("salary", project.salary)
        intent.putExtra("startDate", project.startDate)

        startActivity(intent)
    }

    fun updatedAddProject() {
        Thread {
            val project = AppDatabase.getInstance(this)?.projectDao()?.getLatestProject()?.let { project ->
                projectAdapter.list.add(0, project)
                runOnUiThread {
                    projectAdapter.notifyDataSetChanged()
                }
            }
        }.start()
    }
}