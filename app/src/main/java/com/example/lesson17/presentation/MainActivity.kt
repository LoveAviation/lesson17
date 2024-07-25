package com.example.lesson17.presentation

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
            myAdapter = MyAdapter(this, photos)
            binding.recyclerView.adapter = myAdapter
        })

//        mainVM.state.observe(this, Observer { state ->
//            when(state){
//                "loading" -> {
//                    binding.progressBar.visibility = View.VISIBLE
//                    binding.errorText.visibility = View.GONE
//                    binding.recyclerView.visibility = View.GONE
//                }
//                "error" ->{
//                    binding.progressBar.visibility = View.GONE
//                    binding.errorText.visibility = View.VISIBLE
//                    binding.recyclerView.visibility = View.GONE
//                }
//                "success" ->{
//                    binding.progressBar.visibility = View.GONE
//                    binding.errorText.visibility = View.GONE
//                    binding.recyclerView.visibility = View.VISIBLE
//                }
//            }
//        })
    }
}