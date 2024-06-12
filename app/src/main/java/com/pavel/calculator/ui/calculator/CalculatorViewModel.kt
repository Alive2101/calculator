package com.pavel.calculator.ui.calculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private var newNumber: String = ""
    var oldNumber: String = ""
    var expression: String = ""
    var result: Double? = null

    fun write(number: String) {
        if (number == ".") {
            pointIsPresent(number)
        } else expression += number
    }

    fun writeNewNumber(number: String) {
        if (number == ".") {
            pointIsPresent(number)
        } else newNumber += number
    }


    fun delete() {
        expression = ""
        oldNumber = ""
        newNumber = ""
    }

    fun sign() {
        if (expression.contains('-')) {
            expression = expression.substring(1)
            if (oldNumber.isNotEmpty()) {
                oldNumber = oldNumber.substring(1)
            }
        } else {
            expression = "-$expression"
            if (oldNumber.isNotEmpty()) {
                oldNumber = "-$oldNumber"
            }
        }
    }

    fun operation(sign: String) {
        if ((expression.isNotEmpty()) && (newNumber.isNotEmpty()) && (oldNumber.isNotEmpty())) {
            signIsPresent()
            when (sign) {
                "+" -> result = oldNumber.toDouble().plus(newNumber.toDouble())
                "-" -> result = oldNumber.toDouble().minus(newNumber.toDouble())
                "*" -> result = oldNumber.toDouble() * newNumber.toDouble()
                "/" -> result = oldNumber.toDouble() / newNumber.toDouble()
                "%" -> result = oldNumber.toDouble() % newNumber.toDouble()
            }
            expression = result.toString()
            oldNumber = result.toString()
            newNumber = ""
        } else
            result = expression.toDouble()

    }

    private fun signIsPresent() {
        if ((oldNumber.last() == '+') || (oldNumber.last() == '-')
            || (oldNumber.last() == '*') || (oldNumber.last() == '/')
        ) {
            oldNumber = oldNumber.substring(0, oldNumber.length - 1)
        }
    }

    private fun pointIsPresent(number: String) {
        if (!expression.contains('.')) {
            expression += number
        }
        if ((newNumber.isNotEmpty()) && (!newNumber.contains('.'))) {
            expression += number
            newNumber += number
        }
    }
}