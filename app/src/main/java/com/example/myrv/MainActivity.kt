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
    private var itemData: ArrayList<ItemData> = ArrayList() // Correctly declared at class level
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

        // ✅ Correctly adding data to itemData list
        itemData.addAll(
            arrayListOf(
                ItemData("Sujal", 21, "negisujal2007@gmail.com"),
                ItemData("Sumit", 10, "mrfoccused@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com"),
                ItemData("Arpit", 20, "arpitPookie@gmail.com")
            )
        )

        // ✅ Correctly setting up RecyclerView
        binding.recycle1.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true) // Fixed this
            adapter = RvAdapter(itemData)
        }
        binding.addButton.setOnClickListener {
            val name = binding.addNameText.text.toString()
            val age = binding.addAgeText.text.toString().toIntOrNull()
            val email = binding.addEmailText.text.toString()
            if (name.isNotEmpty() && age != null && email.isNotEmpty()) {
                itemData.add(ItemData(name, age, email))
                binding.recycle1.adapter?.notifyItemInserted(itemData.size - 1)
                binding.addNameText.text.clear()
                binding.addAgeText.text.clear()
                binding.addEmailText.text.clear()
            }
        }
    }
}
