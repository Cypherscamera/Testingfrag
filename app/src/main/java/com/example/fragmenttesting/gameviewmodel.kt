package com.example.fragmenttesting

import androidx.lifecycle.ViewModel


class gameviewmodel : ViewModel() {

    val allwordlist : List<String> = listOf("sad", "mad", "fart", "fat", "bald", "poop")
    var count = 0
    lateinit var currentword : String
    lateinit var scramword : String

    fun getscramword() : String{

        currentword = allwordlist.random()
        val tempword = currentword.toCharArray()
        tempword.shuffle()
        scramword = String(tempword)
        return scramword
    }

    fun restart(){
        count = 0
        getscramword()

    }

    }
