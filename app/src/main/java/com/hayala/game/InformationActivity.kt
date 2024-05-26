package com.hayala.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hayala.game.databinding.ActivityInformationBinding
import java.util.Locale

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding
    private lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityInformationBinding.inflate(layoutInflater).also { setContentView(it.root) }


        data = intent.getStringExtra("textInformation").toString().lowercase(Locale.getDefault())
        binding.txtInformName.text = data

        outputInformation()
    }

    @SuppressLint("SetTextI18n")
    private fun outputInformation() {
        when (data) {
            "типы данных" -> {
               /* binding.txtInf.text = "Базовые типы данных:\n\n" +
                        "int: хранит целое число от -2147483648 до 2147483647\n" +
                        "bool: хранит значение true или false (логические литералы\n" +
                        "byte: хранит целое число от 0 до 255\n" +
                        "float: хранит число с плавающей точкой от -3.4*10^38 до 3.4*10^38\n" +
                        "double: хранит число с плавающей точкой от ±5.0*10^-324 до ±1.7*10^308\n" +
                        "decimal: хранит десятичное дробное число\n" +
                        "char: хранит одиночный символ в кодировке Unicode\n"*/
                binding.txtInformName.text = "Таблица базовых типов данных"
                binding.tableTypesOfData.visibility = View.VISIBLE

            }
            "переменные" -> {
                binding.txtInformName.text
            }
            "операторы" -> {

            }
            "условные выражения" -> {

            }
            "циклы" -> {

            }
            "функции" -> {

            }
            "коллекции" -> {

            }
        }
    }
}