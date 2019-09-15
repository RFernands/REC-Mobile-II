package com.example.rebecca.rec_mobile_ii.scenarios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.rebecca.rec_mobile_ii.R
import com.example.rebecca.rec_mobile_ii.common.Screens
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class SplashActivity : AppCompatActivity() {

    val cicerone: Cicerone<Router> = Cicerone.create()
    val navigator = SupportAppNavigator(this, R.id.container)

    private val SPLASH_TIME_OUT:Long=3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            cicerone.router.navigateTo(Screens.ListScreen())
            finish()
        }, SPLASH_TIME_OUT)
    }

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }
}
