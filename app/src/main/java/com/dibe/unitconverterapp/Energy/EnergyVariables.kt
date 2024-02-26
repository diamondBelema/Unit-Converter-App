package com.dibe.unitconverterapp.Energy

object EnergyVariables {
    val units: Map<String, String> = mapOf(
        "J" to "Joule",
        "BTU" to  "British thermal unit",
        "erg" to "erg",
        "ft-ib" to "foot-pound",
        "cal" to "Calorie",
        "kwh" to "kilowatt-hour",
        "eV" to "Electron volt",
        "L-atm" to "Liter atmosphere",
    )
    val conversionFactorsToKM: Map<String, Double> = mapOf(
        "J" to 1.0,
        "BTU" to 1055.0,
        "erg" to 1E-7,
        "ft-ib" to 1.356,
        "cal" to 4.186,
        "kwh" to 3.6E6,
        "eV" to 1.602E-19,
        "L-atm" to 101.13,
    )

    val conversionFactorsFromKM: Map<String, Double> = mapOf(
        "J" to 1.0,
        "BTU" to 1/1055.0,
        "erg" to 1/1E-7,
        "ft-ib" to 1/1.356,
        "cal" to 1/4.186,
        "kwh" to 1/3.6E6,
        "eV" to 1/1.602E-19,
        "L-atm" to 1/101.13,
    )
}