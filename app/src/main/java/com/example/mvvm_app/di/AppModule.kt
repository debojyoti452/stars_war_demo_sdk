package com.example.mvvm_app.di

import android.content.Context
import com.example.lib.StarWars
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideInitiateStarWars(@ApplicationContext context: Context) : StarWars {
        return StarWars.Builder()
            .setContext(context)
            .create()
    }
}
