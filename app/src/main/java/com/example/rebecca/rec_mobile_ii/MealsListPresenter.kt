package com.example.rebecca.rec_mobile_ii

import android.content.Context
import com.example.rebecca.rec_mobile_ii.entities.Meal
import com.example.rebecca.rec_mobile_ii.entities.MealList
import com.example.rebecca.rec_mobile_ii.others.RetrofitInicializer
import io.paperdb.Paper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsListPresenter(val context: Context, val view: MealsListContract.View) : MealsListContract.Presenter {

    override fun LatestMeals(){

        view.showLoading()

        Paper.init(context)
        var latestsMeals: List<Meal>? = null

        val mealsService = RetrofitInicializer().createMealsService()

        val call = mealsService.getLatestMeals()

        call.enqueue(object : Callback<MealList> {
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                latestsMeals = Paper.book().read("LatestMeals")
                if (latestsMeals != null){
                    view.showMessage("Offline Meals.")
                    view.hideLoading()
                    view.showList(latestsMeals!!)
                } else{
                    view.hideLoading()
                    view.showMessage("No internet.")
                }
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                latestsMeals = response.body()?.meals

                if(latestsMeals != null){
                    Paper.book().write("LatestMeals", latestsMeals)
                    view.hideLoading()
                    view.showList(latestsMeals!!)
                } else {
                    latestsMeals = Paper.book().read("LatestMeals")
                    if (latestsMeals != null){
                        view.showMessage("Offline Meals.")
                        view.hideLoading()
                        view.showList(latestsMeals!!)
                    } else{
                        view.hideLoading()
                        view.showMessage("Can't find any meal.")
                    }
                }
            }
        })
    }

    override fun RandomMeals() {

        view.showLoading()

        Paper.init(context)
        var randomMeal: List<Meal>? = null

        val mealsService = RetrofitInicializer().createMealsService()

        val call = mealsService.getRandomMeals()

        call.enqueue(object : Callback<MealList> {
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                randomMeal = Paper.book().read("RandomMeal")
                if (randomMeal != null){
                    view.showMessage("Offline Meals.")
                    view.hideLoading()
                    view.showList(randomMeal!!)
                } else{
                    view.hideLoading()
                    view.showMessage("No internet.")
                }
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                randomMeal = response.body()?.meals

                if(randomMeal != null){
                    Paper.book().write("RandomMeal", randomMeal)
                    view.hideLoading()
                    view.showList(randomMeal!!)
                } else {
                    randomMeal = Paper.book().read("RandomMeal")
                    if (randomMeal != null){
                        view.showMessage("Offline Meals.")
                        view.hideLoading()
                        view.showList(randomMeal!!)
                    } else{
                        view.hideLoading()
                        view.showMessage("Can't find any meal.")
                    }
                }
            }
        })
    }
}