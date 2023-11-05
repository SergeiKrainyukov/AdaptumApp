package com.example.adaptumapp.di

import com.example.adaptumapp.di.modules.AppModule
import com.example.adaptumapp.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}