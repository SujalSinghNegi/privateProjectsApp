package com.example.myrv

import android.content.ClipData
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.myrv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.recycle1.apply {
            // if you pass only this@MainActivity, then by default the orientation is  Vertical and Reverse is false is passed
            // you can change it to Horizontal like insta story, and also Reverse = True, then in reverese order the data is showd,
           // layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
//            layoutManager = GridLayoutManager(this@MainActivity, 2)

            layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
            setHasFixedSize(true) // Fixed this


            adapter = RvAdapter(Constant.getData())
        }
        var cnt: Int = 1
        binding.addButton.setOnClickListener {
            Constant.addItem(ItemData(R.drawable.diet, "$cnt samose walii", "clggg"))
            cnt++
            //binding.recycle1.adapter?.notifyDataSetChanged()
            // recommended to use the specific method,
            binding.recycle1.adapter?.notifyItemInserted(Constant.itemData.size - 1)

            binding.recycle1.smoothScrollToPosition(Constant.itemData.size - 1)

        }


    }
}
