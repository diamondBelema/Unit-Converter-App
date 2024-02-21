package com.dibe.unitconverterapp.Power

object PowerVariables {
    val units: Map<String, String> = mapOf(
        "erg/sec" to  "Energy/Sec",
        "BTU/hr" to "British thermal unit/ Hour",
        "ft-ib/s" to "foot-pound/ sec",
        "hp" to "Horsepower",
        "cal/s" to "calorie/ sec",
    )
    val conversionFactorsToStandard: Map<String, Double> = mapOf(
        "erg/sec" to  1E-5,
        "BTU/hr" to 0.2930,
        "ft-ib/s" to 1.356,
        "hp" to 745.7,
        "cal/s" to  4.186,
    )

    val conversionFactorsFromStandard: Map<String, Double> = mapOf(
        "erg/sec" to  10000000.0,
        "BTU/hr" to 3.41214,
        "ft-ib/s" to 128.802705,
        "hp" to 0.00134102,
        "cal/s" to  0.2388458966275,
    )
}