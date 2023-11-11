package com.example.adaptumapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adaptumapp.di.AppViewModelFactory
import com.example.adaptumapp.di.ViewModelKey
import com.example.adaptumapp.presentation.viewModels.EventsFragmentViewModel
import com.example.adaptumapp.presentation.viewModels.LoginFragmentViewModel
import com.example.adaptumapp.presentation.viewModels.ProfileFragmentViewModel
import com.example.adaptumapp.presentation.viewModels.TasksFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProfileFragmentViewModel::class)
    internal abstract fun bindProfileFragmentViewModel(viewModel: ProfileFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EventsFragmentViewModel::class)
    internal abstract fun bindEventsFragmentViewModel(viewModel: EventsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TasksFragmentViewModel::class)
    internal abstract fun bindTasksFragmentViewModel(viewModel: TasksFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginFragmentViewModel::class)
    internal abstract fun bindLoginFragmentViewModel(viewModel: LoginFragmentViewModel): ViewModel
}