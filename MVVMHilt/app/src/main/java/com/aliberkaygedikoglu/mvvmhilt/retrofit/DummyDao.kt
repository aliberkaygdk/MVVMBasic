package com.aliberkaygedikoglu.mvvmhilt.retrofit

import com.aliberkaygedikoglu.mvvmhilt.data.entity.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DummyDao {

    @GET("products/{id}")
    suspend fun getProduct(@Path("id")id:Int) : Response<Product>
}