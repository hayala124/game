package com.hayala.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hayala.game.databinding.ActivityInformationBinding
import java.util.Locale

class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding
    private lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater).also { setContentView(it.root) }


        data = intent.getStringExtra("textInformation").toString().lowercase(Locale.getDefault())
        binding.txtInformName.text = data

        outputInformation()
    }

    @SuppressLint("SetTextI18n")
    private fun outputInformation() {
        when (data) {
            "типы данных" -> {
                binding.txtInformName.text = "Таблица базовых типов данных"
                binding.tableTypesOfData.visibility = View.VISIBLE
                binding.btnTest.visibility = View.INVISIBLE
            }
            "переменные" -> {
                binding.txtInformName.text = "Переменные и константы"
                binding.txtInformation.movementMethod = ScrollingMovementMethod()
                binding.txtInformation.text = "Для хранения данных в программе применяются переменные. Переменная представляет именнованную область памяти, в которой хранится значение определенного типа. " +
                        "Она имеет тип, имя и значение. Тип определяет, какого рода информацию может хранить переменная.\n\n" +
                        "Перед использованием любую переменную надо определить. Синтаксис определения переменной выглядит следующим образом:\n\n" +
                        "тип имя_переменной;\n\n" +
                        "В качестве имени переменной может выступать любое произвольное название, которое удовлетворяет следующим требованиям:\n\n" +
                        "- имя может содержать любые цифры, буквы и символ подчеркивания, при этом первый символ в имени должен быть буквой или символом подчеркивания;\n\n" +
                        "- в имени не должно быть знаков пунктуации и пробелов;\n\n" +
                        "- имя не может быть ключевым словом языка C#. Таких слов не так много, и при работе в Visual Studio среда разработки подсвечивает ключевые слова синим цветом.\n\n" +
                        "Хотя имя переменой может быть любым, но следует давать переменным описательные имена, которые будут говорить об их предназначении.\n\n" +
                        "Можно сразу при определении присвоить переменной значение. Данный прием называется инициализацией:\n\n" +
                        "string name = \"Tom\";\n\n" +
                        "В C# есть константы. Она должна быть обязательно инициализирована при определении, и после определения значение константы не может быть изменено.\n\n" +
                        "Константы предназначены для описания таких значений, которые не должны изменяться в программе. Для определения констант используется ключевое слово const, которое указывается перед типом константы:\n\n" +
                        "const string NAME = \"Tom\";\n\n" +
                        "Таким образом, если нам надо хранить в программе некоторые данные, но их не следует изменить, они определяются в виде констант. Если же их можно изменять, то они определяются в виде переменных."
            }
            "операции" -> {
                binding.txtInformName.text = "Арифметичсекие и Поразрядные операции"
                binding.tableOperations.visibility = View.VISIBLE

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