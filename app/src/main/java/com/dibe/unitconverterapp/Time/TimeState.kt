package com.dibe.unitconverterapp.Time

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf

data class TimeState(
    var textOne: MutableState<String> = mutableStateOf("0"),
    var textTwo: MutableState<String> = mutableStateOf("0"),
    var unitOne: MutableState<String> = mutableStateOf("sec"),
    var isSheetOpen: MutableState<Boolean> = mutableStateOf(false),
    var unitTwo: MutableState<String> = mutableStateOf("sec"),
    var fontSizeOne: MutableState<Int> = mutableIntStateOf(32),
    var fontSizeTwo: MutableState<Int> = mutableIntStateOf(32),
                    )


