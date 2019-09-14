package com.example.rebecca.rec_mobile_ii.others

import com.example.rebecca.rec_mobile_ii.entities.MealList
import retrofit2.Call
import retrofit2.http.GET

interface MealsService {
    @GET("latest.php")
    fun getLatestMeals(): Call<MealList>

    @GET(("random.php"))
    fun getRandomMeals(): Call<MealList>
}