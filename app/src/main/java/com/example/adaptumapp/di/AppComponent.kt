package com.example.adaptumapp.di

import com.example.adaptumapp.di.modules.AppModule
import com.example.adaptumapp.presentation.MainActivity
import com.example.adaptumapp.presentation.fragments.EventsFragment
import com.example.adaptumapp.presentation.fragments.ProfileFragment
import com.example.adaptumapp.presentation.fragments.TaskFragment
import com.example.adaptumapp.presentation.fragments.TasksFragment
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

    fun inject(profileFragment: ProfileFragment)

    fun inject(eventsFragment: EventsFragment)

    fun inject(tasksFragment: TasksFragment)

    fun inject(taskFragment: TaskFragment)

}