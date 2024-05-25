package com.hayala.game

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hayala.game.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.btnGoOver.setOnClickListener { onClickButtonGoOver() }
    }

    private fun onClickButtonGoOver() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}