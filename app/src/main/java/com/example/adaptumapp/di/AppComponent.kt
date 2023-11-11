package com.example.adaptumapp.di

import com.example.adaptumapp.di.modules.AppModule
import com.example.adaptumapp.di.modules.HandlersModule
import com.example.adaptumapp.di.modules.NetworkModule
import com.example.adaptumapp.di.modules.RepositoryModule
import com.example.adaptumapp.di.modules.ViewModelModule
import com.example.adaptumapp.presentation.MainActivity
import com.example.adaptumapp.presentation.fragments.AdaptPlansFragment
import com.example.adaptumapp.presentation.fragments.EventsFragment
import com.example.adaptumapp.presentation.fragments.LoginFragment
import com.example.adaptumapp.presentation.fragments.ProfileFragment
import com.example.adaptumapp.presentation.fragments.TrackerFragment
import com.example.adaptumapp.presentation.fragments.StagesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        HandlersModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(profileFragment: ProfileFragment)

    fun inject(eventsFragment: EventsFragment)

    fun inject(stagesFragment: StagesFragment)

    fun inject(trackerFragment: TrackerFragment)

    fun inject(loginFragment: LoginFragment)

    fun inject(adaptPlansFragment: AdaptPlansFragment)

}