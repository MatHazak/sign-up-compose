package me.mathazak.signupcompose.di

import android.content.Context
import me.mathazak.signupcompose.data.SignupRepository

class AppModule(private val appContext: Context) {

    val signupRepository: SignupRepository by lazy {
        SignupRepository(appContext)
    }
}