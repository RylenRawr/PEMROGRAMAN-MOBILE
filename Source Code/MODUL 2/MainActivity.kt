package com.example.Laprakmodul2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.Laprakmodul2.R
import com.example.Laprakmodul2.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val cost = binding.serviceCostInput.text.toString().toDoubleOrNull()
        if (cost != null) {
            val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
                R.id.optionTwentyPercent -> 0.20
                R.id.optionEighteenPercent -> 0.18
                else -> 0.15
            }
            var tip = cost * tipPercentage
            if (binding.roundUpSwitch.isChecked) {
                tip = ceil(tip)
            }
            displayTip(tip)
        } else {
            binding.tipResultDisplay.text = ""
            binding.serviceCostInput.error = "Masukkan biaya layanan"
        }
    }

    private fun displayTip(tip: Double) {
        val formattedTip = String.format("%.2f", tip)
        binding.tipResultDisplay.text = "Tip Amount: $formattedTip"
    }
}
