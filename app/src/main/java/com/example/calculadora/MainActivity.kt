package com.example.calculadora

import android.graphics.drawable.ShapeDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.ui.theme.CalculadoraTheme
import java.util.Stack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    Calculadora()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Calculadora() {

    var texto_entrada by rememberSaveable {
        mutableStateOf("")
    }
    var texto_salida by rememberSaveable {
        mutableStateOf("0")
    }
    var isEnabled by rememberSaveable {
        mutableStateOf(true)
    }


    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.5f)
                .background(Color.White)
                .padding(5.dp)
        ) {
            Operacion(texto_entrada)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.5f)
                .background(Color.White)
                .padding(5.dp)
        ) {
            Resultado(texto_salida)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)

        ) {
            Column {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .weight(1f)
                        .padding(10.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("7", isEnabled, {
                            texto_entrada += "7"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("8", isEnabled, {
                            texto_entrada += "8"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("9", isEnabled, {
                            texto_entrada += "9"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("+", isEnabled, {
                            texto_entrada += "+"
                        })
                    }
                }


                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("4", isEnabled, {
                            texto_entrada += "4"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("5", isEnabled, {
                            texto_entrada += "5"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("6", isEnabled, {
                            texto_entrada += "6"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        OperationButton("-", isEnabled, {
                            texto_entrada += "-"
                        })
                    }
                }
                Row (
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .weight(1f)
                        .padding(10.dp)
                ){
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("1", isEnabled, {
                            texto_entrada += "1"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("2", isEnabled, {
                            texto_entrada += "2"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("3", isEnabled, {
                            texto_entrada += "3"
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("x", isEnabled, {
                            texto_entrada += "x"
                        })
                    }

                }
                Row (
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black)
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("C", isEnabled, {
                            texto_entrada = ""
                        })
                    }
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("⌫", isEnabled, {
                            if(texto_entrada.length >= 1){
                                texto_entrada = texto_entrada.substring(0,texto_entrada.length-1)}
                        })
                    }

                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("0", isEnabled, {
                            texto_entrada +=  "0"
                        })
                    }
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("/", isEnabled, {
                            texto_entrada +=  "/"
                        })
                    }
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                            .weight(1f), contentAlignment = Alignment.Center

                    ) {
                        OperationButton("=", isEnabled, {
                            texto_salida = Calcular(texto_entrada).toString()
                        })
                    }

                }

            }
        }
    }
}


fun esNumerica(cadena: String): Boolean {
    return cadena.toDoubleOrNull() != null
}


@Composable
fun OperationButton(operacion: String, isEnabled: Boolean, onKeyPresseded: () -> Unit) {
    Button(
        modifier = Modifier
            .size(180.dp)
            .clip(RectangleShape)
            .background(Color.Black),
        enabled = isEnabled,
        onClick = { onKeyPresseded() },
        colors = ButtonDefaults.buttonColors(Color.Black)) {
        Text(text = operacion,
            style = TextStyle(fontSize = 25.sp),
            color = Color.White)
    }
}


@Composable
fun Numero(numero: String, onValueChanged: (String) -> Unit) {
    TextField(
        modifier = Modifier.padding(25.dp),
        value = numero,
        label = { Text(text = "Número") },
        textStyle = TextStyle(textAlign = TextAlign.End),
        onValueChange = { onValueChanged(it) })
}


@Composable
fun Operacion(numero: String) {
    Text(
        text = numero, Modifier.fillMaxWidth(),
        maxLines = 2,
        style = TextStyle(
            fontSize = 40.sp,
            color = Color.Black,

        ),
        textAlign = TextAlign.End
    )
}

@Composable
fun Resultado(numero: String) {
    Text(
        text = numero, Modifier.fillMaxWidth(),
        maxLines = 2,
        style = TextStyle(
            fontSize = 40.sp,
            color = Color.Black,

            ),
        textAlign = TextAlign.End
    )
}

fun Calcular(numero: String): Double {
    val operators = mutableListOf<Char>()
    val operands = mutableListOf<Double>()
    var currentNumber = StringBuilder()

    fun performOperation(operator: Char) {
        val operand2 = operands.removeLast()
        val operand1 = operands.removeLast()
        when (operator) {
            '+' -> operands.add(operand1 + operand2)
            '-' -> operands.add(operand1 - operand2)
            'x' -> operands.add(operand1 * operand2)
            '/' -> operands.add(operand1 / operand2)
        }
    }
    for (char in numero) {
        when {
            char.isDigit() || char == '.' -> currentNumber.append(char)
            char in "+-x/" -> {
                if (currentNumber.isNotEmpty()) {
                    operands.add(currentNumber.toString().toDouble())
                    currentNumber.clear()
                }
                while (operators.isNotEmpty() && operators.last() in "x/" &&
                    char in "+-" && operators.last() != '('
                ) {
                    performOperation(operators.removeLast())
                }
                operators.add(char)
            }
            char == '(' -> operators.add(char)
            char == ')' -> {
                if (currentNumber.isNotEmpty()) {
                    operands.add(currentNumber.toString().toDouble())
                    currentNumber.clear()
                }
                while (operators.isNotEmpty() && operators.last() != '(') {
                    performOperation(operators.removeLast())
                }
                operators.removeLast()
            }
        }
    }
    if (currentNumber.isNotEmpty()) {
        operands.add(currentNumber.toString().toDouble())
    }
    while (operators.isNotEmpty()) {
        performOperation(operators.removeLast())
    }
    return if (operands.isNotEmpty()) operands[0] else 0.0
}