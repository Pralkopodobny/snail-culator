package com.snailsoup.snailculator

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snailsoup.snailculator.ui.theme.SnailculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnailculatorTheme {
                var content by remember { mutableStateOf("")}
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalcButtons(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        content = content,
                        onClick = {command: String -> content += command }
                    )
                }
            }
        }
    }
}

@Composable
fun CalcButtons(modifier: Modifier = Modifier, content: String = "", onClick: (command: String) -> Unit = {}) {
    Column(verticalArrangement = Arrangement.Bottom, modifier = modifier) {
        Text(text = content)
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            CalcButton(onClick = { onClick("C")}, text = "C")
            CalcButton(onClick = { onClick("<-")}, text = "<-")
            CalcButton(onClick = { onClick("%")}, text = "%")
            CalcButton(onClick = { onClick("/")}, text = "/")
        }
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            CalcButton(onClick = { onClick("7")}, text = "7")
            CalcButton(onClick = { onClick("8")}, text = "8")
            CalcButton(onClick = { onClick("9")}, text = "9")
            CalcButton(onClick = { onClick("X")}, text = "X")
        }
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            CalcButton(onClick = { onClick("4")}, text = "4")
            CalcButton(onClick = { onClick("5")}, text = "5")
            CalcButton(onClick = { onClick("6")}, text = "6")
            CalcButton(onClick = { onClick("-")}, text = "-")
        }
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            CalcButton(onClick = { onClick("1")}, text = "1")
            CalcButton(onClick = { onClick("2")}, text = "2")
            CalcButton(onClick = { onClick("3")}, text = "3")
            CalcButton(onClick = { onClick("+")}, text = "+")
        }
        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            CalcButton(onClick = { onClick("")}, text = "")
            CalcButton(onClick = { onClick("0")}, text = "0")
            CalcButton(onClick = { onClick(".")}, text = ".")
            CalcButton(onClick = { onClick("=")}, text = "=")
        }
    }
}

@Composable
fun CalcButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier){
    Button(onClick = onClick,
        shape = CircleShape,
        modifier = modifier.size(70.dp).padding(5.dp),
        contentPadding = PaddingValues(0.dp))
    { Text(text) }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnailculatorTheme {
        CalcButtons()
    }
}