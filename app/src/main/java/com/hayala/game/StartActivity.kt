package com.hayala.game

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.hayala.game.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    private lateinit var imageView: ImageView
    private var listImages = listOf("image_2", "image_3", "icon_c_sharp")
    private val imageNames = ArrayList<String>(listOf("icon_c_sharp", "image_2", "image_3"))
    private var currentIndex = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater).also { setContentView(it.root) }

        imageView = binding.img1
        binding.textRules.text = "Правила пользования:\n" +
                "Приложение разработано для начанающих программистов для изучения основ на с#\n" +
                "Необходимо перейти на следующую страницу, где вы сможете выбрать необходимую вам тему и ознакомиться с предоставленным материалом"


        imageView.setImageResource(R.drawable.icon_c_sharp)

        binding.btnGoOver.setOnClickListener { onClickButtonGoOver() }
        binding.imgBtnBackArrow.setOnClickListener { onClickButtonBackArrow() }
        binding.imgBtnForwardArrow.setOnClickListener { onClickButtonForwardArrow() }
    }

    private fun onClickButtonBackArrow() {
        currentIndex--
        if (currentIndex < 0) {
            currentIndex = 2
        }
        updateImage()
    }

    private fun onClickButtonForwardArrow() {
        currentIndex++
        if (currentIndex >= imageNames.size) {
            currentIndex = 0
        }
        updateImage()
    }

    private fun updateImage() {
        val imageName = imageNames[currentIndex]
        imageView.setImageResource(getResourceIdByName(imageName))
    }

    private fun getResourceIdByName(name: String): Int {
        return try {
            resources.getIdentifier(name, "drawable", packageName)
        } catch (e: Exception) {
            0
        }
    }

    private fun onClickButtonGoOver() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
