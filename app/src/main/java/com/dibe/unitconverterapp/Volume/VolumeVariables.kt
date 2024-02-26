package com.dibe.unitconverterapp.Volume

object VolumeVariables {
    val units: Map<String, String> = mapOf(
        "kl" to "Kiloliter",
        "l" to  "Liter",
        "ml" to "Milliliter",
        "dl" to "Deciliter",
        "cl" to "Centiliter",
        "hl" to "hectoliters",
        "dal" to "Deca liter",
        "in³" to "Cubic Inch",
        "ft³" to "Cubic foot",
        "gal" to "Gallon",
    )
    val conversionFactorsToStandard: Map<String, Double> = mapOf(
        "kl" to 1000.0,
        "l" to  1.0,
        "ml" to 0.001,
        "dl" to 0.1,
        "cl" to 0.01,
        "hl" to 100.0,
        "dal" to 10.0,
        "in³" to 0.01638706,
        "ft³" to 28.3168466,
        "gal" to 4.546092,
    )

    val conversionFactorsFromStandard : Map<String, Double> = mutableMapOf(
        "kl" to 0.001,
        "l" to  1.0,
        "ml" to 1000.0,
        "dl" to 10.0,
        "cl" to 100.0,
        "hl" to 0.01,
        "dal" to 0.1,
        "in³" to 1/0.01638706,
        "ft³" to 1/28.3168466,
        "gal" to 1/4.546092,
    )
}