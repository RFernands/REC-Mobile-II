package com.example.rebecca.rec_mobile_ii

import com.example.rebecca.rec_mobile_ii.entities.MealList
import com.example.rebecca.rec_mobile_ii.others.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsListPresenter(val view: MealsListContract.View) : MealsListContract.Presenter {

    override fun RandomMeals(){
        val mealsService = RetrofitInicializer().createMealsService()

        val call = mealsService.getRandomMeals()

        call.enqueue(object : Callback<MealList> {
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                view.showMessage("Erro de conexão.")
            }

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if(response.body() != null){
                    view.showList(response.body()!!.meals)
                }else {
                    view.showMessage("Não foi possivel encontrar a refeição.")
                }
            }
        })
    }
}