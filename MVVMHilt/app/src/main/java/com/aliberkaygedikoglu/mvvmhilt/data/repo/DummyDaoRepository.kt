package com.aliberkaygedikoglu.mvvmhilt.data.repo

import androidx.lifecycle.MutableLiveData
import com.aliberkaygedikoglu.mvvmhilt.data.entity.Product
import com.aliberkaygedikoglu.mvvmhilt.retrofit.DummyDao
import retrofit2.Response
import javax.inject.Inject

class DummyDaoRepository @Inject constructor(private val dummyDao: DummyDao) {

    suspend fun dummyProduct(id:Int):Response<Product>{
        return dummyDao.getProduct(id)
    }

}