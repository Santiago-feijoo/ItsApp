package com.example.itsapp.di

import com.example.itsapp.persistence.ItsAppDb
import com.example.itsapp.persistence.daos.InfectionsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    /** Provide dao Infections **/
    @Singleton
    @Provides
    fun provideInfections(db: ItsAppDb): InfectionsDao {
        return db.infectionsDao()

    }

}