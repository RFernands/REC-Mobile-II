package com.example.rebecca.rec_mobile_ii.scenarios.meals_list

import android.content.Context
import com.example.rebecca.rec_mobile_ii.R
import com.example.rebecca.rec_mobile_ii.entities.Meal
import com.example.rebecca.rec_mobile_ii.others.GlideApp
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_meal.view.*

class MealsListAdapter(private val context: Context, meals: List<Meal>, val itemClickListener: ((meal: Meal) -> Unit)): GroupAdapter<ViewHolder>() {

    init {
        meals.forEach {
            add(MealItem(it))
        }
    }

    private inner class MealItem(val meal: Meal) : Item() {

        override fun bind(viewHolder: ViewHolder, position: Int) {

            viewHolder.containerView.mealTitle.text = meal.strMeal

            GlideApp.with(context)
                .load(meal.strMealThumb)
                .centerCrop()
                .into(viewHolder.containerView.imgMeal)

            viewHolder.containerView.setOnClickListener {
                itemClickListener(meal)
            }
        }

        override fun getLayout(): Int = R.layout.item_meal
    }
}