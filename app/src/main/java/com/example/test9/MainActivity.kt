package com.example.test9

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
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

        binding.logOut.setOnClickListener {

            val message: String? = "Are you sure you want to log out"
            showAlertDialog(message)
        }
    }


    fun showAlertDialog(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val alertMessage = dialog.findViewById<TextView>(R.id.alert_message)
        val alertYesBtn = dialog.findViewById<Button>(R.id.alertYesBtn)
        val alertNoBtn = dialog.findViewById<Button>(R.id.alertNoBtn)

        alertMessage.text = message

        alertYesBtn.setOnClickListener {
            Toast.makeText(this, "Button Yes Clicked", Toast.LENGTH_SHORT).show()
        }

        alertNoBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}