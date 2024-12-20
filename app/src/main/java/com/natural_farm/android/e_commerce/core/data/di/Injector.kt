package com.natural_farm.android.e_commerce.core.data.di

import com.natural_farm.android.e_commerce.core.data.domain.usecase.product.ProductInteractor
import com.natural_farm.android.e_commerce.core.data.domain.usecase.product.ProductUseCase
import com.natural_farm.android.e_commerce.core.data.domain.usecase.user.UserInteractor
import com.natural_farm.android.e_commerce.core.data.domain.usecase.user.UserUseCase
import com.natural_farm.android.e_commerce.core.data.repository.ProductRepository
import com.natural_farm.android.e_commerce.core.data.repository.UserRepository
import com.natural_farm.android.e_commerce.core.data.source.remote.ProductRemoteDataSource
import com.natural_farm.android.e_commerce.core.data.source.remote.UserRemoteDataSource
import com.natural_farm.android.e_commerce.core.data.source.remote.network.ApiService
import com.natural_farm.android.e_commerce.ui.ViewModelFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Injector {
    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .readTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build()
    }

    private fun provideApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

    private fun provideProductRemoteDataSource(): ProductRemoteDataSource {
        return ProductRemoteDataSource.getInstance(provideApiService())
    }

    private fun provideProductRepository(): ProductRepository {
        return ProductRepository.getInstance(provideProductRemoteDataSource())
    }

    private fun provideProductInteractor(): ProductUseCase {
        return ProductInteractor(provideProductRepository())
    }

    private fun provideUserRemoteDataSource(): UserRemoteDataSource {
        return UserRemoteDataSource.getInstance(provideApiService())
    }

    private fun provideUserRepository(): UserRepository {
        return UserRepository.getInstance(provideUserRemoteDataSource())
    }

    private fun provideUserInteractor(): UserUseCase {
        return UserInteractor(provideUserRepository())
    }

    fun provideViewModelFactory(): ViewModelFactory {
        return ViewModelFactory(provideProductInteractor(), provideUserInteractor())
    }


}