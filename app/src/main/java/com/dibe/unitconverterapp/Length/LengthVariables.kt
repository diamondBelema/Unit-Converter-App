package com.dibe.unitconverterapp.Length

object LengthVariables {
    val units: Map<String, String> = mapOf(
        "km" to  "Kilometer",
        "m" to "Meter",
        "dm" to "Decimeter",
        "cm" to "Centimeter",
        "mm" to "Millimeter",
        "μm" to "Micrometer",
        "nm" to "Nanometer",
        "pm" to "Picometer",
    )
    val conversionFactorsToKM: Map<String, Double> = mapOf(
        "km" to  1.0,
        "m" to 0.001,
        "dm" to 0.0001,
        "cm" to 0.00001,
        "mm" to 0.000001,
        "μm" to 0.000000001,
        "nm" to 0.000000000001,
        "pm" to 0.000000000000001
    )

    val conversionFactorsFromKM: Map<String, Long> = mapOf(
        "km" to  1,
        "m" to 1000,
        "dm" to 10000,
        "cm" to 100000,
        "mm" to 1000000,
        "μm" to 1000000000,
        "nm" to 1000000000000,
        "pm" to 1000000000000000
    )
}