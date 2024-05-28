package com.hayala.game

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hayala.game.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private lateinit var buttonNextQuestion: Button
    private lateinit var questionTextView: TextView
    private lateinit var answerEditText: EditText

    private var countQuestions = 0
    private var countRightAnswers = 0
    data class Question(val questionText: String, val correctAnswer: String)

    val questions = listOf(
        Question( "Как называется именнованная область памяти, в которой хранится значение определенного типа?\n(1 - константа, 2 - переменная, 3 - память)", "2"),
        Question("Выберите тип данных, который может хранить информацию почти любого типа данных?\n(1 - int, 2 - char, 3 - object, 4 - bool, 5 - string)", "3"),
       /* Question("Как называется приём присвоения переменной значения при определении переменной?\n(1 - именование, 2 - инициализация, 3 - объявление, 4 - нет такого понятия)", "2"),
        Question("Как называется определение, которое обозначает постоянные значения, которые известны во время компиляции и не изменяются во время выполнения программы?\n(1 - константа, 2 - переменная, 3 - не существует такого понятия", "1"),
        Question("Как обозначается знак для получения остатка от деления?\n(1 - \\, 2 - *, 3 - >>, 4 - %)", "4"),
        Question("Верно ли утрверждение, что \"Continue пропускает итерацию, break выходит из цикла?\"\n(1 - да, 2 - нет, наоборот)", "1"),
        Question("Верно ли что это || - операция логического умножения и возвращает true, если оба операнда одновременно равны true?\n(1 - да, 2 - нет, это логическое сложение)", "2"),
        Question("Конструкция try-catch работает с ..?\n(1 - файлами, 2 - исключениями, 3 - базой данных, 3 - классами) ", "2"),
        Question("Правильно ли создан данный массив: int[] arr = new int [2] {2, 5};?\n(1 - да, 2 - нет)", "1"),*/
        Question("Правильно ли создана переменная int num = \"1\";\n(1 - да, 2 - нет)", "2")
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater).also { setContentView(it.root) }
        buttonNextQuestion = binding.btnNextAnswer

        questionTextView = binding.textQuestion
        answerEditText = binding.editTextAnswer

        displayQuestion()

        buttonNextQuestion.setOnClickListener { onClickButtonStart() }
    }

    private fun displayQuestion() {
        answerEditText.requestFocus()
        val question = questions[countQuestions]
        questionTextView.text = question.questionText
        answerEditText.setText("")
    }

    private fun checkAnswer() {
        val userInput = answerEditText.text.toString().trim().lowercase()
        if (userInput == questions[countQuestions].correctAnswer) {
            countRightAnswers++
        }
    }
    private fun onClickButtonStart() {
        if (answerEditText.text.toString().trim() == "")
            Toast.makeText(applicationContext, "Введите ответ!", Toast.LENGTH_SHORT).show()
        else {
            checkAnswer()
            countQuestions++
            if (countQuestions < questions.size) {
                displayQuestion()
                if (countQuestions == questions.size - 1) {
                    buttonNextQuestion.text = "Завершить тест"
                }
            } else if (countQuestions == questions.size){

                buttonNextQuestion.text = "Выйти"
                questionTextView.visibility = View.INVISIBLE
                binding.textTest.visibility = View.INVISIBLE
                answerEditText.visibility = View.INVISIBLE
                binding.textResult.text = "Правильных ответов ${countRightAnswers} из ${questions.size}"
            }
            else
                finish()
        }
    }
}