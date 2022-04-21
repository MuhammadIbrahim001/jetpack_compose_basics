package com.example.learnjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class LearnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            weightTest()
        }
    }

}


@Composable
fun weightTest(){
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Box(modifier = Modifier
                .weight(50f)
                .background(color = Color.Red), contentAlignment = Alignment.Center){ Text(text = "a", textAlign = TextAlign.Center)}
            Box(modifier = Modifier
                .weight(25f)
                .background(color = Color.Yellow)){
                Text(text = "b")
            }
            
            Box(modifier = Modifier
                .weight(25f)
                .background(color = Color.Red)){
                Text(text = "c")
            }
            /*Text(text = "1", style = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold))
            Text(text = "Center")
            Text(text = "2")*/
        }


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Box(modifier = Modifier
                .weight(1f)
                ///.border(0.dp, color = Color.Blue, shape = RoundedCornerShape(2.dp))
                .background(color = Color.Red), contentAlignment = Alignment.Center){ Text(text = "a", textAlign = TextAlign.Center)}


            Box(modifier = Modifier
                .background(color = Color.Yellow)){
                Text(text = "abcdefdafc")
            }
            /*Text(text = "1", style = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold))
            Text(text = "Center")
            Text(text = "2")*/.5
        }
    }

}
@Composable
fun showButtons(){
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "1", style = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold))
            Text(text = "Center")
            Text(text = "2")
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "3",Modifier.clickable {

                Toast.makeText(context, "3", Toast.LENGTH_SHORT).show()
            })
            Text(text = "4")
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "5")
            Text(text = "6")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
            Text(text = "7")
            Text(text = "8")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "9")
            Text(text = "0")
        }
    }
}