package com.dibe.unitconverterapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dibe.unitconverterapp.Area.AreaScreen
import com.dibe.unitconverterapp.Area.AreaViewModel
import com.dibe.unitconverterapp.Calculator.CalculatorScreen
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
    val lengthViewModel = viewModel<LengthViewModel>()
    val areaViewModel = viewModel<AreaViewModel>()
    val volumeViewModel = viewModel<VolumeViewModel>()
    val calculatorViewModel = viewModel<CalculatorViewModel>()
    val massViewModel = viewModel<MassViewModel>()
    val energyViewModel = viewModel<EnergyViewModel>()
    val powerViewModel = viewModel<PowerViewModel>()
    val timeViewModel = viewModel<TimeViewModel>()
    NavHost(navController =  navController, startDestination = "HomeScreen"){
        composable(route = "HomeScreen"){
            HomeScreen(navController)
        }

        composable(route = "LengthScreen"){
            LengthScreen(lengthViewModel , navController)
        }

        composable(route = "AreaScreen"){
            AreaScreen(areaViewModel , navController)
        }

        composable(route = "VolumeScreen"){
            VolumeScreen(volumeViewModel , navController)
        }

        composable(route = "CalculatorScreen"){
            CalculatorScreen(calculatorViewModel.state.collectAsState().value, calculatorViewModel::onEvent, navController)
        }

        composable(route = "MassScreen"){
            MassScreen(massViewModel, navController)
        }

        composable(route = "EnergyScreen"){
            EnergyScreen(energyViewModel, navController)
        }

        composable(route = "PowerScreen"){
            PowerScreen(powerViewModel , navController)
        }

        composable(route = "TimeScreen"){
            TimeScreen(timeViewModel , navController)
        }
    }
}
