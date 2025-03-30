package com.example.konfiguratorsamochodu

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.samochody.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carImageView = findViewById<ImageView>(R.id.carImageView)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val acCheckBox = findViewById<CheckBox>(R.id.acCheckBox)
        val leatherSeatsCheckBox = findViewById<CheckBox>(R.id.leatherSeatsCheckBox)
        val configureButton = findViewById<Button>(R.id.configureButton)
        val summaryTextView = findViewById<TextView>(R.id.summaryTextView)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.sedanRadioButton -> carImageView.setImageResource(R.drawable.sedan)
                R.id.suvRadioButton -> carImageView.setImageResource(R.drawable.suv)
                R.id.hatchbackRadioButton -> carImageView.setImageResource(R.drawable.hatchback)
            }
        }
        configureButton.setOnClickListener {
            val selectedCar = when (radioGroup.checkedRadioButtonId) {
                R.id.sedanRadioButton -> "Sedan"
                R.id.suvRadioButton -> "SUV"
                R.id.hatchbackRadioButton -> "Hatchback"
                else -> "Nie wybrano"
            }

            val options = mutableListOf<String>()
            if (acCheckBox.isChecked) options.add("Klimatyzacja")
            if (leatherSeatsCheckBox.isChecked) options.add("Skórzane siedzenia")

            val summary = "Wybrany model: $selectedCar\nDodatkowe opcje: ${if (options.isEmpty()) "Brak" else options.joinToString(", ")}"
            summaryTextView.text = summary
        }
    }
}
