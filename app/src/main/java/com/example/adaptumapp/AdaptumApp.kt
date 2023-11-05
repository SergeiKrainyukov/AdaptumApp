package com.example.adaptumapp

import android.app.Application
import com.example.adaptumapp.di.DaggerAppComponent
import com.example.adaptumapp.di.modules.AppModule

class AdaptumApp : Application() {
    val appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
}