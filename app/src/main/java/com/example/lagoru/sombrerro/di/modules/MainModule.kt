package com.example.lagoru.sombrerro.di.modules

import android.content.Context
import com.example.lagoru.sombrerro.baseApplication
import com.example.lagoru.sombrerro.di.ForApplication
import com.example.lagoru.sombrerro.mvi.ViewStateCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by lagoru on 21.06.17.
 */
@Module
class MainModule {

    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context {
        return baseApplication!!
    }

    @Provides
    @Singleton
    fun provideViewStateCache(): ViewStateCache {
        return ViewStateCache()
    }
}