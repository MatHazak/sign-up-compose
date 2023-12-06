package me.mathazak.signupcompose

import android.app.Application
import me.mathazak.signupcompose.di.AppModule

class SignupComposeApp : Application() {
    companion object {
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModule(this)
    }
}