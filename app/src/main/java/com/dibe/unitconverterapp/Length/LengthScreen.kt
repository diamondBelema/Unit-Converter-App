package com.dibe.unitconverterapp.Length

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavHostController

@Composable
private fun NumberButton(number : String , onClick : (String) -> Unit) {
    ElevatedButton(onClick = { onClick(number) }) {
        Text(text = number , fontSize = 40.sp)
    }
}

@Composable
private fun ChangeUnitButton(shortcut : String , unit : String , onClick : (String) -> Unit) {
    TextButton(
        onClick = { onClick(unit) } ,
        modifier = Modifier
            .fillMaxWidth()
              ) {
        Text(text = "$unit $shortcut")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LengthScreen(viewModel : LengthViewModel , navController : NavHostController) {
    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Length" , fontSize = 20.sp) } ,
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("HomeScreen") }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBackIos , contentDescription = null)
                        }
                    }
                         )
            }
                ) {padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                  ) {
                Card(
                    modifier = Modifier
                        .weight(0.4f)
                        .padding(10.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = MaterialTheme.colorScheme.tertiaryContainer) ,
                    ) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .padding(10.dp) ,
                        verticalAlignment = Alignment.CenterVertically ,
                        horizontalArrangement = Arrangement.SpaceBetween
                       ) {
                        FilledTonalButton(onClick = { viewModel.openBottomSheet("unitOne") }) {
                            Text(text = viewModel.unitOne.value , fontSize = 40.sp)
                        }
                        Column(
                            verticalArrangement = Arrangement.Bottom ,
                            horizontalAlignment = Alignment.End ,
                            modifier = Modifier
                                .padding(20.dp)
                                .horizontalScroll(rememberScrollState())
                              ) {
                            Text(
                                text = viewModel.textOne.value ,
                                fontSize = viewModel.fontSizeOne.value.sp ,
                                modifier = Modifier.padding(8.dp)
                                )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .padding(10.dp) ,
                        verticalAlignment = Alignment.CenterVertically ,
                        horizontalArrangement = Arrangement.SpaceBetween
                       ) {
                        FilledTonalButton(onClick = { viewModel.openBottomSheet("unitTwo") }) {
                            Text(text = viewModel.unitTwo.value , fontSize = 40.sp)
                        }
                        Column(
                            verticalArrangement = Arrangement.Bottom ,
                            horizontalAlignment = Alignment.End ,
                            modifier = Modifier
                                .padding(20.dp)
                                .horizontalScroll(rememberScrollState())
                              ) {
                            Text(
                                text = viewModel.textTwo.value ,
                                fontSize = viewModel.fontSizeOne.value.sp ,
                                modifier = Modifier.padding(8.dp)
                                )
                        }
                    }
                }
                Row(
                    verticalAlignment = Alignment.Top ,
                    horizontalArrangement = Arrangement.Center ,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(0.7f)
                   ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize() ,
                        verticalArrangement = Arrangement.SpaceAround
                          ) {
                        NumberButton(number = "7" , onClick = { viewModel.changeTextOne("7") })
                        NumberButton(number = "4" , onClick = { viewModel.changeTextOne("4") })
                        NumberButton(number = "1" , onClick = { viewModel.changeTextOne("1") })
                        TextButton(onClick = { /*TODO*/ } , enabled = false) {
                            Text(
                                text = " " ,
                                fontSize = 40.sp
                                )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize() ,
                        verticalArrangement = Arrangement.SpaceAround
                          ) {
                        NumberButton(number = "8" , onClick = { viewModel.changeTextOne("8") })
                        NumberButton(number = "5" , onClick = { viewModel.changeTextOne("5") })
                        NumberButton(number = "2" , onClick = { viewModel.changeTextOne("2") })
                        NumberButton(number = "0" , onClick = { viewModel.changeTextOne("0") })
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize() ,
                        verticalArrangement = Arrangement.SpaceAround
                          ) {
                        NumberButton(number = "9" , onClick = { viewModel.changeTextOne("9") })
                        NumberButton(number = "6" , onClick = { viewModel.changeTextOne("6") })
                        NumberButton(number = "3" , onClick = { viewModel.changeTextOne("3") })
                        NumberButton(number = "." , onClick = { viewModel.addDot() })
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize() ,
                        verticalArrangement = Arrangement.SpaceAround
                          ) {
                        FilledTonalButton(
                            onClick = { viewModel.clearAll() } ,
                            modifier = Modifier
                                .height(170.dp)
                                .width(85.dp)
                                         ) {
                            Text(text = "AC" , fontSize = 20.sp)
                        }
                        FilledTonalButton(
                            onClick = { viewModel.delete() } ,
                            modifier = Modifier
                                .height(170.dp)
                                .width(85.dp)
                                         ) {
                            Icon(Icons.AutoMirrored.Outlined.Backspace , contentDescription = "DEL")
                        }
                    }
                }
            }
        }
    }
    val sheetState = rememberModalBottomSheetState()

    if (viewModel.isSheetOpen.value) {
        ModalBottomSheet(
            sheetState = sheetState ,
            onDismissRequest = { viewModel.isSheetOpen.value = false } ,
            modifier = Modifier
                .height(LengthVariables.units.size * 58.dp)
                        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceEvenly
                  ) {
                LengthVariables.units.forEach { (shortcut , unit) ->
                    ChangeUnitButton(
                        shortcut = shortcut ,
                        unit = unit ,
                        onClick = { viewModel.changeUnit(shortcut) })
                }
            }
        }
    }
}
