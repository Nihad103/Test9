package com.example.test9

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.addButton.setOnClickListener {

           val tableRow = LayoutInflater.from(this).inflate(R.layout.table_row, null) as TableRow
                tableRow.findViewById<TextView>(R.id.nameTextView).setText(binding.nameEditText.text.toString())
                tableRow.findViewById<TextView>(R.id.surnameTextView).setText(binding.surnameEditText.text.toString())
                tableRow.findViewById<TextView>(R.id.ageTextView).setText(binding.ageEditText.text.toString())

            binding.tableLayout.addView(tableRow)

        }

    }
}