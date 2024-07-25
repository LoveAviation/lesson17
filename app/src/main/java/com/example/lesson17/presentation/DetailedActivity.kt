package com.example.lesson17.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.example.lesson17.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(intent.getStringExtra("img_src"))
            .into(binding.image)

        binding.roverName.text = "Rover: ${intent.getStringExtra("rover")}"
        binding.sol.text = "Sol: ${intent.getStringExtra("sol")}"
        binding.earthDate.text = "Earth date: ${intent.getStringExtra("earth_date")}"
        binding.cameraName.text = "Camera: ${intent.getStringExtra("camera")}"
    }
}