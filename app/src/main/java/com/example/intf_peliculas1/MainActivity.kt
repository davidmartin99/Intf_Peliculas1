package com.example.intf_peliculas1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.intf_peliculas1.ui.theme.Intf_Peliculas1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Intf_Peliculas1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Pepe",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Composable para la interfaz de usuario
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Text(
        text = "Bye $name!",
        modifier = modifier
    )

}//Fin Greeting
@Composable
fun BasicBoxExample(name: String, modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(16.dp)) //Redondear Fondo
            .border(6.dp, Color.Green, shape = RoundedCornerShape(16.dp))   //Redondear Bordes
            .padding(16.dp)
    ) {
        Text(
            text = "Hello $name!",
            color = Color.Red,
            modifier = modifier
                .align(Alignment.TopCenter)  //Posicion
                .padding(8.dp)               //Margen
                .background(Color.Blue, shape = RoundedCornerShape(9.dp))
        )
        Text(
            text = "Bye $name!",
            color = Color.Blue,
            modifier = modifier
                .align(Alignment.Center)  //Posicion
                .padding(8.dp)            //Margen
                .background(Color.Red, shape = RoundedCornerShape(9.dp))
        )
    }//Fin Box
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text("A", Modifier.background(Color.Red))
        Text("B", Modifier.background(Color.Green))
        Text("C", Modifier.background(Color.Blue))
    }//Fin Row
}//Fin BasicBoxExample

@Composable
fun AdaptiveBoxSize(name: String, modifier: Modifier = Modifier) {
    BoxWithConstraints(
        modifier = modifier.fillMaxSize()
    ) {
        val screenWidth = maxWidth

        val sizeCategory = when {
            screenWidth < 400.dp -> "Small"
            screenWidth < 600.dp -> "Medium"
            else -> "Large"
        }
        val boxSize = when (sizeCategory) {
            "Small" -> screenWidth * 0.6f
            "Medium" -> screenWidth * 0.5f
            else -> screenWidth * 0.4f
        }
        Box(
            modifier
                .size(boxSize)
                .background(Color.Cyan, shape = RoundedCornerShape(16.dp))
                .align(Alignment.Center)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom

            ) {
                Text("A", Modifier.size(50.dp, 100.dp).background(Color.Red))
                Text("B", Modifier.size(50.dp, 100.dp).background(Color.Green))
                Text("C", Modifier.size(50.dp, 100.dp).background(Color.Blue))
            }//Fin Row
        }
    }
}//Fin AdaptiveBoxExample



// Preview nos permite ver las cosas de interfaz de usuario
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Intf_Peliculas1Theme {
        Column {
            Greeting("Pepe")
            BasicBoxExample("David")
            AdaptiveBoxSize("")
        }
    }
}//Fin GreetingPreview