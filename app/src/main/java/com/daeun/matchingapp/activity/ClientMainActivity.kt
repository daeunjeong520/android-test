package com.daeun.matchingapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.daeun.matchingapp.adapter.FreelancerAdapter
import com.daeun.matchingapp.databinding.ActivityClientMainBinding
import com.daeun.matchingapp.domain.Freelancer

class ClientMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClientMainBinding
    private lateinit var freelancerAdapter: FreelancerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        // clientMain -> myProjectActivity
        binding.projectManageButton.setOnClickListener {
            Intent(this, ProjectManageActivity::class.java).let {
                startActivity(it)
            }
        }
    }

    private fun initRecyclerView() {
        val freelancerList = mutableListOf<Freelancer>(
            Freelancer("홍길동", "원격/상주", "웹 개발자", "10년 이상"),
            Freelancer("이나경", "원격", "서버 개발자", "1년 이상"),
            Freelancer("권유진", "상주", "안드로이드 개발자", "20년 이상"),
            Freelancer("정다은", "원격/상주", "클라우드 엔지니어", "5년 이상")
        )

        freelancerAdapter = FreelancerAdapter(freelancerList)
        binding.freelancerRecyclerView.apply {
            adapter = freelancerAdapter
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }
    }

    fun onClick(freelancer: Freelancer) {
        Toast.makeText(this, "${freelancer.name}가 클릭됬습니다", Toast.LENGTH_SHORT).show()
    }
}