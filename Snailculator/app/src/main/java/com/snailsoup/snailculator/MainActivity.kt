package com.snailsoup.snailculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import com.snailsoup.snailculator.ui.theme.SnailculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnailculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorView(
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun CalculatorView(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Bottom, modifier = modifier) {
        var content by remember { mutableStateOf("")}
        Text(text = content)
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { content += "C"}) { Text("C") }
            Button(onClick = { content += "<-"}) { Text("<-") }
            Button(onClick = { content += "%"}) { Text("%") }
            Button(onClick = { content += "/"}) { Text("/") }
        }
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { content += "7"}) { Text("7") }
            Button(onClick = { content += "8"}) { Text("8") }
            Button(onClick = { content += "9"}) { Text("9") }
            Button(onClick = { content += "X"}) { Text("X") }
        }
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { content += "4"}) { Text("4") }
            Button(onClick = { content += "5"}) { Text("5") }
            Button(onClick = { content += "6"}) { Text("6") }
            Button(onClick = { content += "-"}) { Text("-") }
        }
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { content += "1"}) { Text("1") }
            Button(onClick = { content += "2"}) { Text("2") }
            Button(onClick = { content += "3"}) { Text("3") }
            Button(onClick = { content += "+"}) { Text("+") }
        }
        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { content += ""}) { Text("") }
            Button(onClick = { content += "0"}) { Text("0") }
            Button(onClick = { content += "."}) { Text(".") }
            Button(onClick = { content += "="}) { Text("=") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnailculatorTheme {
        CalculatorView()
    }
}