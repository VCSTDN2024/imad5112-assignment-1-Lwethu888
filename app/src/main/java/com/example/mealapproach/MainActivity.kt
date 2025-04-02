package com.example.mealapproach
    //
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var approachMeal: EditText
    private lateinit var MealApproachText: TextView
    private lateinit var buttonApproach: Button
    private lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        approachMeal = findViewById(R.id.approachMeal)
        MealApproachText = findViewById(R.id.MealApproachText)
        buttonApproach = findViewById(R.id.buttonApproach)
        buttonReset = findViewById(R.id.buttonReset)

        buttonApproach.setOnClickListener {
            handleApproachMeal()
        }
        buttonReset.setOnClickListener {
            handleResetMealApproach()
        }
    }

    private fun handleApproachMeal() {
        val mealInput = approachMeal.text.toString()
        if (mealInput.isEmpty()) {
            MealApproachText.text = "Enter valid time of day displayed in the hint"
            return
        }
        try {
            MealApproachText.text = when(mealInput.lowercase()){
                "morning" -> "Waffles with bacon, eggs with toast and tea"
                "mid-morning" -> "Muffin, Apple"
                "afternoon" -> "Gourmet sandwich, Salad, Chicken burger"
                "mid-afternoon" -> "Lunch bar, Salted Lays, Sweets"
                "supper" -> "Hake with chips, Ribs and chips, pap with woers, pasta with mince"
                "after-dinner snack" -> "pancakes, cake, ice-cream, banana split"
                else -> throw IllegalArgumentException("$mealInput inappropriate time of day")
            }

            }catch (e: IllegalArgumentException) {
            MealApproachText.text = e.message
        }
    }
    private fun handleResetMealApproach(){
        MealApproachText.setText("")
    }
}



