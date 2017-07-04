package com.example.lagoru.sombrerro.di

import com.example.lagoru.sombrerro.view.MainFragmentPresenter
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by lagoru on 04.07.17.
 */
@Module
class FragmentModule {
    @Provides
    @Reusable
    fun provideViewStateCache(): MainFragmentPresenter {
        return MainFragmentPresenter()
    }
}