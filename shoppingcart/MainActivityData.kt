package com.example.shoppingcart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingcart.database.ItemList

class MainActivityData:ViewModel() {

    private val _data = MutableLiveData<List<ItemList>>()

    val data: LiveData<List<ItemList>> = _data

    fun setData(data:List<ItemList>){
        _data.value = data
    }
}