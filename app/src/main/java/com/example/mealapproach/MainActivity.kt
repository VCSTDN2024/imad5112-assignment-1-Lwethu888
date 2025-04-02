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

    //The lateinit means that these variables will be initialized later
    //These variables correspond to the UI components
    private lateinit var approachMeal: EditText
    private lateinit var MealApproachText: TextView
    private lateinit var buttonApproach: Button
    private lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //the findviewbyid combines the ui components in to the layout to their appropriate variable codes
        approachMeal = findViewById(R.id.approachMeal)
        MealApproachText = findViewById(R.id.MealApproachText)
        buttonApproach = findViewById(R.id.buttonApproach)
        buttonReset = findViewById(R.id.buttonReset)

        //sets up event listeners for the buttons calls when clicked
        buttonApproach.setOnClickListener {
            handleApproachMeal()
        }
        buttonReset.setOnClickListener {
            handleResetMealApproach()
        }
    }
    //Retrieves the users input from the EditText
    private fun handleApproachMeal() {
        val mealInput = approachMeal.text.toString()
        //checks users input if its empty.If it is a warning message it displays
        if (mealInput.isEmpty()) {
            MealApproachText.text = "Enter valid time of day displayed in the hint"
            return
        }
        //Converts the users input to lowercase for comparison
        // The use of the when statement provides a meal suggestion for the specific time of day
        // If the input doesn't match the time of day an exception is thrown that they must enter the appropriate value
        // The catch captures the exception and displays an error message
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
    }//Resets the meal that is displayed in the TextView to an empty screen
    private fun handleResetMealApproach(){
        MealApproachText.setText("")
    }
}



