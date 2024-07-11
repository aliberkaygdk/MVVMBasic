package com.aliberkaygedikoglu.mvvmhilt.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliberkaygedikoglu.mvvmhilt.data.entity.Product
import com.aliberkaygedikoglu.mvvmhilt.data.repo.DummyDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val dummyDaoRepository: DummyDaoRepository) : ViewModel() {

    var product= MutableLiveData<Product>()

    fun getProduct(id: Int) {


        viewModelScope.launch {
            val response = dummyDaoRepository.dummyProduct(id)
            if (response.isSuccessful) {
                product.value = response.body()
            } else {
                Log.e("MyResponse", "Failed")
            }
        }
    }

}