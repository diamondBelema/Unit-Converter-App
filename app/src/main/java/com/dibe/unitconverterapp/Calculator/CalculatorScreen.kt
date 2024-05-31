package com.dibe.unitconverterapp.Calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.filled.SwitchRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dibe.unitconverterapp.Calculator.CalculatorEvent
import com.dibe.unitconverterapp.Calculator.CalculatorState
import kotlin.math.sign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(
        state: CalculatorState,
        onEvent: (CalculatorEvent) -> Unit,
        navController : NavController
                    ) {
    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Calculator" , fontSize = 20.sp) } ,
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("HomeScreen") }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack ,
                                contentDescription = null
                                )
                        }
                    } ,
                         )
            }) { paddingValues ->
            Column(
                horizontalAlignment = Alignment.End ,
                verticalArrangement = Arrangement.Bottom ,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                  ) {
                Column(
                    modifier = Modifier
                        .weight(0.4f)
                        .fillMaxSize()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(color = MaterialTheme.colorScheme.primaryContainer)
                      ) {
                    Column(
                        verticalArrangement = Arrangement.Bottom ,
                        horizontalAlignment = Alignment.End ,
                        modifier = Modifier
                            .padding(9.dp)
                            .weight(0.5f)
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                          ) {
                        TextField(
                            value = state.input ,
                            onValueChange = {} ,
                            readOnly = true ,
                            modifier = Modifier
                                .fillMaxWidth() ,
                            textStyle = LocalTextStyle.current.copy(
                                fontSize = 20.sp ,
                                textAlign = TextAlign.Right ,
                                                                   ) ,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent ,
                                unfocusedContainerColor = Color.Transparent ,
                                cursorColor = Color.Transparent ,
                                focusedIndicatorColor = Color.Transparent ,
                                unfocusedIndicatorColor = Color.Transparent
                                                             )
                                 )

                    }
                    Column(
                        verticalArrangement = Arrangement.Bottom ,
                        horizontalAlignment = Alignment.End ,
                        modifier = Modifier
                            .padding(20.dp)
                            .weight(0.4f)
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                          ) {
                        Text(
                            text = state.result ,
                            fontSize = 32.sp ,
                            modifier = Modifier.align(Alignment.End) ,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                    }
                }
                Card(
                    shape = RoundedCornerShape(20.dp) ,
                    modifier = Modifier
                        .weight(0.7f)
                        .fillMaxSize()
                        .background(
                            color = MaterialTheme.colorScheme.secondaryContainer ,

                            )
                        .border(
                            width = 1.dp ,
                            color = MaterialTheme.colorScheme.primary ,
                               ) ,
                    colors = CardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer ,
                        contentColor = MaterialTheme.colorScheme.secondaryContainer ,
                        disabledContentColor = MaterialTheme.colorScheme.secondaryContainer ,
                        disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer
                                       )
                    ) {
                    if (state.isNormalMode) {
                        NormalButtonColumn(state = state , onEvent = onEvent)
                    } else {
                        SciButtonColumn(state = state , onEvent = onEvent)
                    }
                }
            }
        }
    }
}

@Composable
fun SciButtonColumn(
        state: CalculatorState,
        onEvent: (CalculatorEvent) -> Unit
                      ){
    Column (
        verticalArrangement = Arrangement.SpaceEvenly ,
        horizontalAlignment = Alignment.CenterHorizontally , modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
           ){
        CalculatorButtonRow(
            rowItems = listOf("Sci" , "Clear", "Delete", "/") ,
            onEvent = onEvent
                           )
        CalculatorButtonRow(
            rowItems = listOf("inv", "log" , "ln" , "*") ,
            onEvent = onEvent
                           )
        CalculatorButtonRow(
            rowItems = listOf("sin" , "cos" , "tan", "-") ,
            onEvent = onEvent
                           )
        CalculatorButtonRow(
            rowItems = listOf("pi", "sqrt", "e" , "+") ,
            onEvent = onEvent
                           )
        CalculatorButtonRow(
            rowItems = listOf("xʸ" , "x!" , "( )" , "=") ,
            onEvent = onEvent,
            state = state
                           )
    }
}

@Composable
fun NormalButtonColumn(
        state: CalculatorState,
        onEvent: (CalculatorEvent) -> Unit
                      ){
    Column (
        verticalArrangement = Arrangement.SpaceEvenly ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
           ){
        CalculatorButtonRow(
            rowItems = listOf("Sci" , "Clear", "Delete", "/") ,
            onEvent = onEvent,
            state = state
                           )
        CalculatorButtonRow(
            rowItems = listOf("1" , "2" , "3" , "*") ,
            onEvent = onEvent
                           )
        CalculatorButtonRow(
            rowItems = listOf("4" , "5" , "6" , "-") ,
            onEvent = onEvent
                           )
        CalculatorButtonRow(
            rowItems = listOf("7" , "8" , "9" , "+") ,
            onEvent = onEvent
                           )
        CalculatorButtonRow(
            rowItems = listOf("." , "0" , "%" , "=") ,
            onEvent = onEvent,
            state = state
                           )
    }
}

@Composable
fun RowScope.NumberButton(number: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(number) },
        modifier = Modifier
            .weight(1f)
            .padding(4.dp),
        shape = CircleShape ,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        contentPadding = PaddingValues(12.dp)
          ) {
        Text(number, fontSize = 24.sp, color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}

@Composable
fun RowScope.SignButton(sign: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(sign) },
        modifier = Modifier
            .weight(1f)
            .padding(4.dp) ,
        shape = CircleShape ,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        contentPadding = PaddingValues(12.dp)
          ) {
        Text(sign, fontSize = 24.sp, color = MaterialTheme.colorScheme.onSecondaryContainer)
    }
}

@Composable
fun RowScope.EqualToButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() } ,
        modifier = Modifier
            .weight(1f)
            .padding(4.dp) ,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        shape =  CircleShape ,
        contentPadding = PaddingValues(12.dp)
          ) {
        Text("=", fontSize = 24.sp, color = MaterialTheme.colorScheme.onTertiaryContainer)
    }
}

@Composable
fun RowScope.ClearButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .weight(1f)
            .padding(4.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        contentPadding = PaddingValues(12.dp)
          ) {
        Text("C", fontSize = 24.sp, color = MaterialTheme.colorScheme.onTertiaryContainer)
    }
}

@Composable
fun RowScope.DeleteButton(onClick: () -> Unit) {
    IconButton(
        onClick = { onClick() } ,
        modifier = Modifier
            .weight(1f)
            .padding(4.dp)
            .background(color = MaterialTheme.colorScheme.secondaryContainer , shape = CircleShape) ,
          ) {
        Icon(Icons.AutoMirrored.Outlined.Backspace , contentDescription ="Del", tint = MaterialTheme.colorScheme.onTertiaryContainer)
    }
}

@Composable
fun RowScope.SciButtons(sign : String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(sign) },
        modifier = Modifier
            .weight(1f)
            .padding(4.dp) ,
        shape = CircleShape ,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        contentPadding = PaddingValues(12.dp)
          ) {
        Text(sign, fontSize = 24.sp, color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}

@Composable
fun RowScope.SciButton(onClick: () -> Unit) {
    IconButton(
        onClick = { onClick() } ,
        modifier = Modifier
            .weight(1f)
            .padding(4.dp)
            .background(
                color = MaterialTheme.colorScheme.tertiaryContainer ,
                shape = CircleShape
                       ) ,
        ) {
        Icon(Icons.Default.SwitchRight , contentDescription = "switch left", tint = MaterialTheme.colorScheme.onTertiaryContainer)
    }
}

@Composable
fun CalculatorButtonRow(
        rowItems: List<String>,
        onEvent: (CalculatorEvent) -> Unit,
        state : CalculatorState = CalculatorState()
                       ) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (buttonText in rowItems) {
            when (buttonText) {
                "=" -> EqualToButton(onClick = { onEvent(CalculatorEvent.Calculate) })
                "Clear" -> ClearButton(onClick = { onEvent(CalculatorEvent.Clear) })
                "Delete" -> DeleteButton(onClick = { onEvent(CalculatorEvent.Delete) })
                "Sci" -> SciButton(onClick = { onEvent(CalculatorEvent.Navigate) })
                "inv" -> SciButtons(sign = "inv", onClick = { onEvent(CalculatorEvent.Inverse) })
                "e" -> SciButtons(sign = "e", onClick = { onEvent(CalculatorEvent.Number("e")) })
                "pi" -> SciButtons(sign = "\uD835\uDED1", onClick = { onEvent(CalculatorEvent.Number("pi")) })
                "xʸ" -> SciButtons(sign = "xʸ", onClick = { onEvent(CalculatorEvent.Number("^")) })
                "x!" -> SciButtons(sign = "x!", onClick = { onEvent(CalculatorEvent.Special("!")) })
                "( )" -> {
                    NumberButton(
                        number = buttonText ,
                        onClick = {
                            onEvent(CalculatorEvent.Bracket)
                        }
                                )
                }
                in listOf("sin", "cos", "tan", "ln", "log", "sqrt") -> {
                    SciButtons(
                        sign = if (buttonText != "sqrt") buttonText else "√",
                        onClick = {
                            onEvent(CalculatorEvent.Special(buttonText))
                            state.bracketOpen = true
                        }
                              )

                }
                in listOf("+", "-", "*", "/", "%") -> SignButton(sign = if (buttonText != "*" && buttonText != "/") buttonText else if (buttonText == "/") "÷" else "×", onClick = { onEvent(CalculatorEvent.Operation(if (buttonText == "%") "00" else buttonText)) })
                else -> NumberButton(number = buttonText, onClick = { onEvent(CalculatorEvent.Number(buttonText)) })
            }
        }
    }
}



