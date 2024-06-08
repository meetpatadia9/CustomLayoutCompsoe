package com.ipsmeet.customlayoutcompsoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ipsmeet.customlayoutcompsoe.ui.theme.CustomLayoutCompsoeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomLayoutCompsoeTheme {

            }
        }
    }
}
