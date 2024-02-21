package com.dibe.unitconverterapp.Calculator

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf

data class CalculatorState(
        var firstNumber: MutableState<Long> = mutableLongStateOf(0)  ,
        var firstNumberDecimal:  MutableState<Double> = mutableDoubleStateOf(0.0) ,
        var operator: MutableState<String> = mutableStateOf("") ,
        var secondNumber: MutableState<Long> = mutableLongStateOf(0) ,
        var secondNumberDecimal: MutableState<Double> = mutableDoubleStateOf(0.0) ,
        var isOperation: MutableState<Boolean> = mutableStateOf(false) ,
        var isDecimal: MutableState<Boolean> = mutableStateOf(false) ,
        var decimalCount: MutableState<Int> = mutableIntStateOf(0) ,
        var reviewText : MutableState<String> = mutableStateOf(" ") ,
        var fontSize : MutableIntState = mutableIntStateOf(70)
                         )
