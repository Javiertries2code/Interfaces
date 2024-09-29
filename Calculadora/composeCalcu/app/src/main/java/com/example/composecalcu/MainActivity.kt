package com.example.composecalcu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecalcu.ui.theme.ComposeCalcuTheme
import com.example.composecalcu.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           my_calcu()
            }
        }
    }

@Composable
fun Display_Calcu () {

Row(modifier = Modifier.fillMaxWidth().padding(10.dp).height(120.dp)){
    TextField(
        value = "0",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = 75.sp,
            color = Color.Black,
            textAlign = TextAlign.End
        ),
    )
}}

@Composable
fun OperatorButton(
    operator: String,
    onOperatorClick: (String) -> Unit,
    backgroundColor: Color = colorResource(R.color.default_orange)

    ) {
    Button(
        onClick = { onOperatorClick(operator) },
        colors = ButtonDefaults.buttonColors(backgroundColor),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(8.dp),


    ) {
        Text(text = operator, fontSize = 24.sp, color = Color.Black)
    }
}

@Composable
fun NumberButton(
    number: Int,
    onNumberClick: (Int) -> Unit,
    backgroundColor: Color = colorResource(R.color.focused_blue)

) {
    Button(
        onClick = { onNumberClick(number) },
        colors = ButtonDefaults.buttonColors(backgroundColor),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = number.toString(), fontSize = 24.sp, color = Color.Black)
    }
}

@Composable
fun LineaNum( number1: Int, number2: Int,number3: Int, operator: String   ) {


        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            NumberButton(number = number1, onNumberClick = ::NumberButtonClick)
            NumberButton(number = number2, onNumberClick = ::NumberButtonClick)
            NumberButton(number = number3, onNumberClick = ::NumberButtonClick)
            OperatorButton(operator = operator, onOperatorClick = ::OperatorButtonClick)
        }

}

@Composable
fun LineaOp( operator: String, operator1: String, operator2: String, operator3: String,  ) {


    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        OperatorButton(operator = operator, onOperatorClick = ::OperatorButtonClick)
        OperatorButton(operator = operator1, onOperatorClick = ::OperatorButtonClick)
        OperatorButton(operator = operator2, onOperatorClick = ::OperatorButtonClick)
        OperatorButton(operator = operator3, onOperatorClick = ::OperatorButtonClick)
    }

}



@Preview(showBackground = true)
@Composable
fun my_calcu() {

  Column(modifier = Modifier
      .fillMaxSize()
      .background(Color.DarkGray),
      verticalArrangement = Arrangement.SpaceEvenly
  )
  {
      Display_Calcu()
      LineaOp("C", "%","/", "X")
      LineaNum(7,8,9, "+")
      LineaNum(4,5,6, "-")
      LineaNum(1,2,3, "/")

     Row( horizontalArrangement = Arrangement.SpaceEvenly,
         modifier = Modifier.fillMaxWidth())
     {
         NumberButton(number = 0, onNumberClick = ::NumberButtonClick)
         OperatorButton(operator = ".", onOperatorClick = ::OperatorButtonClick)
         OperatorButton(operator = "+/-", onOperatorClick = ::OperatorButtonClick)
         OperatorButton(operator = "=", onOperatorClick = ::OperatorButtonClick)

     }
  }


}

fun OperatorButtonClick(operator: String) {
    println(" $operator")
}

fun NumberButtonClick(number: Int) {
    println(" $number")
}
