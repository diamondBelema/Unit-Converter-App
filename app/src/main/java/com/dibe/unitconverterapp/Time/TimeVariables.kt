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
    val conversionFactorsToSeconds: Map<String, Double> = mapOf(
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

    val conversionFactorsFromSeconds: Map<String, Double> = mapOf(
        "fs" to 1E15,
        "ps" to 1E12,
        "ns" to 1E9,
        "μs" to 1000000.0,
        "ms" to 1000.0,
        "sec" to 1.0,
        "min" to  1/60.0,
        "hr" to 1/3600.0,
        "dy" to 1/86400.0,
        "wk" to 1/604800.0,
        "fn" to 1/1209600.0,
        "m" to 1/2628000.0,
        "yr" to 1/31536000.0,
        "sy" to 1/3.1558E+7,
        "d" to 1/315360000.0,
        "c" to 1/3.1536E+9,
        "m" to 1/3.1536E+10
                                                                 )
}