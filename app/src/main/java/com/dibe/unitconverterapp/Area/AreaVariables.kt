package com.dibe.unitconverterapp.Area

object AreaVariables {
    val units: Map<String, String> = mapOf(
        "mi²" to  "Square mile",
        "ac" to "Acre",
        "yd²" to "Square yard",
        "dm²" to "Square decimeter",
        "m²" to "Square meter",
        "cm²" to "Square centimeter",
        "mm²" to "Square millimeter",
        "ft²" to "Square foot",
        "ha" to "Hectare",
        "μm²" to "Square micrometer",
        "in²" to "Square inch",
        "brn" to "Barn"
    )
    val conversionFactorsToStandard: Map<String, Double> = mapOf(
        "mi²" to  2.59E6,
        "ac" to 4046.85642,
        "yd²" to 0.83612736,
        "dm²" to 0.01,
        "m²" to 1.0,
        "cm²" to 0.0001,
        "mm²" to 0.000001,
        "ft²" to 0.09290304,
        "ha" to 10000.0,
        "μm²" to  1.0E-12,
        "in²" to 0.00064516,
        "brn" to 1E-28
    )

    val conversionFactorsFromStandard: Map<String, Double> = mapOf(
        "mi²" to  3.861E-07,
        "ac" to 0.00024711,
        "yd²" to 1.1959900463,
        "dm²" to 0.01,
        "m²" to 1.0,
        "cm²" to 10000.0,
        "mm²" to 1000000.0,
        "ft²" to 10.7639104167,
        "ha" to 0.0001,
        "μm²" to 1000000000000.0,
        "in²" to 1550.0,
        "brn" to 1E+28
    )
}