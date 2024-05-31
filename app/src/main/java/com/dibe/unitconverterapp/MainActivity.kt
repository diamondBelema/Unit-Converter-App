package com.dibe.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dibe.unitconverterapp.ui.theme.UnitConverterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UnitConverterAppTheme {
                Nav()
            }
        }
    }
}
