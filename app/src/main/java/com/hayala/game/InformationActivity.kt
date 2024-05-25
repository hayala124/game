package com.hayala.game

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hayala.game.databinding.ActivityInformationBinding
import java.util.Locale

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding
    private lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater).also { setContentView(it.root) }


        data = intent.getStringExtra("textInformation").toString().lowercase(Locale.getDefault())
        binding.txtInf.text = data

        outputInformation()
    }

    @SuppressLint("SetTextI18n")
    private fun outputInformation() {
        if (data == "типы данных") {
            binding.txtInf.text = "Самые популярные типы данных:\n" +
                    "\n" +
                    "Int - Целые числа в диапазоне от -2,147,483,648 (-2^31) до 2,147,483,647 (2^31- 1)\n" +
                    "Double - Дробные числа в диапазоне от -1.7E+308 до 1.7E+308\n" +
                    "String - Текстовая информация\n" +
                    "Boolean - Хранит либо true, либо false\n\n" +
                    "Типы, которые используются реже\n\n" +
                    "Byte - Целые числа в диапазоне от -128 до 127\n" +
                    "Short - Целые числа в диапазоне от -32768 до 32767\n" +
                    "Long - Целые числа в диапазоне от -9,223,372,036,854,775,808 (-2^63) до 9,223,372,036,854,775,807 (2^63- 1)\n" +
                    "Float - Дробные числа в диапазоне от -3.4E+38 до 3.4E+38\n" +
                    "Char - Символы (текст)\n\n" +
                    "Изменяемые (mutable) и неизменяемые (immutable) переменные\n\n" +
                    "val - Неизменяемая (immutable) переменная, то есть та, которую можно инициализировать только один раз\n" +
                    "var - Изменяемая (mutable) переменная\n"
        }
        else if (data == "переменные") {

        }
        else if (data == "операторы") {

        }
        else if (data == "условные выражения") {

        }
        else if (data == "циклы") {

        }
        else if (data == "функции") {

        }
        else if (data == "коллекции") {

        }
    }
}