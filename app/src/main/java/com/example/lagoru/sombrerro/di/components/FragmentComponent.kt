package com.example.lagoru.sombrerro.di.components

import com.example.lagoru.sombrerro.di.modules.FragmentModule
import com.example.lagoru.sombrerro.di.PerFragment
import com.example.lagoru.sombrerro.di.modules.ProviderModule
import com.example.lagoru.sombrerro.view.MainFragment
import dagger.Component

/**
 * Created by lagoru on 04.07.17.
 */
@PerFragment
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(FragmentModule::class, ProviderModule::class))
interface FragmentComponent {
    fun inject(mainFragment: MainFragment)
}