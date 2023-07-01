package com.main.androidbomber.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.main.androidbomber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}