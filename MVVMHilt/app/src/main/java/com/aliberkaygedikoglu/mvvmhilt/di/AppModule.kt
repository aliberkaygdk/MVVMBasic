package com.aliberkaygedikoglu.mvvmhilt.di

import com.aliberkaygedikoglu.mvvmhilt.retrofit.ApiClient
import com.aliberkaygedikoglu.mvvmhilt.retrofit.DummyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideProduct():DummyDao{
        return ApiClient.getClient().create(DummyDao::class.java)
    }


}