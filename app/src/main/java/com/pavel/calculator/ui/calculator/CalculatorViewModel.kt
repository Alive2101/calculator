package com.pavel.calculator.ui.calculator

import android.util.Log
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var string: String = ""

    fun write(number: String) {
        string += number
        Log.e("str", string)
    }

    fun delete() {
        //delete numbers
    }
}