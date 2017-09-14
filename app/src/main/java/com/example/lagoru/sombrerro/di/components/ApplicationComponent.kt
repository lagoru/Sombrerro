package com.example.lagoru.sombrerro.di.components

import com.example.lagoru.sombrerro.BaseApplication
import com.example.lagoru.sombrerro.MainActivity
import com.example.lagoru.sombrerro.di.modules.MainModule
import com.example.lagoru.sombrerro.mvi.ViewStateCache
import dagger.Component
import javax.inject.Singleton

/**
 * Created by lagoru on 21.06.17.
 */
@Singleton
@Component(modules = arrayOf(MainModule::class))
interface ApplicationComponent {
    fun exposeViewStateCache(): ViewStateCache

    fun inject(application: BaseApplication)

    fun inject(mainActivity: MainActivity)
}