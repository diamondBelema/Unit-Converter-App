package com.dibe.unitconverterapp.Calculator

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.udojava.evalex.Expression
import java.lang.ArithmeticException

class CalculatorViewModel : ViewModel() {

    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state

    fun onEvent(event: CalculatorEvent) = when (event) {
        is CalculatorEvent.Number -> {
            val track = _state.value.track
            track.add(event.number)
            _state.value = _state.value.copy(
                input = if (event.number == "pi") "\uD835\uDED1" else _state.value.input + event.number,
                solvingString = _state.value.solvingString + event.number,
                track = track
                                            )
        }

        is CalculatorEvent.Operation -> {
            val track = _state.value.track
            track.add(event.operation)

            _state.value = _state.value.copy(
                input = if (event.operation == "*") _state.value.input + "×" else if (event.operation == "/") _state.value.input + "÷" else _state.value.input + event.operation,
                solvingString = _state.value.solvingString + event.operation,
                track = track
                                            )
        }

        CalculatorEvent.Navigate -> {
            _state.value = _state.value.copy(
                isNormalMode = !_state.value.isNormalMode
                                            )
        }

        CalculatorEvent.Calculate -> {
            try {
                val expression = Expression(_state.value.solvingString)
                val result = expression.eval()
                _state.value = _state.value.copy(result = result.toString())
            }catch (e: Expression.ExpressionException){
                Log.i("MyTag", e.toString())
                _state.value = _state.value.copy(result = e.message.orEmpty())
            }catch (e: ArithmeticException){
                Log.i("MyTag", e.toString())
                _state.value = _state.value.copy(result = "Math Error")
            }catch (e: Exception){
                Log.i("MyTag", e.toString())
                _state.value = _state.value.copy(result = "Factory Error")
            }
        }

        CalculatorEvent.Clear -> {
            _state.value = CalculatorState()
        }

        CalculatorEvent.Delete -> {
            val track = _state.value.track
            if (track.isNotEmpty()) {
                _state.value = _state.value.copy(
                    bracketOpen = _state.value.solvingString.last() == ')'
                                                )
                _state.value = _state.value.copy(
                    input = _state.value.input.dropLast(1) ,
                    solvingString = _state.value.solvingString.dropLast(track.last().length) ,
                    track = _state.value.track.dropLast(1).toMutableList()
                                                )

            } else {
                _state.value = CalculatorState()
            }
        }

        is CalculatorEvent.Special -> {
            val track = _state.value.track
            track.add(event.special + "(")

            when (event.special) {
                "!" -> {
                    var string = ""
                    for (i in 2..<_state.value.input.last().toString().toInt()){
                        string = "$string*$i"
                    }

                    track.removeLast()
                    track.add(string)

                    _state.value = _state.value.copy(
                        input = _state.value.input + "!",
                        solvingString = _state.value.solvingString + string,
                        track = track,
                                                    )
                }

                "sqrt" -> {
                    _state.value = _state.value.copy(
                        input = _state.value.input + "√(",
                        solvingString = _state.value.solvingString + "SQRT(",
                        bracketOpen = !_state.value.bracketOpen,
                        track = track,
                                                    )
                }

                "ln" -> {
                    _state.value = _state.value.copy(
                        input = if (_state.value.isInverse) "${_state.value.input}e^" else "${_state.value.input}ln " ,
                        solvingString = if (_state.value.isInverse) "${_state.value.input}e^" else "${_state.value.input}1/e^" ,
                        track = track,
                                                    )
                }

                "log" -> {
                    _state.value = _state.value.copy(
                        input = if (_state.value.isInverse) "${_state.value.input}10^" else "${_state.value.input}log(" ,
                        solvingString = if (_state.value.isInverse) "${_state.value.input}10^" else "${_state.value.input}${event.special}(" ,
                        track = track,
                                                    )
                }

                else -> {
                    _state.value = _state.value.copy(
                        input = if (_state.value.isInverse) "${_state.value.input}${event.special}⁻¹(" else "${_state.value.input}${event.special}(" ,
                        solvingString = if (_state.value.isInverse) "${_state.value.input}a${event.special}(" else "${_state.value.input}${event.special}(" ,
                        bracketOpen = !_state.value.bracketOpen ,
                        track = track ,
                                                    )
                }
            }
        }

        CalculatorEvent.Bracket -> {
            val track = _state.value.track
            track.add("(")
            val bracket : String = if (_state.value.bracketOpen) ")" else "("

            _state.value = _state.value.copy(
                input = _state.value.input + bracket,
                solvingString = _state.value.solvingString + bracket,
                bracketOpen = !_state.value.bracketOpen,
                track = track
                                            )
        }

        CalculatorEvent.Inverse -> {
            _state.value = _state.value.copy(
                isInverse = !_state.value.isInverse
                                            )
        }
    }
}
