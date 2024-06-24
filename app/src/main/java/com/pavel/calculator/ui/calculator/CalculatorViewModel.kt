package com.pavel.calculator.ui.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private var secondOperand: String = ""
    private var firstOperand: String = ""
    private var expression: String = ""
    private var isSecond: Boolean = false
    private var result: Double? = null
    private var operation: String = ""

    var expressionLiveData = MutableLiveData<String>()
    var resultLiveData = MutableLiveData<Double?>()

    fun inputSymbols(symbol: String) {
        if ((result != null) && (operation == "")) {
            clearValues()
        }
        if (symbol == ".") {
            pointIsPresent(symbol)
        } else {
            expression += symbol
        }
        expressionLiveData.postValue(expression)
        writeSecondOperand(symbol)
    }

    private fun writeSecondOperand(number: String) {
        if (isSecond) {
            if (number == ".") {
                pointIsPresent(number)
            } else {
                secondOperand += number
            }
        }
    }

    fun addOperation(sign: String) {
        addNextOperation()
        firstOperand = expression
        expression += sign
        expressionLiveData.postValue(expression)
        operation = sign
        isSecond = true
    }

    fun clearValues() {
        expression = ""
        firstOperand = ""
        secondOperand = ""
        operation = ""
        result = null
        resultLiveData.postValue(null)
        expressionLiveData.postValue(expression)
    }

    fun changeSign() {
        if (expression.contains('-')) {
            expression = expression.substring(1)
            if (firstOperand.isNotEmpty()) {
                firstOperand = firstOperand.substring(1)
            }
        } else {
            expression = "-$expression"
            if (firstOperand.isNotEmpty()) {
                firstOperand = "-$firstOperand"
            }
        }
        expressionLiveData.postValue(expression)
    }

    fun solveOperation() {
        if ((expression.isNotEmpty()) && (secondOperand.isNotEmpty()) && (firstOperand.isNotEmpty())) {
            when (operation) {
                "+" -> result = firstOperand.toDouble().plus(secondOperand.toDouble())
                "-" -> result = firstOperand.toDouble().minus(secondOperand.toDouble())
                "*" -> result = firstOperand.toDouble() * secondOperand.toDouble()
                "/" -> result = firstOperand.toDouble() / secondOperand.toDouble()
                "%" -> result = firstOperand.toDouble() % secondOperand.toDouble()
            }
            expression = result.toString()
            firstOperand = result.toString()
            secondOperand = ""
        } else {
            result = expression.toDouble()
        }
        resultLiveData.postValue(result)
        isSecond = false
        operation = ""
    }

    private fun pointIsPresent(point: String) {
        if (!expression.contains('.')) {
            expression += point
        }
        if ((secondOperand.isNotEmpty()) && (!secondOperand.contains('.'))) {
            expression += point
            secondOperand += point
        }
    }

    private fun addNextOperation() {
        if (isSecond) {
            solveOperation()
            resultLiveData.postValue(result)
            isSecond = false
        }
    }
}