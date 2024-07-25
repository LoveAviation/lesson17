package com.example.lesson17.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var myAdapter : MyAdapter

    private val mainVM : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        mainVM.photos.observe(this, Observer { photos ->
            myAdapter = MyAdapter(this, photos){ item ->
                val intent = Intent(this, DetailedActivity::class.java).apply {
                    putExtra("img_src", item.img_src)
                    putExtra("rover", item.rover.name)
                    putExtra("camera", item.camera?.name)
                    putExtra("sol", item.sol.toString())
                    putExtra("earth_date", item.earth_date)
                }
                startActivity(intent)
            }
            binding.recyclerView.adapter = myAdapter
        })

        mainVM.state.observe(this, Observer { state ->
            when(state){
                "loading" -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.errorText.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                }
                "error" ->{
                    binding.progressBar.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                    Thread.sleep(3000)
                    mainVM.getPhotos()
                }
                "success" ->{
                    binding.progressBar.visibility = View.GONE
                    binding.errorText.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                }
            }
        })
    }
}