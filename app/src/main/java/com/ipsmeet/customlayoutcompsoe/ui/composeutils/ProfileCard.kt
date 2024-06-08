package com.ipsmeet.customlayoutcompsoe.ui.composeutils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ipsmeet.customlayoutcompsoe.R
import com.ipsmeet.customlayoutcompsoe.ui.theme.CustomLayoutCompsoeTheme

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    profilePicture: ImageBitmap,
    name: String,
    title: String,
    bio: String
) {
    Surface(
        modifier = modifier
            .padding(16.dp)
            .background(Color.White)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = CircleShape,
        shadowElevation = 4.dp
    ) {
        CustomLayout(
            profilePicture = profilePicture,
            name = name,
            title = title,
            bio = bio
        )
    }
}

@Composable
fun CustomLayout(
    profilePicture: ImageBitmap,
    name: String,
    title: String,
    bio: String
) {
    Layout(
        content = {
            Image(
                bitmap = profilePicture,
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .layoutId("profilePicture")
            )
            BasicText(
                text = name,
                style = TextStyle(fontSize = 20.sp, color = Color.Black),
                modifier = Modifier.layoutId("name")
            )
            BasicText(
                text = title,
                style = TextStyle(fontSize = 16.sp, color = Color.Gray),
                modifier = Modifier.layoutId("title")
            )
            BasicText(
                text = bio,
                style = TextStyle(fontSize = 14.sp, color = Color.Black),
                modifier = Modifier.layoutId("bio")
            )
        },
        measurePolicy = { measurables, constraints ->
            // Measure children
            val profilePicturePlaceable =
                measurables.first { it.layoutId == "profilePicture" }.measure(constraints)
            val namePlaceable = measurables.first { it.layoutId == "name" }.measure(constraints)
            val titlePlaceable = measurables.first { it.layoutId == "title" }.measure(constraints)
            val bioPlaceable = measurables.first { it.layoutId == "bio" }.measure(constraints)

            // Define the layout size
            val layoutWidth = constraints.maxWidth
            val layoutHeight =
                profilePicturePlaceable.height + namePlaceable.height + titlePlaceable.height + bioPlaceable.height + 32.dp.toPx()
                    .toInt()

            // Place children
            layout(layoutWidth, layoutHeight) {
                var yPosition = 16.dp.toPx().toInt()

                profilePicturePlaceable.placeRelative(16.dp.toPx().toInt(), yPosition)
                yPosition += profilePicturePlaceable.height + 16.dp.toPx().toInt()

                namePlaceable.placeRelative(16.dp.toPx().toInt(), yPosition)
                yPosition += namePlaceable.height

                titlePlaceable.placeRelative(16.dp.toPx().toInt(), yPosition)
                yPosition += titlePlaceable.height

                bioPlaceable.placeRelative(16.dp.toPx().toInt(), yPosition)
            }
        }
    )
}
/*@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    profilePicture: ImageBitmap,
    name: String,
    title: String,
    bio: String
) {
    Surface(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    bitmap = profilePicture,
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    BasicText(
                        text = name,
                        style = TextStyle(fontSize = 20.sp, color = Color.Black)
                    )
                    BasicText(
                        text = title,
                        style = TextStyle(fontSize = 16.sp, color = Color.Gray)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            BasicText(
                text = bio,
                style = TextStyle(fontSize = 14.sp, color = Color.Black)
            )
        }
    }
}*/

@Preview
@Composable
private fun PreviewProfileCard() {
    CustomLayoutCompsoeTheme {
        val image = ImageBitmap.imageResource(id = R.drawable.profile_picture)
        ProfileCard(
            profilePicture = image,
            name = "Meet Patadia",
            title = "Android Developer",
            bio = "Passionate about creating interactive and user-friendly applications. Always eager to learn new technologies and improve coding skills."
        )
    }
}
