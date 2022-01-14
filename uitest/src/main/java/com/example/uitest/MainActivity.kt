package com.example.uitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uitest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.button.setOnClickListener { bind.button.setText(R.string.clicked) }
    }
}