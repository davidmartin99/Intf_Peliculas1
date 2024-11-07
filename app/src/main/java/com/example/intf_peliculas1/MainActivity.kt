package com.example.intf_peliculas1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
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
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Hello $name!",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue, offset = offset, blurRadius = 3f
            )
        )
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
                Text("A",
                    Modifier
                        .size(50.dp, 100.dp)
                        .background(Color.Red))
                Text("B",
                    Modifier
                        .size(50.dp, 100.dp)
                        .background(Color.Green))
                Text("C",
                    Modifier
                        .size(50.dp, 100.dp)
                        .background(Color.Blue))
            }//Fin Row
        }
    }
}//Fin AdaptiveBoxExample

// Funcion de ROW
@Composable
fun BasicRow(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()  // Ocupa todo el ancho disponible
            .height(130.dp)  // Altura de 200 dp
            .background(Color.DarkGray, shape = RoundedCornerShape(16.dp)) // Redondear fondo
            .border(6.dp, Color.Green, shape = RoundedCornerShape(16.dp))   // Redondear bordes
            .padding(40.dp),
        verticalArrangement = Arrangement.SpaceEvenly // Espacio uniforme entre elementos
    ) {
        Text(
            text = "Hello $name!",
            color = Color.Red,
            modifier = modifier
                .padding(8.dp)               // Margen
                .background(Color.Blue, shape = RoundedCornerShape(9.dp))
                .shadow(5.dp)
        )
        Text(
            text = "Bye $name!",
            color = Color.Blue,
            modifier = modifier
                .padding(8.dp)            // Margen
                .background(Color.Red, shape = RoundedCornerShape(9.dp))
        )
    } // Fin de Column
}

/**
 * EJERCICIO DE CLASE
 */
//Variable de texto
val textShadow = Shadow(
    color = Color.Gray, // Shadow color
    offset = Offset(6f, 9f), // Shadow offset
    blurRadius = 9f // Shadow blur radius
)

@Composable
fun Ejercicio1(name: String, modifier: Modifier = Modifier){

    Box(
        modifier = Modifier
            .fillMaxSize()  // Hacer que la Box ocupe toda la pantalla
            .background(Color.White, shape = RoundedCornerShape(16.dp)) //Redondear Fondo
            .border(6.dp, Color.Green, shape = RoundedCornerShape(16.dp))   //Redondear Bordes
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()  // Ensure the Column takes up all available space
                .padding(16.dp), // Optional padding around the column
            horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
        ) {
            //Row arriba
            Row(
                modifier = Modifier
                    .height(200.dp)
                    .width(500.dp)
                    .background(
                        Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                    ) // Rounded background
                    .border(
                        6.dp,
                        Color.Magenta,
                        shape = RoundedCornerShape(16.dp)
                    ) // Rounded borders
                    .padding(40.dp),
                horizontalArrangement = Arrangement.SpaceBetween, // Space between the boxes
                verticalAlignment = Alignment.CenterVertically // Align vertically to the center
            ){
                // 1ºBox
                Box(
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .background(Color.Red), //Redondear FondohorizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                    contentAlignment = Alignment.Center

                ){
                    Text(
                        "Hola",
                        color = Color.Blue, // Change text color to Blue
                        fontSize = 25.sp, // Increase font size
                        fontWeight = FontWeight.Bold, // Make text bold
                        modifier = Modifier
                            .padding(1.dp)
                            .padding(bottom = 40.dp)
                    )

                    // Add padding to position B below A
                    Text(
                        "Adios",
                        color = Color.Blue, // Change text color to Blue
                        fontSize = 25.sp, // Increase font size
                        fontWeight = FontWeight.Bold, // Make text bold
                        modifier = Modifier
                            .padding(1.dp)
                            .padding(top = 40.dp)
                    )

                }//Fin 1ºBox

                // 2ºBox
                Box(
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .background(Color.Black), //Redondear FondohorizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                    contentAlignment = Alignment.Center

                ){
                    Text(
                        "Hello",
                        modifier = Modifier
                            .padding(1.dp)
                            .padding(bottom = 40.dp),
                        style = TextStyle(
                            color = Color.Red, // Text color
                            fontSize = 25.sp, // Font size
                            fontWeight = FontWeight.Bold, // Font weight
                            shadow = textShadow // Apply shadow
                        )

                    )

                    // Add padding to position B below A
                    Text(
                        "Bye",
                        modifier = Modifier
                            .padding(1.dp)
                            .padding(top = 40.dp),

                        style = TextStyle(
                            color = Color.Red, // Text color
                            fontSize = 25.sp, // Font size
                            fontWeight = FontWeight.Bold, // Font weight
                            shadow = textShadow // Apply shadow
                        )

                    )

                }//Fin 2ºBox


            }//Fin Box 2

            // Spacer to create space between the boxes
            Spacer(modifier = Modifier.height(40.dp)) // Adjust height for spacing

            //Row Abajo
            Row(

                modifier = Modifier
                    .height(300.dp)
                    .width(500.dp)
                    .background(
                        Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                    ) //Redondear Fondo
                    .border(
                        6.dp,
                        Color.Cyan,
                        shape = RoundedCornerShape(16.dp)
                    )   //Redondear Bordes
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Start
            ){
                // 1ºBox
                Box(
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .background(Color.Red), //Redondear FondohorizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                    contentAlignment = Alignment.Center

                ){
                    Text(
                        "Text1",
                        color = Color.Blue, // Change text color to Blue
                        fontSize = 25.sp, // Increase font size
                        fontWeight = FontWeight.Bold, // Make text bold
                        modifier = Modifier
                            .padding(1.dp)
                            .padding(bottom = 40.dp)
                    )

                    // Add padding to position B below A
                    Text(
                        "Text2",
                        color = Color.Blue, // Change text color to Blue
                        fontSize = 25.sp, // Increase font size
                        fontWeight = FontWeight.Bold, // Make text bold
                        modifier = Modifier
                            .padding(1.dp)
                            .padding(top = 40.dp)
                    )

                }//Fin 1ºBox

                // 2ºBox
                Box(
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .background(Color.Black), //Redondear FondohorizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
                    contentAlignment = Alignment.Center

                ){
                    Text(
                        "Text3",
                        modifier = Modifier
                            .padding(1.dp)
                            .padding(bottom = 40.dp),
                        style = TextStyle(
                            color = Color.Red, // Text color
                            fontSize = 25.sp, // Font size
                            fontWeight = FontWeight.Bold, // Font weight
                            shadow = textShadow // Apply shadow
                        )

                    )

                    // Add padding to position B below A
                    Text(
                        "Text4",
                        modifier = Modifier
                            .padding(1.dp)
                            .padding(top = 40.dp),

                        style = TextStyle(
                            color = Color.Red, // Text color
                            fontSize = 25.sp, // Font size
                            fontWeight = FontWeight.Bold, // Font weight
                            shadow = textShadow // Apply shadow
                        )

                    )

                }//Fin 2ºBox

            }//Fin Box 3

            // Spacer to create space between the boxes
            Spacer(modifier = Modifier.height(40.dp)) // Adjust height for spacing

            //Row 3 con imagen
            Row(
                modifier = Modifier
                    .height(500.dp)
                    .width(700.dp)
                    .background(
                        Color.LightGray,
                        shape = RoundedCornerShape(40.dp)
                    ) //Redondear Fondo
                    .border(
                        9.dp,
                        Color.Black,
                        shape = RoundedCornerShape(40.dp)
                    )   //Redondear Bordes
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Start
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    LocalImage(modifier = Modifier.weight(1f))  // First image (local)
                    Spacer(modifier = Modifier.width(23.dp))  // Space between images
                    RemoteImage(modifier = Modifier.weight(1f)) // Second image (remote URL)
                }
            }//Fin 3ºRow

        }//Fin Columna1

    }//Fin Box1
}//Fin Ejercicio1

@Composable
fun LocalImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(100.dp), // Size for the local image
        contentAlignment = Alignment.TopStart
    ) {
        Image(
            painter = painterResource(id = R.drawable.ejemploimg), // Local resource image
            contentDescription = "Imagen desde recursos locales", // Description
            modifier = Modifier.fillMaxSize(), // Fill the available space
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun RemoteImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(150.dp), // Size for the remote image
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = rememberImagePainter(""), // Image from a URL
            contentDescription = "Imagen desde URL", // Description
            modifier = Modifier.fillMaxSize(), // Fill the available space
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
fun AsyncImage(model: String) {

}



// Preview nos permite ver las cosas de interfaz de usuario
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Intf_Peliculas1Theme {
        Ejercicio1("")
        /**
         * Column {
         *             Greeting("Pepe")
         *             BasicBoxExample("David")
         *             AdaptiveBoxSize("")
         *         }
         *         //BasicRow("")
         */
    }
}//Fin GreetingPreview