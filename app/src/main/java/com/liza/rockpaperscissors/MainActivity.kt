package com.liza.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        setContentView(R.layout.activity_main)
    }
    private val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)

    fun main(args: Array<String>) {}

    fun getGameChoice(optionsParam: Array<String>) =
        optionsParam[(Math.random() * optionsParam.size).toInt()]

    fun getUserChoice(optionsParam: Array<String>): String {
        var isValidChoice = false
        var userChoice = ""
        //Выполнять цикл, пока пользователь не введет допустимый вариант
        while (!isValidChoice) {
            //Запросить у пользователя его выбор
            print("Please enter one of the following:")
            for (item in optionsParam) print(" $item")
            println(".")
            //Прочитать пользовательский ввод
            val userInput = readLine()
            //Проверить пользовательский ввод
            if (userInput != null && userInput in optionsParam) {
                isValidChoice = true
                userChoice = userInput

                //Если выбран недопустимый вариант, сообщить пользователю
                if (!isValidChoice) println("You must enter a valid choice.")
            }
            return (userChoice)
        }
        fun printResult(userChoice: String, gameChoice: String) {
            val result: String
            //Определить результат
            if (userChoice == gameChoice) result = "Tie!"
            else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
                (userChoice == "Paper" && gameChoice == "Rock") ||
                (userChoice == "Scissors" && gameChoice == "Paper")
            ) result = "You win!"
            else result = "You lose!"
            //Вывести результат
            println("You chose $userChoice. I chose $gameChoice. $result")
        }
        return (userChoice)
    }
}