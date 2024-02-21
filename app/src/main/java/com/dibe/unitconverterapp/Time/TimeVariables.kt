package com.dibe.unitconverterapp.Time

object TimeVariables {
    val units: Map<String, String> = mapOf(
        "fs" to "Femto Seconds",
        "ps" to "Pico Seconds",
        "ns" to "Nano Seconds",
        "μs" to "Micro Seconds",
        "ms" to "Milli Seconds",
        "sec" to "Seconds",
        "min" to  "Minutes",
        "hr" to "Hour",
        "dy" to "Day",
        "wk" to "Week",
        "fn" to "Fortnight",
        "m" to "Month",
        "yr" to "Year",
        "sy" to "Sidereal year",
        "d" to "Decade",
        "c" to "Century",
        "m" to "Millennium"
    )
    val conversionFactorsToKM: Map<String, Double> = mapOf(
        "fs" to 1.0000E-15,
        "ps" to 1.0000E-12,
        "ns" to 1.0000E-9,
        "μs" to 0.000001,
        "ms" to 0.001,
        "sec" to 1.0,
        "min" to  60.0,
        "hr" to 3600.0,
        "dy" to 86400.0,
        "wk" to 604800.0,
        "fn" to 1209600.0,
        "m" to 2628000.0,
        "yr" to 31536000.0,
        "sy" to 3.1558E+7,
        "d" to 315360000.0,
        "c" to 3.1536E+9,
        "m" to 3.1536E+10
    )

    val conversionFactorsFromKM: Map<String, Double> = mapOf(
        "fs" to 1E15,
        "ps" to 1E12,
        "ns" to 1E9,
        "μs" to 1000000.0,
        "ms" to 1000.0,
        "sec" to 1.0,
        "min" to  0.01666667,
        "hr" to 0.00027778,
        "dy" to 0.00001157,
        "wk" to 0.00000165,
        "fn" to 8.2672E-7,
        "m" to 3.8052E-7,
        "yr" to 3.1710E-8,
        "sy" to 3.1688E-8,
        "d" to 3.1710E-9,
        "c" to 3.1710E-10,
        "m" to 3.1710E-111
    )
}