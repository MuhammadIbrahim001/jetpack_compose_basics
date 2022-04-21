package com.example.learnjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var list = listOf<String>(
                "This",
                "is",
                "my",
                "first",
                "interection",
                "with",
                "Jetpack",
                "Compose"
            )
            val scaffoldState = rememberScaffoldState()
            val painter = painterResource(id = R.drawable.download)
            val description = "This is the description of the image"
            val title = "This is the description of the title"
            val textFiledState = remember {
                mutableStateOf("")
            }
            val color = remember {
                mutableStateOf(Color.Black)
            }

            LazyColumn() {
                itemsIndexed(list) { index: Int, item: String ->
                    Text(
                        text = item ,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()

                    )
                }
//                items(500) {
//                    Box(
//                        modifier = Modifier
//
//                            .fillMaxWidth(0.55f)
//                            .padding(20.dp), contentAlignment = Alignment.TopCenter
//                    ) {
//                        ImageCard(
//                            painter = painter,
//                            description = description,
//                            title = title + " " + it
//                        ) {
//                            color.value = it
//                        }
//                    }
//                    Text(
//                        text = "Item $it",
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .fillMaxWidth()
//
//                    )
//                }
            }
//            Scaffold(Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
//                Column() {
//                    Column(Modifier.background(color.value)) {
//                        Box(
//                            modifier = Modifier
//
//                                .fillMaxWidth(0.55f)
//                                .padding(20.dp), contentAlignment = Alignment.TopCenter
//                        ) {
//                            ImageCard(painter = painter, description = description, title = title) {
//                                color.value = it
//                            }
//                        }
//
//
//                    }
//                    Spacer(modifier = Modifier.height(15.dp))
//                    Column(
////                        horizontalAlignment = Alignment.CenterHorizontally,
////                        verticalArrangement = Arrangement.Center
//                        modifier = Modifier.padding(15.dp)
//                    ) {
//                        textField(textFiledState)
//                        Spacer(modifier = Modifier.height(15.dp))
//                        customButton(textFiledState, scaffoldState)
//                    }
//
//                }
//
//            }

        }

    }
}

@Composable
fun ImageCard(
    painter: Painter,
    description: String,
    title: String,
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,

        ) {
        Box(modifier = Modifier
            .height(250.dp)
            .clickable {
                updateColor(
                    Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat())
                )
            },
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,

                )
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            300f

                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Text(text = title, style = TextStyle(fontSize = 20.sp, color = Color.White))
            }
        }

    }


}

@Composable
fun textField(textFiledState: MutableState<String>) {
    TextField(value = textFiledState.value, label = {
        Text("Enter you name Name")
    }, onValueChange = {
        textFiledState.value = it
    })


}

@Composable
fun customButton(textFiledState: MutableState<String>, scaffoldState: ScaffoldState) {
    var scope = rememberCoroutineScope()
    Button(onClick = {
        scope.launch { scaffoldState.snackbarHostState.showSnackbar("Hello  ${textFiledState.value}") }
    })
    {
        Text(text = "Submit")
    }

}



