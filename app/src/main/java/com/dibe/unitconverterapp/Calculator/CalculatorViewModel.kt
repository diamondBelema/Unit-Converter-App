package com.dibe.unitconverterapp.Calculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    private val state = CalculatorState()

    val reviewText = state.reviewText
    val size = state.fontSize

    private val sign: List<String> = listOf("+" , "÷" , "-" , "×")

    private fun updateFontSize() {
        if ((state.firstNumber.value + state.firstNumberDecimal.value).toString().length > 13) {
            state.fontSize.intValue = 50
        } else if ((state.firstNumber.value + state.firstNumberDecimal.value).toString().length > 11) {
            state.fontSize.intValue = 60
        }else if ((state.firstNumber.value + state.firstNumberDecimal.value).toString().length < 12) {
            state.fontSize.intValue = 70
        }
    }

    private fun calc() {
        val timesShortcut: Double = if (state.firstNumberDecimal.value != 0.0 && state.secondNumberDecimal.value != 0.0) {
            (state.firstNumber.value + state.firstNumberDecimal.value) * (state.secondNumber.value + state.secondNumberDecimal.value)
        }else {
            (state.firstNumber.value * state.secondNumber.value).toDouble()
        }

        val divideShortcut: Double = if (state.firstNumberDecimal.value != 0.0 && state.secondNumberDecimal.value != 0.0) {
            (state.firstNumber.value + state.firstNumberDecimal.value) / (state.secondNumber.value + state.secondNumberDecimal.value)
        }else {
            (state.firstNumber.value / state.secondNumber.value).toDouble()
        }

        when (state.operator.value) {
            "+" -> state.firstNumber.value += state.secondNumber.value
            "÷" -> state.firstNumber.value = divideShortcut.toString().slice(0 until divideShortcut.toString().indexOf('.')).toLong()
            "-" -> state.firstNumber.value -= state.secondNumber.value
            "×" -> state.firstNumber.value  = timesShortcut.toString().slice(0 until timesShortcut.toString().indexOf('.')).toLong()
        }
        when (state.operator.value) {
            "+" -> state.firstNumberDecimal.value += state.secondNumberDecimal.value
            "÷" -> state.firstNumberDecimal.value = "0${divideShortcut.toString().slice(divideShortcut.toString().indexOf('.') until timesShortcut.toString().length)}".toDouble()
            "-" -> state.firstNumberDecimal.value -= state.secondNumberDecimal.value
            "×" -> state.firstNumberDecimal.value = "0${timesShortcut.toString().slice(timesShortcut.toString().indexOf('.') until timesShortcut.toString().length)}".toDouble()
        }

    }

    fun updateReviewText(arg: String) {
        if ((state.firstNumber.value + state.firstNumberDecimal.value).toString().length < 21) {
            if (state.isOperation.value) {
                if (! state.isDecimal.value) state.secondNumber.value =
                    "${state.secondNumber.value}$arg".toLong()
                else if (state.isDecimal.value) {
                    if (state.decimalCount.value != 0) state.secondNumberDecimal.value =
                        "${state.secondNumberDecimal.value}$arg".toDouble()
                    else state.secondNumberDecimal.value = "0.$arg".toDouble()
                    state.decimalCount.value ++
                }
            } else if (! state.isOperation.value) {
                if (! state.isDecimal.value) state.firstNumber.value =
                    "${state.firstNumber.value}$arg".toLong()
                else if (state.isDecimal.value) {
                    if (state.decimalCount.value != 0) state.firstNumberDecimal.value =
                        "${state.firstNumberDecimal.value}$arg".toDouble()
                    else state.firstNumberDecimal.value = "0.$arg".toDouble()
                    state.decimalCount.value ++
                }
            }
            state.reviewText.value = "${state.reviewText.value}$arg"
            updateFontSize()
        }
    }

    fun addOperator(arg: String) {
        if ((state.firstNumber.value + state.firstNumberDecimal.value).toString().length < 20) {
            if (!sign.contains(state.reviewText.value.last().toString()) && (state.firstNumber.value.toString() != "0" || state.firstNumberDecimal.value.toString() != "0.0")
            ) {
                calc()
                state.operator.value = arg
                state.isOperation.value = true
                state.reviewText.value = "${state.reviewText.value}$arg"
                state.isDecimal.value = false
                state.decimalCount.value = 0
                state.secondNumber.value = 0
                state.secondNumberDecimal.value = 0.0
            }
            updateFontSize()
        }
    }

    fun displayAns() {
        calc()
        if (state.firstNumberDecimal.value == 0.0) state.reviewText.value = "${state.firstNumber.value}"
        else if (state.firstNumberDecimal.value != 0.0) state.reviewText.value = "${state.firstNumber.value + state.firstNumberDecimal.value}"
        updateFontSize()

        state.operator.value = " "
        state.secondNumber.value = 0
        state.secondNumberDecimal.value = 0.0
        state.isOperation.value = false
    }

    fun clear() {
        state.reviewText.value = " "
        state.secondNumber.value = 0
        state.firstNumber.value = 0
        state.firstNumberDecimal.value = 0.0
        state.secondNumberDecimal.value = 0.0
        state.isOperation.value = false
        state.operator.value = ""
        state.decimalCount.value = 0
        state.isDecimal.value = false
        updateFontSize()
    }

    fun putPoint() {
        if ((state.firstNumber.value + state.firstNumberDecimal.value).toString().length < 21) {
            state.isDecimal.value = true
            state.reviewText.value = "${state.reviewText.value}."
            updateFontSize()
        }
    }

    fun delete(){

    }

}