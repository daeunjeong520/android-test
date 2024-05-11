package com.daeun.matchingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daeun.matchingapp.activity.LoginActivity
import com.daeun.matchingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // main -> client: signup
        binding.clientButton.setOnClickListener {
            Intent(this, LoginActivity::class.java).let {
                startActivity(it)
            }
        }
    }
}