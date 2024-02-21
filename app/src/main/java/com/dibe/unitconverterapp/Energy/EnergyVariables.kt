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
        "J" to 1.0 ,
        "BTU" to 0.00094781707774915 ,
        "erg" to 10000000.0 ,
        "ft-ib" to 1.3558179483314003 ,
        "cal" to 0.23900574 ,
        "kwh" to 0.000000278 ,
        "eV" to 6.2415E+18 ,
        "L-atm" to 0.0098692326671601 ,
    )
}