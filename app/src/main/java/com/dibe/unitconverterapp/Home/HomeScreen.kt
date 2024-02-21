package com.dibe.unitconverterapp.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.NavigateNext
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dibe.unitconverterapp.R
import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController : NavController) {
    Scaffold(
        topBar = {
            Row (
                modifier = Modifier.height(70.dp)
                ){
                TopAppBar(title = {
                    Text(
                        text = "Dibe Calculator" ,
                        fontSize = 20.sp ,
                        fontFamily = FontFamily.SansSerif
                        )
                })
            }
        } ,

        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("CalculatorScreen") }) {
                Icon(painterResource(id = R.drawable.calc) , contentDescription = "calc")
            }
        },
            ) {padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceEvenly
              )  {
                ListItem(
                    headlineContent = { Text("Length") } ,
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.NavigateNext ,
                            contentDescription = null
                            )
                    } ,
                    leadingContent = {
                        Icon(
                            painterResource(id = R.drawable.height) ,
                            contentDescription = null ,
                            tint = MaterialTheme.colorScheme.primary
                            )
                    } ,
                    modifier = Modifier.clickable { navController.navigate("LengthScreen") }
                        .padding(5.dp)
                        )
                ListItem(
                    headlineContent = { Text("Area") } ,
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.NavigateNext ,
                            contentDescription = null
                            )
                    } ,
                    leadingContent = {
                        Icon(
                            painterResource(id = R.drawable.wide) ,
                            contentDescription = null ,
                            tint = MaterialTheme.colorScheme.primary
                            )
                    } ,
                    modifier = Modifier.clickable { navController.navigate("AreaScreen") }
                        .padding(5.dp)
                        )
                ListItem(
                    headlineContent = { Text("Volume") } ,
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.NavigateNext ,
                            contentDescription = null
                            )
                    } ,
                    leadingContent = {
                        Icon(
                            painterResource(id = R.drawable.bottle) ,
                            contentDescription = null ,
                            tint = MaterialTheme.colorScheme.primary
                            )
                    } ,
                    modifier = Modifier.clickable { navController.navigate("VolumeScreen") }
                        .padding(5.dp)
                        )
                ListItem(
                    headlineContent = { Text("Mass") } ,
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.NavigateNext ,
                            contentDescription = null
                            )
                    } ,
                    leadingContent = {
                        Icon(
                            painterResource(id = R.drawable.load) ,
                            contentDescription = null ,
                            tint = MaterialTheme.colorScheme.primary
                            )
                    } ,
                    modifier = Modifier.clickable { navController.navigate("MassScreen") }
                        .padding(5.dp)
                        )
                ListItem(
                    headlineContent = { Text("Energy") } ,
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.NavigateNext ,
                            contentDescription = null
                            )
                    } ,
                    leadingContent = {
                        Icon(
                            painterResource(id = R.drawable.flash) ,
                            contentDescription = null ,
                            tint = MaterialTheme.colorScheme.primary
                            )
                    } ,
                    modifier = Modifier.clickable { navController.navigate("EnergyScreen") }
                        .padding(5.dp)
                        )

                ListItem(
                    headlineContent = { Text("Power") } ,
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.NavigateNext ,
                            contentDescription = null
                            )
                    } ,
                    leadingContent = {
                        Icon(
                            painterResource(id = R.drawable.electrical) ,
                            contentDescription = null ,
                            tint = MaterialTheme.colorScheme.primary
                            )
                    } ,
                    modifier = Modifier.clickable { navController.navigate("PowerScreen") }
                        .padding(5.dp)
                        )
                ListItem(
                    headlineContent = { Text("Time") } ,
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.NavigateNext ,
                            contentDescription = null
                            )
                    } ,
                    leadingContent = {
                        Icon(
                            painterResource(id = R.drawable.clock) ,
                            contentDescription = null ,
                            tint = MaterialTheme.colorScheme.primary
                            )
                    } ,
                    modifier = Modifier.clickable { navController.navigate("TimeScreen") }
                        .padding(5.dp)
                        )
        }
    }
}
