package com.dibe.unitconverterapp.Calculator

data class CalculatorState(
        val input: String = "",
        val solvingString: String = "",
        val result: String = "",
        var bracketOpen: Boolean = false,
        var isInverse: Boolean = false,
        var isNormalMode: Boolean = true,
        var track: MutableList<String> = mutableListOf()
                          )
