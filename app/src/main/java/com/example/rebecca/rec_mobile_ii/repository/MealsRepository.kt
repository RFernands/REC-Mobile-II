package com.example.rebecca.rec_mobile_ii.repository

import android.content.Context
import com.example.rebecca.rec_mobile_ii.entities.Meal
import com.example.rebecca.rec_mobile_ii.entities.MealList
import com.example.rebecca.rec_mobile_ii.others.RetrofitInicializer
import io.paperdb.Paper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MealsRepository(val context: Context) {

    fun getLatestMeals(onSuccess: ((meals: List<Meal>, cachedDate: Boolean) -> Unit),
                       onFailure: ((t: Throwable) -> Unit)){

        Paper.init(context)
        var latestsMeals: List<Meal>? = null

        val mealsService = RetrofitInicializer().createMealsService()

        val call = mealsService.getLatestMeals()

        call.enqueue(object : Callback<MealList> {
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                latestsMeals = Paper.book().read("LatestMeals")

                if (latestsMeals != null) {

                    onSuccess(latestsMeals!!, true)
                } else{
                    onFailure(t)
                }
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                latestsMeals = response.body()?.meals

                if (latestsMeals != null) {
                    Paper.book().write("LatestMeals", latestsMeals)
                    onSuccess(latestsMeals!!, false)
                } else{
                    latestsMeals = Paper.book().read("LatestMeals")

                    if (latestsMeals != null){
                        onSuccess(latestsMeals!!, true)
                    } else{
                        onFailure(Exception("onResponse without data"))
                    }
                }
            }
        })
    }

    fun getRandomMeal(onSuccess: ((meals: List<Meal>, cachedDate: Boolean) -> Unit),
                       onFailure: ((t: Throwable) -> Unit)){

        Paper.init(context)
        var randomMeal: List<Meal>? = null

        val mealsService = RetrofitInicializer().createMealsService()

        val call = mealsService.getRandomMeals()

        call.enqueue(object : Callback<MealList> {
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                randomMeal = Paper.book().read("RandomMeal")

                if (randomMeal != null) {

                    onSuccess(randomMeal!!, true)
                } else{
                    onFailure(t)
                }
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                randomMeal = response.body()?.meals

                if (randomMeal != null) {
                    Paper.book().write("RandomMeal", randomMeal)
                    onSuccess(randomMeal!!, false)
                } else{
                    randomMeal = Paper.book().read("RandomMeal")

                    if (randomMeal != null){
                        onSuccess(randomMeal!!, true)
                    } else{
                        onFailure(Exception("onResponse without data"))
                    }
                }
            }
        })
    }

}