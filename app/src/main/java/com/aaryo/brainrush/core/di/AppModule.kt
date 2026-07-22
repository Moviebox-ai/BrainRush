package com.aaryo.brainrush.core.di

import android.content.Context
import androidx.room.Room
import com.aaryo.brainrush.data.local.room.database.BrainRushDatabase
import com.aaryo.brainrush.data.repository.OfflineFirstGameRepository
import com.aaryo.brainrush.domain.repository.GameRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module @InstallIn(SingletonComponent::class) object DatabaseModule {
    @Provides @Singleton fun database(@ApplicationContext context: Context) = Room.databaseBuilder(context, BrainRushDatabase::class.java, "brainrush.db").build()
    @Provides fun dao(db: BrainRushDatabase) = db.dao()
}
@Module @InstallIn(SingletonComponent::class) abstract class RepositoryModule { @Binds abstract fun bindGameRepository(impl: OfflineFirstGameRepository): GameRepository }
