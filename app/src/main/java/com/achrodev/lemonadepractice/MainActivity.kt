package com.achrodev.lemonadepractice

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.achrodev.lemonadepractice.ui.theme.LemonadePracticeTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadePracticeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
        LemonadeScene(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        )
}


@Composable
fun LemonadeScene(modifier: Modifier = Modifier) {

    // Observes the state in which the result for the lemon squeeze will cause for a full glass
    var result by remember {
        mutableStateOf(1)
    }

    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        else -> R.drawable.lemon_squeeze
    }

    // Row for the header
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        ) {
        Color(0xFFFF0000)

    }

    // Column for the structure of the apps UI
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { result = (2..4).random() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFd2e8d4)),

        ) {
            Image(painter = painterResource(imageResource),
                contentDescription = stringResource(R.string.tree))
        }
    Spacer(
        modifier = Modifier.height(24.dp)
    )
    Text(stringResource(R.string.tree)
        , fontSize = 18.sp

        )


    }
}
