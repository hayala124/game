package com.hayala.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hayala.game.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.textRules.text = "Правила пользования приложением:\n" +
                "Для начала вам необходимо перейти на следующую страницу, где вы сможете выбрать необходимую вам тему для " +
                "изучения или повторения материала и ознакомиться с предоставленным материалом"

        binding.btnGoOver.setOnClickListener { onClickButtonGoOver() }
    }

    private fun onClickButtonGoOver() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}