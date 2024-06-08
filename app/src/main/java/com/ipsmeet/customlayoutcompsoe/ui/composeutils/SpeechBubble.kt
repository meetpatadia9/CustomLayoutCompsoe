package com.ipsmeet.customlayoutcompsoe.ui.composeutils

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ipsmeet.customlayoutcompsoe.ui.theme.CustomLayoutCompsoeTheme

@Composable
fun SpeechBubble(text: String, modifier: Modifier = Modifier) {
    val cornerRadius = 16.dp
    val bubbleColor = Color.LightGray
    val textColor = Color.Black
    val tailWidth = 20.dp
    val tailHeight = 30.dp

    Canvas(modifier = modifier.background(Color.Transparent)) {
        val path = Path()
        val width = size.width
        val height = size.height

        // Draw rounded rectangle
        path.apply {
            moveTo(cornerRadius.toPx(), 0f)
            lineTo(width - cornerRadius.toPx(), 0f)
            arcTo(
                rect = Rect(
                    left = width - cornerRadius.toPx() * 2,
                    top = 0f,
                    right = width,
                    bottom = cornerRadius.toPx() * 2
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(width, height - cornerRadius.toPx())
            arcTo(
                rect = Rect(
                    left = width - cornerRadius.toPx() * 2,
                    top = height - cornerRadius.toPx() * 2,
                    right = width,
                    bottom = height
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(cornerRadius.toPx(), height)
            arcTo(
                rect = Rect(
                    left = -4f,
                    top = height - cornerRadius.toPx() * 2,
                    right = cornerRadius.toPx() * 2,
                    bottom = height
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(0f, cornerRadius.toPx())
            arcTo(
                rect = Rect(
                    left = -4f,
                    top = 0f,
                    right = cornerRadius.toPx() * 2,
                    bottom = cornerRadius.toPx() * 2
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            close()
        }

        // Draw path
        drawPath(path, bubbleColor)

        // Draw tail
        val tailPath = Path().apply {
            moveTo(width - tailWidth.toPx() - cornerRadius.toPx(), height / 2f - tailHeight.toPx() / 2f)
            lineTo(width - cornerRadius.toPx(), height / 2f)
            lineTo(width - tailWidth.toPx() - cornerRadius.toPx(), height / 2f + tailHeight.toPx() / 2f)
            close()
        }
        drawPath(tailPath, bubbleColor)

        // Draw text
        drawIntoCanvas { canvas ->
            val textPaint = androidx.compose.ui.graphics.Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                color = textColor.toArgb()
                textSize = 16.sp.toPx()
            }

            val textWidth = textPaint.measureText(text)
            val textHeight = textPaint.fontMetrics.run { descent - ascent }

            canvas.nativeCanvas.drawText(
                text,
                (width - textWidth) / 2,
                (height + textHeight) / 2 - textPaint.fontMetrics.descent,
                textPaint
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSpeechBubble() {
    CustomLayoutCompsoeTheme {
        SpeechBubble(
            text = "Hello, world!",
            modifier = Modifier.fillMaxWidth().height(20.dp)
        )
    }
}