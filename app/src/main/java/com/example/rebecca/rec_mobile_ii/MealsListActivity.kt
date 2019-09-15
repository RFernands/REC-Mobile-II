package com.example.rebecca.rec_mobile_ii

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.rebecca.rec_mobile_ii.entities.Meal
import kotlinx.android.synthetic.main.activity_meals_list.*

class MealsListActivity : AppCompatActivity(), MealsListContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals_list)

        val presenter: MealsListContract.Presenter = MealsListPresenter(this)
        presenter.LatestMeals()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


    override fun showList(meals: List<Meal>){
        val adapter = MealsListAdapter(this, meals){
            /*val openBrowser = Intent(Intent.ACTION_VIEW)
            openBrowser.data = Uri.parse(meals.strMealThumb)
            startActivity(openBrowser)
            */
            val intent = Intent(this, MealDetailsActivity::class.java)
            intent.putExtra("Meal", it)
            startActivity(intent)
        }

        rvMeals.adapter = adapter
        rvMeals.layoutManager = LinearLayoutManager(this)
    }
}
