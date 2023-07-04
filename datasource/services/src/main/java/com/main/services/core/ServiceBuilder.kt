package com.main.services.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ServiceBuilder {

    fun buildService(baseUrl: String, service: Class<BaseService>): BaseService


    class Base : ServiceBuilder {
        override fun buildService(baseUrl: String, service: Class<BaseService>): BaseService {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(service)
        }
    }
}