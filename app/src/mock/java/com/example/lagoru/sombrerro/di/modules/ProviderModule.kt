package com.example.lagoru.sombrerro.di.modules

import com.example.data.interfaces.TopicDataProvider
import com.example.lagoru.sombrerro.mocker.TopicMocker
import dagger.Module
import dagger.Provides

@Module
class ProviderModule {

    @Provides
    fun provideTopicProvider(): TopicDataProvider {
        return TopicMocker()
    }
}