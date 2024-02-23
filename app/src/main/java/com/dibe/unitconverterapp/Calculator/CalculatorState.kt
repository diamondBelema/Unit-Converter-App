package com.dibe.unitconverterapp.Calculator

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf

data class CalculatorState(
        var displayText : MutableState<String> = mutableStateOf("") ,
        var displayTextFontSize : MutableIntState = mutableIntStateOf(70) ,
        var ansTextFontSize : MutableIntState = mutableIntStateOf(32) ,
        var isNormalCalculator: MutableState<Boolean> = mutableStateOf(true) ,
        var ansText : MutableState<String> = mutableStateOf("")
                         )
