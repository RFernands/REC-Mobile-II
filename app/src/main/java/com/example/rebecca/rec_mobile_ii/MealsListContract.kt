package com.example.rebecca.rec_mobile_ii

import com.example.rebecca.rec_mobile_ii.entities.Meal

interface MealsListContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(meals: List<Meal>)
    }

    interface Presenter {
        //fun LatestMeals()
        fun RandomMeals()
    }
}