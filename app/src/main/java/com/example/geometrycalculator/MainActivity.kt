package com.example.geometrycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    var side by remember { mutableStateOf("") }
    var radius by remember { mutableStateOf("") }
    var width by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var base by remember { mutableStateOf("") }
    var triangleHeight by remember { mutableStateOf("") }
    var areaResult by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Geometry Area Calculator", style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(16.dp))

        // Square Input and Calculation
        TextField(
            value = side,
            onValueChange = { side = it },
            label = { Text("Side of Square") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            areaResult = if (side.isNotEmpty()) {
                val s = side.toDouble()
                "Square Area: ${s.pow(2)}"
            } else {
                "Please enter a valid side length"
            }
        }) {
            Text("Calculate Square Area")
        }

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
            Text("Calculate Circle Area")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Rectangle Input and Calculation
        TextField(
            value = width,
            onValueChange = { width = it },
            label = { Text("Width of Rectangle") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Height of Rectangle") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            areaResult = if (width.isNotEmpty() && height.isNotEmpty()) {
                val w = width.toDouble()
                val h = height.toDouble()
                "Rectangle Area: ${w * h}"
            } else {
                "Please enter valid width and height"
            }
        }) {
            Text("Calculate Rectangle Area")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Triangle Input and Calculation
        TextField(
            value = base,
            onValueChange = { base = it },
            label = { Text("Base of Triangle") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = triangleHeight,
            onValueChange = { triangleHeight = it },
            label = { Text("Height of Triangle") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            areaResult = if (base.isNotEmpty() && triangleHeight.isNotEmpty()) {
                val b = base.toDouble()
                val h = triangleHeight.toDouble()
                "Triangle Area: ${(b * h) / 2}"
            } else {
                "Please enter valid base and height"
            }
        }) {
            Text("Calculate Triangle Area")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display result
        Text(areaResult)
    }
}
