package com.daeun.matchingapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daeun.matchingapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // login -> client main
        binding.applyButton.setOnClickListener {
            Toast.makeText(this, "프로필 생성이 완료되었습니다", Toast.LENGTH_SHORT).show()
            Intent(this, ClientMainActivity::class.java).let {
                startActivity(it)
            }
        }
    }
}