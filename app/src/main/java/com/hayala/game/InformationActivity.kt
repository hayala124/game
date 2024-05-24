package com.hayala.game

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hayala.game.databinding.ActivityInformationBinding
import java.util.Locale

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater).also { setContentView(it.root) }


        val data = intent.getStringExtra("textInformation")
        binding.txtInf.text = data.toString().lowercase(Locale.getDefault())
    }
}