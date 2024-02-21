package com.dibe.unitconverterapp.Volume

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf

data class VolumeState(
    var textOne: MutableState<String> = mutableStateOf("0"),
    var textTwo: MutableState<String> = mutableStateOf("0"),
    var unitOne: MutableState<String> = mutableStateOf("l"),
    var isSheetOpen: MutableState<Boolean> = mutableStateOf(false),
    var unitTwo: MutableState<String> = mutableStateOf("l"),
    var fontSizeOne: MutableState<Int> = mutableIntStateOf(32),
    var fontSizeTwo: MutableState<Int> = mutableIntStateOf(32),
                      )


