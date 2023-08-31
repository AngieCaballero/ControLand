package com.example.controlandandroid.di.module

import android.content.Context
import androidx.room.Room
import com.example.controlandandroid.data.database.ControLandDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "controLand_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ControLandDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideTaskDao(db: ControLandDatabase) = db.getTaskDao()

    @Singleton
    @Provides
    fun provideDocumentDao(db: ControLandDatabase) = db.getDocumentDao()


    @Singleton
    @Provides
    fun provideRawDao(db: ControLandDatabase) = db.getRawDao()

}