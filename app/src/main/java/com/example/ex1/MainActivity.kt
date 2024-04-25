package com.example.ex1

import android.os.Bundle
import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ex1.ui.theme.Ex1Theme

class MainActivity : Activity() {
    private lateinit var textView: TextView
    private lateinit var seekBarTextSize: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textViewId)
        seekBarTextSize = findViewById(R.id.seekBarTextSize)
        val buttonTextColor = findViewById<Button>(R.id.buttonTextColor)

        // Set initial text size
        textView.textSize = 20f

        // SeekBar listener to change text size
        seekBarTextSize.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textView.textSize = progress.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        // Button click listener to change text color
        buttonTextColor.setOnClickListener {
            showColorPickerDialog()
        }
    }

    private fun showColorPickerDialog() {
        val colors = arrayOf("Black", "Red", "Green", "Blue", "Yellow") // Add more colors as needed

        AlertDialog.Builder(this)
            .setTitle("Select Color")
            .setItems(colors) { dialog, which ->
                val color = when (which) {
                    0 -> Color.BLACK
                    1 -> Color.RED
                    2 -> Color.GREEN
                    3 -> Color.BLUE
                    4 -> Color.YELLOW
                    else -> Color.BLACK
                }
                textView.setTextColor(color)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

}
