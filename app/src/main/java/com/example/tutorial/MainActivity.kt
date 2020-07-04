package com.example.tutorial

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allow user to roll dice and view its result on screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button);
        rollButton.setOnClickListener { rollDice() }

        // Display the dice for the first time and lucky number
        rollDice()
    }

    /**
     * Roll the dice and show its result on the screen
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and red color, then roll it
        val diceOne = Dice(6, "red")
        val diceOneRoll = diceOne.roll()
        val diceTwo = Dice(6, "blue")
        val diceTwoRoll = diceTwo.roll()

        // Update screen of text view with value of dice roll
        val diceImageOne: ImageView = findViewById(R.id.imageView1)
        diceImageOne.setImageResource(getDrawableResource(diceOneRoll))
        diceImageOne.contentDescription = diceOneRoll.toString()

        val diceImageTwo: ImageView = findViewById(R.id.imageView2)
        diceImageTwo.setImageResource(getDrawableResource(diceTwoRoll))
        diceImageTwo.contentDescription = diceTwoRoll.toString()
    }

    /**
     * Get drawable resource based on dice roll value
     */
    private fun getDrawableResource(dice: Int): Int {
        return when (dice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

class Dice(private val numSides: Int, val color: String) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}