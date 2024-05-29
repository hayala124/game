package com.hayala.game

import android.annotation.SuppressLint
import android.content.Intent
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
        binding.btnTest.setOnClickListener { onClickTest(data) }
        outputInformation()
    }

    @SuppressLint("SetTextI18n")
    private fun outputInformation() {
        when (data) {
            "типы данных" -> {
                binding.txtInformName.text = "Таблица базовых типов данных"
                binding.tableTypesOfData.visibility = View.VISIBLE
                binding.imageForTypesOfData.visibility = View.VISIBLE
                binding.imageForTypesOfData2.visibility = View.VISIBLE
                binding.textForTypeOfData.visibility = View.VISIBLE
                binding.txtInformation.text =
                    "C# является строго типизированным языком. Каждая переменная и константа имеет тип, как и каждое выражение, результатом вычисления которого является значение. Каждое объявление метода задает имя, тип и вид (значение, ссылка или вывод) для каждого входного параметра и для возвращаемого значения. В библиотеке классов .NET определены встроенные числовые типы и комплексные типы, представляющие разнообразные конструкции. К ним относятся файловая система, сетевые подключения, коллекции и массивы объектов, а также даты. Обычная программа на C# использует типы из этой библиотеки классов и пользовательские типы, которые моделируют уникальные концепции конкретной сферы применения.\n" +
                            "В типах может храниться следующая информация:\n" +
                            "место, необходимое для хранения переменной этого типа;\n" +
                            "максимальное и минимальное значения, которые могут быть представлены;\n" +
                            "содержащиеся в типе члены (методы, поля, события и т. д.);\n" +
                            "базовый тип, от которого наследует этот тип;\n" +
                            "реализуемые им интерфейсы;\n" +
                            "разрешенные виды операций.\n" +
                            "Компилятор использует сведения о типах, чтобы проверить, все ли операции, выполняемые в коде, являются типобезопасными. Например, при объявлении переменной типа int компилятор позволяет в дополнение использовать переменную и операции вычитания. При попытке выполнить эти же операции для переменной типа bool компилятор выдаст ошибку, как показано в следующем примере:"
                binding.textForTypeOfData.text = "Задание типов в объявлениях переменных\n\n" +
                        "Когда вы объявляете в программе переменную или константу, для нее нужно задать тип либо использовать ключевое слово var, чтобы компилятор определил тип самостоятельно.\n" +
                        "В следующем примере показаны некоторые объявления переменных, использующие встроенные числовые типы и сложные пользовательские типы:"

                binding.btnTest.visibility = View.VISIBLE
            }

            "переменные" -> {
                binding.txtInformName.text = "Переменные и константы"
                binding.txtInformation.text =
                    "Для хранения данных в программе применяются переменные. Переменная представляет именнованную область памяти, в которой хранится значение определенного типа. " +
                            "Она имеет тип, имя и значение. Тип определяет, какого рода информацию может хранить переменная.\n\n" +
                            "Перед использованием любую переменную надо определить. Синтаксис определения переменной выглядит следующим образом:\n\n" +
                            "тип имя_переменной;\n\n" +
                            "В качестве имени переменной может выступать любое произвольное название, которое удовлетворяет следующим требованиям:\n\n" +
                            "- имя может содержать любые цифры, буквы и символ подчеркивания, при этом первый символ в имени должен быть буквой или символом подчеркивания;\n\n" +
                            "- в имени не должно быть знаков пунктуации и пробелов;\n\n" +
                            "- имя не может быть ключевым словом языка C#. Таких слов не так много, и при работе в Visual Studio среда разработки подсвечивает ключевые слова синим цветом.\n\n" +
                            "Хотя имя переменной может быть любым, но следует давать переменным описательные имена, которые будут говорить об их предназначении.\n\n" +
                            "Можно сразу при определении присвоить переменной значение. Данный прием называется инициализацией:\n\n" +
                            "string name = \"Tom\";\n\n" +
                            "В C# есть константы. Она должна быть обязательно инициализирована при определении, и после определения значение константы не может быть изменено.\n\n" +
                            "Константы предназначены для описания таких значений, которые не должны изменяться в программе. Для определения констант используется ключевое слово const, которое указывается перед типом константы:\n\n" +
                            "const string NAME = \"Tom\";\n\n" +
                            "Таким образом, если нам надо хранить в программе некоторые данные, но их не следует изменить, они определяются в виде констант. Если же их можно изменять, то они определяются в виде переменных."
                binding.btnTest.visibility = View.VISIBLE
            }

            "операции" -> {
                binding.txtInformName.text = "Арифметические и Поразрядные операции"
                binding.tableOperations.visibility = View.VISIBLE
                binding.textViewHomework.visibility = View.VISIBLE
                binding.textViewHomework.text = "Домашнее задание:\nСоздайте проект в Visual Studio и попробуйте создать различные переменные и константы с разными типами данных."

            }

            "условные выражения" -> {
                binding.txtInformName.text = "Конструкция if else\nи тернарная операция"
                binding.youtubePlayerIfElse.visibility = View.VISIBLE
                binding.youtubePlayerTernaryOperator.visibility = View.VISIBLE
            }

            "циклы и функции" -> {

            }

            "Массивы" -> {

            }

            "объектно-ориентированное программирование" -> {

            }
        }
    }

    private fun onClickTest(data: String) {
        binding.btnTest.text = data
        val intent = Intent(this, TestActivity::class.java)
        intent.putExtra("test_1", binding.btnTest.text.toString())
        startActivity(intent)
    }
}