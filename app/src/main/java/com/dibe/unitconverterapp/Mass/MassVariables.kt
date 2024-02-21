package com.dibe.unitconverterapp.Mass

object MassVariables {
    val units: Map<String, String> = mapOf(
        "mg" to  "Milligram",
        "g" to "Gram",
        "cg" to "Centigram",
        "dg" to "Deci-gram",
        "dag" to "Deca-gram",
        "hg" to "Hectogram",
        "kg" to "Kilogram",
        "st" to "Stone",
        "lb" to "Pound",
        "oz" to "Ounce"
                                          )
    val conversionFactorsToKM: Map<String, Double> = mapOf(
        "mg" to  0.001,
        "g" to 1.0,
        "cg" to 0.01,
        "dg" to 0.1,
        "dag" to 10.0,
        "hg" to 100.0,
        "kg" to 1000.0,
        "st" to 6350.29318,
        "lb" to 453.59237,
        "oz" to 28.3495231
                                                          )

    val conversionFactorsFromKM: Map<String, Double> = mapOf(
        "mg" to  1000.0,
        "g" to 1.0,
        "cg" to 100.0,
        "dg" to 10.0,
        "dag" to 0.1,
        "hg" to 0.01,
        "kg" to 0.001,
        "st" to 0.00015747,
        "lb" to 0.00220462,
        "oz" to 0.03527396
                                                          )
}