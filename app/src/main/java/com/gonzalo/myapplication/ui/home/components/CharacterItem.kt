package com.gonzalo.myapplication.ui.home.components

import android.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.gonzalo.myapplication.domain.model.Characters
import com.gonzalo.myapplication.ui.theme.Dimen120dp
import com.gonzalo.myapplication.ui.theme.Dimen16dp
import com.gonzalo.myapplication.ui.theme.Dimen1dp
import com.gonzalo.myapplication.ui.theme.Dimen200dp
import com.gonzalo.myapplication.ui.theme.Dimen24dp
import com.gonzalo.myapplication.ui.theme.Dimen2dp
import com.gonzalo.myapplication.ui.theme.Dimen4dp
import com.gonzalo.myapplication.ui.theme.Dimen8dp

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    item: Characters,
    onItemClicked: (Int) -> Unit,
) {

    Card(
        modifier = Modifier.padding(Dimen16dp).height(Dimen200dp),
        backgroundColor = White,
        shape = RoundedCornerShape(Dimen8dp),
        elevation = Dimen1dp,
        border = BorderStroke(Dimen1dp, LightGray)
    ) {
        Column(
            modifier = modifier
                .clickable { onItemClicked(item.id) }
                .padding(top = Dimen24dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CharacterImageContainer(modifier = Modifier.size(Dimen120dp)) {
                CharacterImage(item)
            }
            Spacer(Modifier.height(Dimen16dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = Dimen2dp),
                    text = item.name,
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Gray
                )

            }

        }
    }


}


@Composable
fun CharacterImage(item: Characters) {
    Box {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.image)
                .size(Size.ORIGINAL)
                .build()
        )
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun CharacterImageContainer(
    modifier: Modifier,
    content: @Composable () -> Unit,
) {
    Surface(modifier.aspectRatio(1f), RoundedCornerShape(Dimen4dp)) {
        content()
    }
}
