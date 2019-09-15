package com.example.rebecca.rec_mobile_ii

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import android.widget.Toast
import com.example.rebecca.rec_mobile_ii.entities.Meal
import kotlinx.android.synthetic.main.activity_meals_list.*

class MealsListActivity : AppCompatActivity(), MealsListContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals_list)

        latestMealsRV()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_mealslist, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.randomMeal -> randomMealRV()
            R.id.latestMeals -> latestMealsRV()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun latestMealsRV() {
        typeOfMeals.text = "Latest Meals"
        val presenter: MealsListContract.Presenter = MealsListPresenter(this,this)
        presenter.LatestMeals()
    }

    private fun randomMealRV() {
        typeOfMeals.text = "Random Meal"
        val presenter: MealsListContract.Presenter = MealsListPresenter(this,this)
        presenter.RandomMeals()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }

    override fun showList(meals: List<Meal>){
        val adapter = MealsListAdapter(this, meals){
            val intent = Intent(this, MealDetailsActivity::class.java)
            intent.putExtra("Meal", it)
            startActivity(intent)
        }

        rvMeals.adapter = adapter
        rvMeals.layoutManager = LinearLayoutManager(this)
    }
}
