package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var basePriceEditText: EditText
    private lateinit var tipPercentageSeekBar: SeekBar
    private lateinit var calculatedTipTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        basePriceEditText = findViewById(R.id.editTextBasePrice)
        tipPercentageSeekBar = findViewById(R.id.seekBar)
        calculatedTipTextView = findViewById(R.id.textViewCalculatedTip)

        tipPercentageSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                calculateTip()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun calculateTip() {
        val basePrice = basePriceEditText.text.toString().toDoubleOrNull() ?: 0.0
        val tipPercentage = tipPercentageSeekBar.progress
        val tipAmount = basePrice * tipPercentage / 100.0
        calculatedTipTextView.text = tipAmount.toString()
    }
}