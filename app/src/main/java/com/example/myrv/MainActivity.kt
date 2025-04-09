package com.example.myrv

import android.content.ClipData
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager

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
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true) // Fixed this
            adapter = RvAdapter(Constant.getData())
        }
        var cnt: Int = 1
        binding.addButton.setOnClickListener {
            Constant.addItem(ItemData(R.drawable.diet, "$cnt samose walii", "clggg"))
            cnt++
            binding.recycle1.adapter?.notifyDataSetChanged()

        }


    }
}
