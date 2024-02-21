package com.dibe.unitconverterapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dibe.learningcomposeapp.CalculatorScreen
import com.dibe.unitconverterapp.Area.AreaScreen
import com.dibe.unitconverterapp.Area.AreaViewModel
import com.dibe.unitconverterapp.Calculator.CalculatorViewModel
import com.dibe.unitconverterapp.Energy.EnergyScreen
import com.dibe.unitconverterapp.Energy.EnergyViewModel
import com.dibe.unitconverterapp.Home.HomeScreen
import com.dibe.unitconverterapp.Length.LengthScreen
import com.dibe.unitconverterapp.Length.LengthViewModel
import com.dibe.unitconverterapp.Mass.MassScreen
import com.dibe.unitconverterapp.Mass.MassViewModel
import com.dibe.unitconverterapp.Power.PowerScreen
import com.dibe.unitconverterapp.Power.PowerViewModel
import com.dibe.unitconverterapp.Time.TimeScreen
import com.dibe.unitconverterapp.Time.TimeViewModel
import com.dibe.unitconverterapp.Volume.VolumeScreen
import com.dibe.unitconverterapp.Volume.VolumeViewModel

@Composable
fun Nav(){
    val navController = rememberNavController()

    NavHost(navController =  navController, startDestination = "HomeScreen"){
        composable(route = "HomeScreen"){
            HomeScreen(navController)
        }

        composable(route = "LengthScreen"){
            LengthScreen(LengthViewModel() , navController)
        }

        composable(route = "AreaScreen"){
            AreaScreen(AreaViewModel() , navController)
        }

        composable(route = "VolumeScreen"){
            VolumeScreen(VolumeViewModel() , navController)
        }

        composable(route = "CalculatorScreen"){
            CalculatorScreen(CalculatorViewModel(), navController)
        }

        composable(route = "MassScreen"){
            MassScreen(MassViewModel(), navController)
        }

        composable(route = "EnergyScreen"){
            EnergyScreen(EnergyViewModel() , navController)
        }

        composable(route = "PowerScreen"){
            PowerScreen(PowerViewModel() , navController)
        }

        composable(route = "TimeScreen"){
            TimeScreen(TimeViewModel() , navController)
        }
    }
}