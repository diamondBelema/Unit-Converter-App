package com.dibe.unitconverterapp.Calculator

import android.util.Log
import androidx.lifecycle.ViewModel


class CalculatorViewModel: ViewModel() {
    private val state = CalculatorState()

    val displayText = state.displayText
    val displayTextFontSize = state.displayTextFontSize
    val ansTextFontSize = state.ansTextFontSize
    val isNormalCalculator = state.isNormalCalculator
    var ansText = state.ansText

    private val sign: List<String> = listOf("+" , "÷" , "-" , "×")
    private var calculations: MutableMap<String, Double> = mutableMapOf()
    private var latest: String? = null
    private var current = "+1"
    private var isOperation  = false
    private var isDecimal = false
    private var decimalCount = 0
    private var noOfSigns = mutableMapOf(
        sign[0] to 1,
        sign[1] to 0,
        sign[2] to 0,
        sign[3] to 0
                                        )

    fun changeScreen(){
        state.isNormalCalculator.value = !state.isNormalCalculator.value
    }

    private fun updateDisplayTextFontSize() {
        if (state.displayText.value.length > 13) {
            state.displayTextFontSize.intValue = 40
        } else if (state.displayText.value.length > 9) {
            state.displayTextFontSize.intValue = 50
        } else if (state.displayText.value.length > 7) {
            state.displayTextFontSize.intValue = 60
        }else if (state.displayText.value.length < 8) {
            state.displayTextFontSize.intValue = 70
        }
    }

    private fun updateAnsTextFontSize() {
        if (state.ansText.value.length > 15) {
            state.ansTextFontSize.intValue = 23
        } else if (state.ansText.value.length > 11 && state.ansText.value.isNotEmpty()) {
            state.ansTextFontSize.intValue = 30
        } else if (state.ansText.value.isEmpty() || state.ansText.value == "0.0") {
            state.ansTextFontSize.intValue = 0
        } else if (state.ansText.value.length < 11 && state.ansText.value.isNotEmpty()) {
            state.ansTextFontSize.intValue = 32
        }
    }

    private fun calculate(): String {
        var ans = 0.0

        calculations.forEach { (sign, num) ->
            when {
                sign[0] == '+' -> ans += num
                sign[0] == '÷' -> ans /= num
                sign[0] == '-' -> ans -= num
                sign[0] == '×' -> ans *= num
            }
        }

        return ans.toString()
    }

    fun updateDisplayText(arg: String) {
        if (calculations.isEmpty() || state.displayText.value == "0"){
            state.displayText.value = ""
            calculations["+1"] = arg.toDouble()
        }else {
            if (!isDecimal){
                    calculations[current] = "${calculations[current]?.toInt()}$arg".toDouble()
            }else {
                if (decimalCount == 0) {
                    calculations[current] = "${calculations[current]?.toInt()}.$arg".toDouble()
                    decimalCount += 1
                }else {
                    calculations[current] = "${calculations[current]}$arg".toDouble()
                    decimalCount += 1
                }
            }
        }
        Log.i("myTag", calculations.toString())
        state.displayText.value = "${state.displayText.value}$arg"
        isOperation = false
        state.ansText.value = calculate()
        updateDisplayTextFontSize()
        updateAnsTextFontSize()
    }

    fun addOperator(operator: String) {
        if (state.displayText.value.isNotEmpty() && ! isOperation){
            when (operator) {
                "+" -> {
                    noOfSigns["+"] = "${noOfSigns["+"]?.plus(1)}".toInt()
                    current = "$operator${noOfSigns["+"]}"
                    calculations[current] = 0.0
                    Log.i("myTag", "you just clicked +")
                }

                "-" -> {
                    noOfSigns["-"] = "${noOfSigns["-"]?.plus(1)}".toInt()
                    current = "$operator${noOfSigns["-"]}"
                    calculations[current] = 0.0
                    Log.i("myTag", "you just clicked -")
                }

                "×" -> {
                    noOfSigns["×"] = "${noOfSigns["×"]?.plus(1)}".toInt()
                    current = "$operator${noOfSigns["×"]}"
                    calculations[current] = 0.0
                    Log.i("myTag", "you just clicked ×")
                }

                "÷" -> {
                    noOfSigns["÷"] = "${noOfSigns["÷"]?.plus(1)}".toInt()
                    current = "$operator${noOfSigns["÷"]}"
                    calculations[current] = 0.0
                    Log.i("myTag", "you just clicked ÷")
                }
                "%" -> {
                    Log.i("myTag", "you just clicked ÷")
                    calculations[current] = "${calculations[current]?.times(100)}".toDouble()
                    state.displayText.value = "${state.displayText.value}00"
                }
            }
            if (operator != "%") {
                state.displayText.value = "${state.displayText.value}$operator"
                isOperation = true
            }
            isDecimal = false
            decimalCount = 0
            updateDisplayTextFontSize()
        }
    }

    fun displayAns() {
        if (calculate().endsWith(".0")) {
            state.displayText.value = calculate().dropLast(2)
            isDecimal = false
            decimalCount = 0
        }else {
            state.displayText.value = calculate()
            isDecimal = true
            decimalCount = 1
        }
        calculations = mutableMapOf("+1" to calculate().toDouble())
        noOfSigns = mutableMapOf(
            sign[0] to 1,
            sign[1] to 0,
            sign[2] to 0,
            sign[3] to 0
                                )
        current = "+1"
        isOperation = false
        state.ansText.value = ""
        updateAnsTextFontSize()
        updateDisplayTextFontSize()
    }

    fun clear() {
        state.displayText.value = ""
        state.ansText.value = ""
        calculations.clear()
        noOfSigns = mutableMapOf(
            sign[0] to 1,
            sign[1] to 0,
            sign[2] to 0,
            sign[3] to 0
                                )
        current = "+1"
        isDecimal = false
        isOperation = false
        decimalCount = 0
        ansText.value = calculate()
        updateDisplayTextFontSize()
        updateAnsTextFontSize()
    }

    fun putPoint() {
        if (calculations.isNotEmpty() && ! isOperation && ! isDecimal && state.displayText.value.isNotEmpty()){
            isDecimal = true
            state.displayText.value = "${state.displayText.value}."
            updateDisplayTextFontSize()
        }
    }

    fun delete(){
        if (state.displayText.value.isNotEmpty()){
            if (sign.contains(state.displayText.value.last().toString())){
                state.displayText.value = state.displayText.value.dropLast(1)
                calculations.remove(current)
                current = calculations.keys.last()
            }else{
                if (calculations[current].toString().endsWith(".0")) {
                    Log.i("myTag", "deleting .0")
                    if (calculations[current].toString().dropLast(3) == "") calculations[current] = 0.0
                    else if (state.displayText.value.last() == '.') {
                        decimalCount = 0
                        isDecimal = false
                    }
                    else calculations[current] = calculations[current].toString().dropLast(3).toDouble()
                    state.displayText.value = state.displayText.value.dropLast(1)
                }else {
                    Log.i("myTag", "deleting")
                    calculations[current] = calculations[current].toString().dropLast(1).toDouble()
                    state.displayText.value = state.displayText.value.dropLast(1)
                }
            }
        }
        state.ansText.value = calculate()
        Log.i("myTag", calculations.toString())
        updateAnsTextFontSize()
        updateDisplayTextFontSize()
    }
}
