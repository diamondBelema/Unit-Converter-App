package com.dibe.unitconverterapp.Time

import androidx.lifecycle.ViewModel

class TimeViewModel : ViewModel() {
    private val state = TimeState()

    var textOne = state.textOne
    var textTwo = state.textTwo
    var unitOne = state.unitOne
    var unitTwo = state.unitTwo
    var isSheetOpen = state.isSheetOpen
    var fontSizeOne = state.fontSizeOne
    var fontSizeTwo = state.fontSizeTwo
    private var caller = ""
    private var isDecimal = false

    private fun updateTextTwo() {
        val medium = state.textOne.value.toDoubleOrNull()
            ?.times(TimeVariables.conversionFactorsToKM[state.unitOne.value] !!)
        if (medium != null) {
            state.textTwo.value =
                (medium * TimeVariables.conversionFactorsFromKM[state.unitTwo.value] !!).toString()
            if (!isDecimal) {
                if (state.textTwo.value.endsWith(".0")) state.textTwo.value = state.textTwo.value.replace(".0", "")
            }
        } else state.textTwo.value = "0"
    }

    private fun changeFontSizeOne() {
        if (state.textOne.value.length > 15) {
            state.fontSizeOne.value = 23
        } else if (state.textOne.value.length > 11) {
            state.fontSizeOne.value = 30
        }
    }

    private fun changeFontSizeTwo() {
        if (state.textTwo.value.length > 15) {
            state.fontSizeTwo.value = 23
        } else if (state.textTwo.value.length > 11) {
            state.fontSizeTwo.value = 30
        }
    }

    fun changeTextOne(value : String) {
        if (state.textOne.value.length <= 17) {
            if (state.textOne.value == "0") state.textOne.value = ""
            state.textOne.value = "${state.textOne.value}$value"
            updateTextTwo()
            changeFontSizeOne()
            changeFontSizeTwo()
        }
    }

    fun openBottomSheet(callerVal : String) {
        caller = callerVal
        state.isSheetOpen.value = true
    }

    fun changeUnit(unit : String) {
        if (caller == "unitOne") state.unitOne.value = unit
        else if (caller == "unitTwo") state.unitTwo.value = unit
        updateTextTwo()
        changeFontSizeTwo()
    }

    fun delete() {
        if (state.textOne.value.isNotEmpty()) {
            state.textOne.value = state.textOne.value.dropLast(1)
            updateTextTwo()
        }
        if (state.textOne.value.isEmpty()) {
            state.textOne.value = "0"
            updateTextTwo()
        }
        if (!state.textOne.value.contains(".")){
            isDecimal = false
        }
        changeFontSizeOne()
        changeFontSizeTwo()
    }

    fun clearAll() {
        state.fontSizeOne.value = 32
        state.fontSizeTwo.value = 32
        state.textOne.value = "0"
        state.textTwo.value = "0"
        isDecimal = false
    }

    fun addDot() {
        if (! state.textOne.value.contains(".")) state.textOne.value = "${state.textOne.value}."
        isDecimal = true
    }
}

