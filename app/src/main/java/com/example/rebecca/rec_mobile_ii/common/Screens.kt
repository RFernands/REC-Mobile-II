package com.example.rebecca.rec_mobile_ii.common

import android.content.Context
import android.content.Intent
import com.example.rebecca.rec_mobile_ii.scenarios.meal_details.MealDetailsActivity
import com.example.rebecca.rec_mobile_ii.entities.Meal
import com.example.rebecca.rec_mobile_ii.scenarios.meals_list.MealsListActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class ListScreen(): SupportAppScreen(){
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, MealsListActivity::class.java)
        }
    }

    class DetailsScreen(val context: Context?, val meal: Meal): SupportAppScreen(){
        override fun getActivityIntent(context: Context?): Intent {
            val intent = Intent(context, MealDetailsActivity::class.java)
            intent.putExtra("Meal", meal)
            return intent
        }
    }

}