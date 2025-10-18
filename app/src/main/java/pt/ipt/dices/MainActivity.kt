package pt.ipt.dices

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import pt.ipt.dices.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // findViewById<Button>(R.id.btnRoll).setOnClickListener {
        binding.btnRoll.setOnClickListener {
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        /* Algorithm
           1- create a new random value [1, 6]
           2- determine the image to show
           3- show the image
           4- show the random value
           5- show the random value by extension
         */

        // 1-
        val randomNumber = (1..6).random()
        // val randomNumber = Random.nextInt(6)+1

        // 2-
        val drawableResource = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        // 3-
        binding.imageView.setImageResource(drawableResource)

        // 4-
        binding.txtDiceValue.text = randomNumber.toString()

        // 5-
        val textNumber = when (randomNumber) {
            1 -> R.string.n1
            2 -> R.string.n2
            3 -> R.string.n3
            4 -> R.string.n4
            5 -> R.string.n5
            6 -> R.string.n6
            else -> R.string.n
        }
        // assign the text to the TextView
        val txt= getString(textNumber)
        binding.txtDiceValueByExtension.text =" ($txt)"

    }



}