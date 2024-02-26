package com.dibe.unitconverterapp.Calculator

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf

data class CalculatorState(
        var displayText : MutableState<String> = mutableStateOf(" ") ,
        var displayTextFontSize : MutableIntState = mutableIntStateOf(70) ,
        var ansTextFontSize : MutableIntState = mutableIntStateOf(32) ,
        var isNormalCalculator: MutableState<Boolean> = mutableStateOf(true) ,
        var ansText : MutableState<String> = mutableStateOf(""),
        var isDegree: MutableState<Boolean> = mutableStateOf(true) ,
        var angleString: MutableState<String> = mutableStateOf("deg"),
        var sinString: MutableState<String> = mutableStateOf("sin"),
        var cosString: MutableState<String> = mutableStateOf("cos"),
        var tanString: MutableState<String> = mutableStateOf("tan"),
        var lnString: MutableState<String> = mutableStateOf("ln"),
        var logString: MutableState<String> = mutableStateOf("log"),
                         )
