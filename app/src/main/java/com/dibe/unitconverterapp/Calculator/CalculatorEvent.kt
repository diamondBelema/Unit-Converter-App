package com.dibe.unitconverterapp.Calculator

sealed class CalculatorEvent {
    data class Number(val number: String) : CalculatorEvent()
    data class Operation(val operation: String) : CalculatorEvent()
    data class Special(val special: String) : CalculatorEvent()
    data object Delete : CalculatorEvent()
    data object Clear : CalculatorEvent()
    data object Bracket : CalculatorEvent()
    data object Inverse : CalculatorEvent()
    data object Calculate : CalculatorEvent()
    data object Navigate : CalculatorEvent()
}

