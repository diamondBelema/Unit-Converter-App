package com.dibe.learningcomposeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.filled.Science
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dibe.unitconverterapp.Calculator.CalculatorViewModel

@Composable
fun ColumnScope.CalcButton(
        symbol : String ,
        color : Color ,
        textColor : Color = Color(0xFF000000) ,
        weight : Float = 1f,
        calc : () -> Unit ,
        fontSize : TextUnit = 20.sp
                          ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .weight(weight)
            .clickable { calc() }
            .padding(10.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(color = color)
            .padding(10.dp) ,
        contentAlignment = Alignment.Center
       ) {
        Text(text = symbol , color = textColor , fontSize = fontSize)
    }
}

@Composable
fun ColumnScope.OutlinedCalcButton(
        symbol : String ,
        calc : (String) -> Unit ,
        fontSize : TextUnit = 30.sp
                                  ) {
    ElevatedButton(onClick = { calc(symbol) },
                   modifier = Modifier
                       .weight(1f)
                       .padding(8.dp)
                       .fillMaxSize()
                  ) {
        Text(text = symbol , fontSize = fontSize)
    }
}

@Composable
fun ReviewText(
        text : String ,
        fontSize : TextUnit
              ) {
    Text(
        text = text ,
        fontSize = fontSize ,
        color = MaterialTheme.colorScheme.onTertiaryContainer ,
        fontWeight = FontWeight.Light ,
        modifier = Modifier
            .fillMaxWidth()
        )
}


@Composable
fun ColumnScope.NormalScreen(viewModel : CalculatorViewModel) {
    Surface(
        modifier = Modifier
            .weight(0.7f) ,
           ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly ,
            modifier = Modifier
                .fillMaxSize()
           ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) ,
                verticalArrangement = Arrangement.SpaceEvenly ,
                  ) {
                CalcButton(
                    symbol = "c" ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.clear() })
                OutlinedCalcButton(
                    symbol = "7" ,
                    calc = { viewModel.updateDisplayText("7") })
                OutlinedCalcButton(
                    symbol = "4" ,
                    calc = { viewModel.updateDisplayText("4") })
                OutlinedCalcButton(
                    symbol = "1" ,
                    calc = { viewModel.updateDisplayText("1") })
                CalcButton(
                    symbol = "%" ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { viewModel.addOperator("%") })
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) ,
                verticalArrangement = Arrangement.SpaceEvenly ,
                  ) {
                CalcButton(
                    symbol = "÷" ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.addOperator("÷") })
                OutlinedCalcButton(
                    symbol = "8" ,
                    calc = { viewModel.updateDisplayText("8") })
                OutlinedCalcButton(
                    symbol = "5" ,
                    calc = { viewModel.updateDisplayText("5") })
                OutlinedCalcButton(
                    symbol = "2" ,
                    calc = { viewModel.updateDisplayText("2") })
                OutlinedCalcButton(
                    symbol = "0" ,
                    calc = { viewModel.updateDisplayText("0") })
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) ,
                verticalArrangement = Arrangement.SpaceEvenly ,
                  ) {
                CalcButton(
                    symbol = "×" ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.addOperator("×") })
                OutlinedCalcButton(
                    symbol = "9" ,
                    calc = { viewModel.updateDisplayText("9") })
                OutlinedCalcButton(
                    symbol = "6" ,
                    calc = { viewModel.updateDisplayText("6") })
                OutlinedCalcButton(
                    symbol = "3" ,
                    calc = { viewModel.updateDisplayText("3") })
                OutlinedCalcButton(
                    symbol = "." ,
                    calc = { viewModel.putPoint() })
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) ,
                verticalArrangement = Arrangement.SpaceEvenly ,
                  ) {
                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(80.dp)
                        .weight(1f)
                        .clickable { viewModel.delete() }
                        .padding(10.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(100.dp))
                        .background(color = MaterialTheme.colorScheme.secondaryContainer)
                        .padding(10.dp) ,
                    contentAlignment = Alignment.Center
                   ) {
                    Icon(
                        Icons.AutoMirrored.Default.Backspace,
                        contentDescription = "DEL" ,
                        tint = MaterialTheme.colorScheme.secondary
                        )
                }
                CalcButton(
                    symbol = "-" ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.addOperator("-") })
                CalcButton(
                    symbol = "+" ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.addOperator("+") })
                CalcButton(
                    symbol = "=" ,
                    color = MaterialTheme.colorScheme.primaryContainer ,
                    textColor = MaterialTheme.colorScheme.primary ,
                    weight = 2f ,
                    calc = { viewModel.displayAns() })
            }
        }
    }
}

@Composable
fun ColumnScope.ScientificScreen(viewModel : CalculatorViewModel) {
    Surface(
        modifier = Modifier
            .weight(0.7f) ,
           ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly ,
            modifier = Modifier
                .fillMaxSize()
           ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) ,
                verticalArrangement = Arrangement.SpaceEvenly ,
                  ) {
                CalcButton(
                    symbol = "c" ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.clear() })
                CalcButton(
                    symbol = viewModel.sinString.value ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { if (viewModel.sinString.value == "sin") viewModel.`addSci-fi`("s")
                        else viewModel.`addSci-fi`("u")
                    })
                CalcButton(
                    symbol = viewModel.lnString.value ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { viewModel.`addSci-fi`("l") })
                CalcButton(
                    symbol = "(" ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { viewModel.addOperator("%") })
                CalcButton(
                    symbol = "\uD835\uDED1" ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.`addSci-fi`("p") })
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) ,
                verticalArrangement = Arrangement.SpaceEvenly ,
                  ) {
                CalcButton(
                    symbol = viewModel.angleString.value ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.changeAngle() })
                CalcButton(
                    symbol = viewModel.cosString.value ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { if (viewModel.cosString.value == "cos") viewModel.`addSci-fi`("c")
                    else viewModel.`addSci-fi`("v") })
                CalcButton(
                    symbol = viewModel.logString.value ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { viewModel.`addSci-fi`("L") })
                CalcButton(
                    symbol = ")" ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { viewModel.addOperator("%") })
                CalcButton(
                    symbol = "e" ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { viewModel.addOperator("2") })
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) ,
                verticalArrangement = Arrangement.SpaceEvenly ,
                  ) {
                CalcButton(
                    symbol = "inv" ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.inv() })
                CalcButton(
                    symbol = viewModel.tanString.value,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { if (viewModel.tanString.value == "tan") viewModel.`addSci-fi`("t")
                    else viewModel.`addSci-fi`("w") })
                CalcButton(
                    symbol = "√" ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { viewModel.`addSci-fi`("√") })
                CalcButton(
                    symbol = "xʸ" ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { viewModel.`addSci-fi`("r") })
                CalcButton(
                    symbol = "x!" ,
                    color = MaterialTheme.colorScheme.tertiaryContainer ,
                    textColor = MaterialTheme.colorScheme.tertiary ,
                    calc = { viewModel.`addSci-fi`("!") })
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f) ,
                verticalArrangement = Arrangement.SpaceEvenly ,
                  ) {
                Box(
                    modifier = Modifier
                        .width(160.dp)
                        .height(80.dp)
                        .weight(1f)
                        .clickable { viewModel.delete() }
                        .padding(10.dp)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(100.dp))
                        .background(color = MaterialTheme.colorScheme.secondaryContainer)
                        .padding(10.dp) ,
                    contentAlignment = Alignment.Center
                   ) {
                    Icon(
                        Icons.AutoMirrored.Default.Backspace ,
                        contentDescription = "DEL" ,
                        tint = MaterialTheme.colorScheme.secondary
                        )
                }
                CalcButton(
                    symbol = viewModel.angleString.value ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.changeAngle() })
                CalcButton(
                    symbol = "x⁻¹" ,
                    color = MaterialTheme.colorScheme.secondaryContainer ,
                    textColor = MaterialTheme.colorScheme.secondary ,
                    calc = { viewModel.addOperator("x⁻¹") })

                CalcButton(
                    symbol = "=" ,
                    color = MaterialTheme.colorScheme.primaryContainer ,
                    textColor = MaterialTheme.colorScheme.primary ,
                    weight = 2f ,
                    calc = { viewModel.displayAns() })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(viewModel : CalculatorViewModel , navController : NavController) {
    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Calculator" , fontSize = 20.sp) } ,
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("HomeScreen") }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBackIos ,
                                contentDescription = null
                                )
                        }
                    },
                         )
            }) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues) ,
                horizontalAlignment = Alignment.CenterHorizontally ,
                verticalArrangement = Arrangement.Bottom
                  ) {
                Surface(
                    modifier = Modifier
                        .weight(0.4f) ,
                       ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(30.dp))
                            .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                        ) {
                        Column(
                            verticalArrangement = Arrangement.Bottom ,
                            horizontalAlignment = Alignment.End ,
                            modifier = Modifier
                                .padding(20.dp)
                                .weight(2f)
                                .fillMaxWidth()
                              ) {
                            Row(
                                verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier
                                    .horizontalScroll(rememberScrollState())
                               ){
                                ReviewText(
                                text = viewModel.displayText.value ,
                                fontSize = viewModel.displayTextFontSize.intValue.sp
                                            )
                            }
                            Row(
                                verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier
                                    .horizontalScroll(rememberScrollState())
                               ) {
                                ReviewText(
                                    text = viewModel.ansText.value ,
                                    fontSize = viewModel.ansTextFontSize.intValue.sp
                                          )
                            }
                        }
                    }
                }
                Column (
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .weight(0.05f)
                        .fillMaxSize()
                       ){
                    IconButton(onClick = { viewModel.changeScreen() }) {
                        Icon(
                            imageVector = Icons.Filled.Science,
                            contentDescription = "Localized description"
                            )
                    }
                }
                if (viewModel.isNormalCalculator.value) {
                    NormalScreen(viewModel = viewModel)
                } else {
                    ScientificScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    val navController = rememberNavController()
    CalculatorScreen(viewModel = CalculatorViewModel() , navController = navController)
}

