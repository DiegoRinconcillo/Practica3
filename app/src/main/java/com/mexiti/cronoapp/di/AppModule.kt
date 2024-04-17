package com.mexiti.cronoapp.di

import android.content.Context
import androidx.room.Room
import com.mexiti.cronoapp.room.ContactDataBase
import com.mexiti.cronoapp.room.ContactDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Singleton
    @Provides
    fun providesContactDao(contactDataBase: ContactDataBase):ContactDatabaseDao{
        return contactDataBase.contactDao()
    }

    @Singleton
    @Provides
    fun providesContactDatabase(@ApplicationContext context: Context):ContactDataBase{
        return Room.databaseBuilder(
            context= context,
            ContactDataBase::class.java,
            name = "contact_db"
        ).fallbackToDestructiveMigration()
            .build()
    }


}



