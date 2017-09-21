package com.example.lagoru.sombrerro.di.modules

import com.example.data.TopicDataProviderImpl
import com.example.data.interfaces.TopicDataProvider
import dagger.Module
import dagger.Provides

@Module
class ProviderModule {

    @Provides
    fun provideTopicProvider(): TopicDataProvider {
        return TopicDataProviderImpl()
    }
}