package com.dibe.unitconverterapp.Area

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf

data class AreaState(
    var textOne: MutableState<String> = mutableStateOf("0"),
    var textTwo: MutableState<String> = mutableStateOf("0"),
    var unitOne: MutableState<String> = mutableStateOf("m²"),
    var isSheetOpen: MutableState<Boolean> = mutableStateOf(false),
    var unitTwo: MutableState<String> = mutableStateOf("m²"),
    var fontSizeOne: MutableState<Int> = mutableIntStateOf(32),
    var fontSizeTwo: MutableState<Int> = mutableIntStateOf(32),
                      )


