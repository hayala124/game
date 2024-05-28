package com.hayala.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.hayala.game.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.btnTypesOfData.setOnClickListener { getInformation(binding.btnTypesOfData) }
        binding.btnVariables.setOnClickListener { getInformation(binding.btnVariables) }
        binding.btnOperations.setOnClickListener { getInformation(binding.btnOperations) }
        binding.btnConditionalExpressions.setOnClickListener { getInformation(binding.btnConditionalExpressions) }
        binding.btnCycles.setOnClickListener { getInformation(binding.btnCycles) }
        binding.btnFunction.setOnClickListener { getInformation(binding.btnFunction) }
        binding.btnCollection.setOnClickListener { getInformation(binding.btnCollection) }
        binding.btnTest.setOnClickListener { takeTest() }
    }

    private fun getInformation(button: Button) {
        val intent = Intent(this, InformationActivity::class.java)
        intent.putExtra("textInformation", button.text.toString())
        startActivity(intent)
    }

    private fun takeTest() {
        val intent = Intent(this, TestActivity::class.java)
        startActivity(intent)
    }

}