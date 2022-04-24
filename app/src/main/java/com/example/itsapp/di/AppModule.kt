package com.example.itsapp.di

import android.content.Context
import androidx.room.Room
import com.example.itsapp.persistence.ItsAppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    /** Database **/
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): ItsAppDb {
        return Room.databaseBuilder(context, ItsAppDb::class.java, "ItsAppDb").build()

    }

}