package com.hayala.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.hayala.game.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    private lateinit var imageView: ImageView

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

    }

    private fun onClickButtonForwardArrow() {
       /* if (R.id.img1.toString() == imageView.id.toString()) {
              imageView.setImageResource(R.drawable.fon)
          }
          else if (imageView.tag == "fon") {
              imageView.setImageResource(R.drawable.field_for_letter)
          }
          else
              imageView.setImageResource(R.drawable.icon_c_sharp)

        Toast.makeText(applicationContext, imageView.id.toString(), Toast.LENGTH_LONG).show()
        Toast.makeText(applicationContext, imageViewTag1.toString(), Toast.LENGTH_LONG).show()*/
        imageView.setImageResource(R.drawable.fon)


    }

    private fun onClickButtonGoOver() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
