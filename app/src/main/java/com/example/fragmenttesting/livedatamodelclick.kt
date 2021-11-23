package com.example.fragmenttesting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class livedatamodelclick : ViewModel() {

    var num = 0

    val currentnum : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    fun inc(){
        currentnum.value = ++num
    }
}