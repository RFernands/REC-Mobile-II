package com.example.rebecca.rec_mobile_ii.scenarios.meal_details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.rebecca.rec_mobile_ii.R
import com.example.rebecca.rec_mobile_ii.entities.Meal
import com.example.rebecca.rec_mobile_ii.others.GlideApp
import kotlinx.android.synthetic.main.activity_meal_details.*

class MealDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_details)

        val meal = intent.getSerializableExtra("Meal") as Meal

        GlideApp.with(this)
            .load(meal.strMealThumb)
            .into(imgMeal)

        mealTitle.text = meal.strMeal
        instruction.text = meal.strInstructions

        val ingredients = mutableListOf(meal.strIngredient1, meal.strIngredient2,
            meal.strIngredient3,meal.strIngredient4,meal.strIngredient5,meal.strIngredient6,
            meal.strIngredient7,meal.strIngredient8,meal.strIngredient9,meal.strIngredient10,
            meal.strIngredient11,meal.strIngredient12,meal.strIngredient13,meal.strIngredient14,
            meal.strIngredient15,meal.strIngredient16,meal.strIngredient17,meal.strIngredient18,meal.strIngredient19,meal.strIngredient20)

        val quantity = mutableListOf(meal.strMeasure1, meal.strMeasure2,
            meal.strMeasure3,meal.strMeasure4,meal.strMeasure5,meal.strMeasure6,
            meal.strMeasure7,meal.strMeasure8,meal.strMeasure9,meal.strMeasure10,
            meal.strMeasure11,meal.strMeasure12,meal.strMeasure13,meal.strMeasure14,
            meal.strMeasure15,meal.strMeasure16,meal.strMeasure17,meal.strMeasure18,meal.strMeasure19,meal.strMeasure20)

        val ingredientsBuilder = java.lang.StringBuilder()
        val quantityBuilder = StringBuilder()

        for(item in ingredients.listIterator()){
            if(!item.isNullOrBlank()){
                ingredientsBuilder.append(item).append('\n')
            }
        }

        for(item in quantity.listIterator()){
            if(!item.isNullOrBlank()){
                quantityBuilder.append(item).append('\n')
            }
        }

        ingredientsList.text = ingredientsBuilder
        quantityList.text = quantityBuilder
    }
}
