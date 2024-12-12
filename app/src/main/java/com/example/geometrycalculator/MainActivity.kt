package com.example.geometrycalculator
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.geometrycalculator.ui.theme.GeometryCalculatorTheme
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeometryCalculatorTheme {
                GeometryCalculatorApp()
            }
        }
    }
}

@Composable
fun GeometryCalculatorApp() {
    var radius by remember { mutableStateOf("") }
    var areaResult by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Geometry Area Calculator", style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(16.dp))

        // Circle Input and Calculation
        TextField(
            value = radius,
            onValueChange = { radius = it },
            label = { Text("Radius") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            areaResult = if (radius.isNotEmpty()) {
                val r = radius.toDouble()
                "Circle Area: ${PI * r.pow(2)}"
            } else {
                "Please enter a valid radius"
            }
        }) {
            Text("Calculate Area")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display result
        Text(areaResult)
    }
}
