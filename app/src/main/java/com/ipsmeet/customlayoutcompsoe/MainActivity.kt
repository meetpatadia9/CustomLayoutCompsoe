package com.ipsmeet.customlayoutcompsoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ipsmeet.customlayoutcompsoe.ui.composeutils.CircularProgressBarWithText
import com.ipsmeet.customlayoutcompsoe.ui.theme.CustomLayoutCompsoeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var progressValue by remember {
                mutableFloatStateOf(0f)
            }

            LaunchedEffect(Unit) {
                while (true) {
                    for (i in 0..100) {
                        progressValue = i / 100f
                        delay(100)
                    }
                }
            }

            CustomLayoutCompsoeTheme {
                CircularProgressBarWithText(
                    progress = progressValue,
                    modifier = Modifier.size(100.dp),
                    textSize = 24f,
                    textColor = Color.Black
                )
            }
        }
    }
}
