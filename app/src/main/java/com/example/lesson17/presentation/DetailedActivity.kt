package com.example.lesson17.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
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


        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        Glide.with(this)
            .load(intent.getStringExtra("img_src"))
            .into(binding.image)

        binding.roverName.text = "Rover: ${intent.getStringExtra("rover")}"
        binding.sol.text = "Sol: ${intent.getStringExtra("sol")}"
        binding.earthDate.text = "Earth date: ${intent.getStringExtra("earth_date")}"
        binding.cameraName.text = "Camera: ${intent.getStringExtra("camera")}"

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}