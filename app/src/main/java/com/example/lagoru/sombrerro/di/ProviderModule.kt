package com.example.lagoru.sombrerro.di

import com.example.data.TopicDataProvider
import com.example.lagoru.sombrerro.mocker.TopicMocker
import com.example.lagoru.sombrerro.utils.BasicUtils
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by lagoru on 10.07.17.
 */
@Module
class ProviderModule {
    @Provides
    @Reusable
    fun provideMockEnabledBool(): Boolean {
        return BasicUtils.isMockEnabled
    }

    @Provides
    fun provideTopicProvider(shouldMock: Boolean): TopicDataProvider {
        return TopicDataProvider(if (shouldMock) TopicMocker() else null)
    }
}