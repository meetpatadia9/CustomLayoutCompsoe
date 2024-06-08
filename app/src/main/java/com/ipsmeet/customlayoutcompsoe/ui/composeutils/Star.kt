package com.ipsmeet.customlayoutcompsoe.ui.composeutils

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ipsmeet.customlayoutcompsoe.ui.theme.CustomLayoutCompsoeTheme

@Composable
fun Star(size: Dp) {
    Canvas(modifier = Modifier.size(size)) {
        val path = Path()
        // Star path definition using moveTo, lineTo etc.
        drawPath(path, color = Color.Yellow)
    }
}

@Preview
@Composable
private fun PreviewStar() {
    CustomLayoutCompsoeTheme {
        Star(size = 50.dp)
    }
}