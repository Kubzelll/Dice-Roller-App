package pl.kubzel.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollbutton: Button = findViewById(R.id.roll_button)
        val resetbtn: Button = findViewById(R.id.btn_reset)
        resetbtn.setOnClickListener{
            reset()
        }
        rollbutton.setOnClickListener{
            rolldice()
        }
        diceImage = findViewById(R.id.imageholder)
    }

    private fun reset() {
        val textview: TextView = findViewById(R.id.numberview)
        diceImage.setImageResource(R.drawable.empty_dice)
        textview.text = "First roll the dice!"

    }

    private fun rolldice() {
        val textview: TextView = findViewById(R.id.numberview)
        val randomInt = Random().nextInt(6) + 1
        val imageToSet = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        diceImage.setImageResource(imageToSet)
        textview.text = "You rolled ${randomInt.toString()}"

    }
}