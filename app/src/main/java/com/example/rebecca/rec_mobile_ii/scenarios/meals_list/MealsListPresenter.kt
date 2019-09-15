package com.example.rebecca.rec_mobile_ii.scenarios.meals_list

import android.content.Context
import com.example.rebecca.rec_mobile_ii.repository.MealsRepository

class MealsListPresenter(val context: Context, val view: MealsListContract.View) :
    MealsListContract.Presenter {

    override fun LatestMeals(){

        val repository = MealsRepository(context)

        view.showLoading()

        repository.getLatestMeals(
            onSuccess = { meals, cachedData ->
            view.hideLoading()
            if(cachedData) view.showMessage("Offline Meals.")
            view.showList(meals)
        },
            onFailure = {
                view.hideLoading()
                view.showMessage("Can't find any meal.")
            })
    }

    override fun RandomMeals() {

        val repository = MealsRepository(context)

        view.showLoading()

        repository.getRandomMeal(
            onSuccess = { meals, cachedData ->
                view.hideLoading()
                if(cachedData) view.showMessage("Offline Meals.")
                view.showList(meals)
            },
            onFailure = {
                view.hideLoading()
                view.showMessage("Can't find any meal.")
            })
    }
}