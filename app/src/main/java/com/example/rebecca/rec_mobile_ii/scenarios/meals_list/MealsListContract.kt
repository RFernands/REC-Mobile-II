package com.example.rebecca.rec_mobile_ii.scenarios.meals_list

import com.example.rebecca.rec_mobile_ii.entities.Meal

interface MealsListContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(meals: List<Meal>)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun LatestMeals()
        fun RandomMeals()
    }
}