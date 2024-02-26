package com.dibe.unitconverterapp.Calculator

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.math.*


class CalculatorViewModel: ViewModel() {
    private val state = CalculatorState()

    val displayText = state.displayText
    val displayTextFontSize = state.displayTextFontSize
    val ansTextFontSize = state.ansTextFontSize
    val isNormalCalculator = state.isNormalCalculator
    var ansText = state.ansText
    var angleString = state.angleString
    var sinString = state.sinString
    var cosString = state.cosString
    var tanString = state.tanString
    var lnString = state.lnString
    var logString = state.logString

    private val operations: List<Char> = listOf('+' , '÷' , '-' , '×', '√')
    private val `sci-fi`: List<Char> = listOf('c' , 's' , 't' , 'L' , 'l' , 'e' , '√' , '!', 'p', 'u', 'v', 'w', 'r')
    private var calculations: MutableMap<String, Double> = mutableMapOf("+1" to 0.0)
    private var current = "+1"
    private var isOperation  = false
    private var isDecimal = false
    private var decimalCount = 0
    private var noOfSigns = mutableMapOf(
        operations[0] to 1 ,
        operations[1] to 0 ,
        operations[2] to 0 ,
        operations[3] to 0
                                        )

    fun changeScreen(){
        state.isNormalCalculator.value = !state.isNormalCalculator.value
    }

    fun inv(){
        if (state.sinString.value == "sin") state.sinString.value = "sin⁻¹"
        else state.sinString.value = "sin"
        if (state.cosString.value == "cos") state.cosString.value = "cos⁻¹"
        else state.cosString.value = "cos"
        if (state.tanString.value == "tan") state.tanString.value = "tan⁻¹"
        else state.tanString.value = "tan"
        if (state.lnString.value == "ln") state.lnString.value = "eʸ"
        else state.lnString.value = "ln"
        if (state.logString.value == "log") state.logString.value = "10ʸ"
        else state.logString.value = "log"
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

        fun calc(operation : Char , num : Double){
            when (operation){
                '+' -> ans += num
                '÷' -> ans /= num
                '-' -> ans -= num
                '×' -> ans *= num
            }
        }
        calculations.forEach { (sign, num) ->
            if (`sci-fi`.contains(sign[0])){
                val rad = if (state.isDegree.value) num*(PI/180) else num

                Log.i("myTag", "$num to radians is $rad")
                when (sign[0]){
                    's' -> calc(sign[1], sin(rad))
                    'c' -> calc(sign[1] , cos(rad))
                    't' -> calc(sign[1] , tan(rad))
                    'u' -> calc(sign[1], asin(rad))
                    'v' -> calc(sign[1] , acos(rad))
                    'w' -> calc(sign[1] , atan(rad))
                    'L' -> calc(sign[1] , log10(num))
                    'l' -> calc(sign[1] , ln(num))
                    '√' -> calc(sign[1] , sqrt(num))
                    '!' -> calc(sign[1], num)
                    'r' -> calc(sign[1], num)

                }
            }else{calc(sign[0], num)}

        }

        return ans.toString()
    }

    fun updateDisplayText(arg: String) {
        if (calculations.isNotEmpty() && state.displayText.value != "0"){
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
            try {
                if (state.displayText.value.last() != '!') {
                    Log.i("myTag", calculations.toString())
                    state.displayText.value = "${state.displayText.value}$arg"
                    isOperation = false
                    state.ansText.value = calculate()
                    updateDisplayTextFontSize()
                    updateAnsTextFontSize()
                }
            }catch (e: Exception){
                Log.i("myTag", calculations.toString())
                state.displayText.value = "${state.displayText.value}$arg"
                isOperation = false
                state.ansText.value = calculate()
                updateDisplayTextFontSize()
                updateAnsTextFontSize()
            }
        }
    }

    fun changeAngle(){
        state.isDegree.value = !state.isDegree.value
        state.angleString.value = if (state.isDegree.value) "deg" else "rad"
    }

    fun addOperator(operator: String) {
        if (state.displayText.value.isNotEmpty() && ! isOperation){
            when (operator) {
                "+" -> {
                    noOfSigns['+'] = "${noOfSigns['+']?.plus(1)}".toInt()
                    current = "$operator${noOfSigns['+']}"
                    calculations[current] = 0.0
                    Log.i("myTag", "you just clicked +")
                }

                "-" -> {
                    noOfSigns['-'] = "${noOfSigns['-']?.plus(1)}".toInt()
                    current = "$operator${noOfSigns['-']}"
                    calculations[current] = 0.0
                    Log.i("myTag", "you just clicked -")
                }

                "×" -> {
                    noOfSigns['×'] = "${noOfSigns['×']?.plus(1)}".toInt()
                    current = "$operator${noOfSigns['×']}"
                    calculations[current] = 0.0
                    Log.i("myTag", "you just clicked ×")
                }

                "÷" -> {
                    noOfSigns['÷'] = "${noOfSigns['÷']?.plus(1)}".toInt()
                    current = "$operator${noOfSigns['÷']}"
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

    fun `addSci-fi`(char : String){
        val valueOfLast = calculations[current] !!
        val signOfLast = calculations.keys.last()[0]
        val countOfLast = calculations.keys.last().slice(1..<calculations.keys.last().length)
        val latestCurrent = "$char$signOfLast$countOfLast"
        if (char == "p") {
            if (calculations[current] == 0.0) calculations[current] = 1.0
            calculations[current] = calculations[current] !! * PI
        }else if (state.displayText.value.isEmpty()){
            current = "$char+1"
            calculations[current] = 0.0
        } else if (char == "!"){
            val num = calculations[current]
            var factorial: Long = 1
            if (num != null) {
                for (i in 1..num.toInt()) {
                    factorial *= i.toLong()
                }
            }
            calculations[current] = factorial.toDouble()
            state.ansText.value = calculate()
        }else if (operations.contains(state.displayText.value.last()) && ! `sci-fi`.contains(calculations.keys.last()[0]) && char != "!" && char != "p") {
            if (calculations.isNotEmpty()) calculations.remove(current)
            when (char) {
                "s" -> calculations[latestCurrent] = sin(valueOfLast)
                "c" -> calculations[latestCurrent] = cos(valueOfLast)
                "L" -> calculations[latestCurrent] = log10(valueOfLast)
                "l" -> calculations[latestCurrent] = ln(valueOfLast)
                "u" -> calculations[latestCurrent] = asin(valueOfLast)
                "v" -> calculations[latestCurrent] = acos(valueOfLast)
                "w" -> calculations[latestCurrent] = atan(valueOfLast)
                "r" -> calculations["$char${signOfLast}1$countOfLast"] = atan(valueOfLast)
                "t" -> calculations[latestCurrent] = tan(valueOfLast)
                "√" -> calculations[latestCurrent] = sqrt(valueOfLast)
            }
            current = latestCurrent
        }else if (! operations.contains(state.displayText.value.last()) && state.displayText.value.last() != ' '){
            noOfSigns['×'] = "${noOfSigns['×']?.plus(1)}".toInt()
            current = "$char×${noOfSigns['×']}"
            calculations[current] = 0.0
        }

        when (char) {
            "s" -> state.displayText.value = "${state.displayText.value}sin"
            "c" -> state.displayText.value = "${state.displayText.value}cos"
            "l" -> state.displayText.value = "${state.displayText.value}ln"
            "L" -> state.displayText.value = "${state.displayText.value}log"
            "t" -> state.displayText.value = "${state.displayText.value}tan"
            "√" -> state.displayText.value = "${state.displayText.value}√"
            "!" -> state.displayText.value = "${state.displayText.value}!"
            "u" -> state.displayText.value = "${state.displayText.value}sin⁻¹"
            "v" -> state.displayText.value = "${state.displayText.value}cos⁻¹"
            "w" -> state.displayText.value = "${state.displayText.value}tan⁻¹"
            "r" -> state.displayText.value = "${state.displayText.value}^"
            "p" -> state.displayText.value = "${state.displayText.value}\uD835\uDED1"
        }

        Log.i("myTag", calculations.toString())
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
            operations[0] to 1 ,
            operations[1] to 0 ,
            operations[2] to 0 ,
            operations[3] to 0
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
        calculations = mutableMapOf("+1" to 0.0)
        noOfSigns = mutableMapOf(
            operations[0] to 1 ,
            operations[1] to 0 ,
            operations[2] to 0 ,
            operations[3] to 0
                                )
        current = "+1"
        isDecimal = false
        isOperation = false
        decimalCount = 0
        ansText.value = calculate()
        updateDisplayTextFontSize()
        updateAnsTextFontSize()
        Log.i("myTag", calculations.toString())
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
            if (operations.contains(state.displayText.value.last().toChar())){
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
