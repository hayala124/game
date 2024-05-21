package com.hayala.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.hayala.game.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
   // private lateinit var words: List<>()
    private lateinit var buttonStart: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val words = listOf("привет", "пока")

        buttonStart = binding.buttonStart
        buttonStart.setOnClickListener { onStartPressed() }
    }

    fun onStartPressed() {
        buttonStart.visibility = View.GONE

    }

   /* fun generationWord() {
        for(word in )
    }*/
}