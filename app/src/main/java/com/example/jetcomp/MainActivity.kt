package com.example.jetcomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.jetcomp.ui.theme.JetCompTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetCompTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding: PaddingValues ->
        Column {
            Greeting(
                name = "Android",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding),

                )
            LineBorder()
            Line()
            Spacer(
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
            LineColor()
            Check()
        }
    }
}

@Preview
@Composable
fun Line() {
    Row(
        verticalAlignment = CenterVertically,
        modifier = Modifier
            .background(Color.Gray)
            .padding(12.dp)

    ) {
        Text(text = "Left", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Right", fontSize = 20.sp)
    }
}

@Preview
@Composable
fun LineColor() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(16.dp)
            .background(
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Yellow, Color.Green)),
                shape = RoundedCornerShape(8.dp)
            )

    ) {}
}

@Preview
@Composable
fun LineBorder() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .height(120.dp)
            .background(color = Color.Cyan, shape = RoundedCornerShape(16.dp))
            .border(
                width = 8.dp,
                brush = Brush.linearGradient(colors = listOf(Color.Cyan, Color.Yellow, Color.Blue)),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
            modifier = Modifier.padding(8.dp),
            model = "https://developer.android.com/images/android-go/next-billion-users_856.png",
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview
@Composable
fun Check() {
    Row(verticalAlignment = CenterVertically) {
        Checkbox(checked = true, onCheckedChange = {})
        Text("Some checkbox text", fontSize = 18.sp)
    }
}

@Composable
fun ClickCounter(
    counterValue: Int,
    onCounterClick: () -> Unit
) {
    val evenOdd = EvenOdd()
    Text(
        text = "Clicks: $counterValue ${evenOdd.check(counterValue)}",
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
}

class EvenOdd() {
    fun check(value: Int): String {
        return if (value % 2 == 0) "even" else "odd"
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(8.dp)
            .height(IntrinsicSize.Min) // Ограничиваем высоту Row
        ,
        verticalAlignment = CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(Color.Cyan, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .height(IntrinsicSize.Min),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "N",
                    fontSize = 30.sp
                )
                Text(
                    text = "ame",
                    fontSize = 12.sp
                )
            }
        }
        Text(
            text = "Hello $name!",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.Yellow,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxHeight() // Растягиваем Text по высоте внутри Row
                .fillMaxWidth()
                .wrapContentHeight(CenterVertically) // Выравниваем текст по центру вертикально
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetCompTheme {
        Greeting("Android")
    }
}

