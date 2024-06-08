package com.ipsmeet.customlayoutcompsoe.ui.composeutils

import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBarWithText(
    modifier: Modifier = Modifier,
    progress: Float,
    color: Color = Color.Green,
    backgroundColor: Color = Color.LightGray,
    strokeWidth: Float = 15f,
    textSize: Float = 24f,
    textColor: Color = Color.Black
) {

    val animatedProgress by animateFloatAsState(targetValue = progress, label = "")

    Box(
        modifier = modifier
            .size(100.dp)
            .padding(5.dp)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val diameter = size.minDimension

            // Draw background arc
            drawArc(
                color = backgroundColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                topLeft = Offset.Zero,
                size = Size(diameter, diameter),
                style = Stroke(width = strokeWidth)
            )

            // Draw progress arc
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * animatedProgress,
                useCenter = false,
                topLeft = Offset.Zero,
                size = Size(diameter, diameter),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }

        BasicText(
            text = "${(animatedProgress * 100).toInt()}%",
            style = TextStyle(
                color = textColor,
                fontSize = textSize.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressBarWithTextPreview() {



    CircularProgressBarWithText(
        progress = 0.1f,
        modifier = Modifier.size(100.dp),
        /*color = Color.Blue,
        backgroundColor = Color.LightGray,
        strokeWidth = 8f,*/
        textSize = 24f,
        textColor = Color.Black
    )
}