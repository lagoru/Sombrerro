package com.example.lagoru.sombrerro.di

import com.example.lagoru.sombrerro.view.MainFragment
import dagger.Component

/**
 * Created by lagoru on 04.07.17.
 */
@PerFragment
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(mainFragment: MainFragment)
}