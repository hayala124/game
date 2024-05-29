package com.hayala.game

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hayala.game.databinding.ActivityTestBinding
import java.util.Locale

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private lateinit var buttonNextQuestion: Button
    private lateinit var questionTextView: TextView
    private lateinit var answerEditText: EditText

    private var countQuestions = 0
    private var countRightAnswers = 0
    private lateinit var Q: List<Question>
    data class Question(var questionText: String, var correctAnswer: String)

    var question_2 = listOf(
        Question("Для чего применяются переменные в программе?\n1) для хранения данных,\n2) для передачи данных,\n3) для хранения и передачи данных", "1"),
        Question("Что определяет то, какого рода информацию может хранить переменная?\n1) имя переменной,\n2) значение переменной,\n3) тип переменной", "3"),
        Question("Где указывается ключевое слово const?\n1) после типа константы,\n2) перед типом константы", "2")
        )

    var question_1 = listOf(
        Question("Какой размер у типа long?\n1) 32,\n2) 128,\n3) 64,\n4) 8", "3"),
        Question("Какой тип описывает логическую переменную?\n1) int,\n2) float,\n3) long,\n4) bool", "4"),
        Question("Какая информация может хранится в типах?\n1) место, необходимое для хранения переменной этого типа,\n2) максимальное и минимальное значения, которые могут быть представлены,\n3) разрешенные виды операций,\n4) все ответы верны", "4"),
        Question("При объявлении переменной типа ____ компилятор позволяет в дополнение использовать переменную и операции вычитания. Вставьте пропущенное слово.\n1) int,\n2) bool,\n3) char", "1"),
        Question("Какое ключевое слово нужно использовать в программе, если не задан тип?", "var")
        )

    var questions = listOf(
        Question( "Как называется именнованная область памяти, в которой хранится значение определенного типа?\n1 - константа,\n2 - переменная,\n3 - память", "2"),
        Question("Выберите тип данных, который может хранить информацию почти любого типа данных?\n1 - int,\n2 - char,\n3 - object,\n4 - bool,\n 5 - string", "3"),
        Question("Как называется приём присвоения переменной значения при определении переменной?\n1 - именование,\n2 - инициализация,\n3 - объявление,\n4 - нет такого понятия", "2"),
        Question("Как называется определение, которое обозначает постоянные значения, которые известны во время компиляции и не изменяются во время выполнения программы?\n1 - константа,\n2 - переменная,\n3 - не существует такого понятия", "1"),
        Question("Как обозначается знак для получения остатка от деления?\n1 - \\,\n2 - *,\n3 - >>,\n4 - %", "4"),
        Question("Верно ли утрверждение, что \"Continue пропускает итерацию, break выходит из цикла?\"\n1 - да,\n2 - нет, наоборот", "1"),
        Question("Верно ли что это || - операция логического умножения и возвращает true, если оба операнда одновременно равны true?\n1 - да,\n2 - нет, это логическое сложение", "2"),
        Question("Конструкция try-catch работает с ..?\n1 - файлами,\n2 - исключениями,\n3 - базой данных,\n3 - классами", "2"),
        Question("Правильно ли создан данный массив: int[] arr = new int [2] {2, 5};?\n1 - да,\n2 - нет", "1"),
        Question("Правильно ли создана переменная int num = \"1\";\n1 - да,\n2 - нет", "2")
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var data = intent.getStringExtra("test_1").toString().lowercase(Locale.getDefault())
        getTest(data)

        binding = ActivityTestBinding.inflate(layoutInflater).also { setContentView(it.root) }
        buttonNextQuestion = binding.btnNextAnswer

        questionTextView = binding.textQuestion
        answerEditText = binding.editTextAnswer

        displayQuestion(Q)

        buttonNextQuestion.setOnClickListener { onClickButtonStart(Q) }
    }

    private fun displayQuestion(question: List<Question>) {
        answerEditText.requestFocus()
        val question = question[countQuestions]
        questionTextView.text = question.questionText
        answerEditText.setText("")
    }

    private fun checkAnswer(question: List<Question>) {
        val userInput = answerEditText.text.toString().trim().lowercase()
        if (userInput == question[countQuestions].correctAnswer) {
            countRightAnswers++
        }
    }
    private fun onClickButtonStart(question: List<Question>) {
        if (answerEditText.text.toString().trim() == "")
            Toast.makeText(applicationContext, "Введите ответ!", Toast.LENGTH_SHORT).show()
        else {
            checkAnswer(question)
            countQuestions++
            if (countQuestions < question.size) {
                displayQuestion(question)
                if (countQuestions == question.size - 1) {
                    buttonNextQuestion.text = "Завершить тест"
                }
            } else if (countQuestions == question.size){
                buttonNextQuestion.text = "Выйти"
                questionTextView.visibility = View.INVISIBLE
                binding.textTest.visibility = View.INVISIBLE
                answerEditText.visibility = View.INVISIBLE
                binding.textResult.text = "Правильных ответов ${countRightAnswers} из ${question.size}"
            }
            else
                finish()
        }
    }

    private fun getTest(data: String) {
        if (data == "типы данных")
            Q = question_1
        else if (data == "переменные")
            Q = question_2
        else
            Q = questions
    }
}