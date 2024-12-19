package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                PictureView()
            }
        }
    }
}

@Composable
fun PictureView() {
    val picture = listOf(
        R.drawable.alisa1 to "I was trying new styles",
        R.drawable.alisa2 to "I can imagine i could sit",
        R.drawable.alisa3 to "What was I the one",
        R.drawable.alisa4 to "Does this carpet still exists",
        R.drawable.alisa5 to "Mummy with this smile",
        R.drawable.alisa6 to "I could fit in mummy's hands",
        R.drawable.alisa7 to "I bet I couldn't stand on my own",
        R.drawable.alisa8 to "I remember I had Rajjab",
        R.drawable.alisa9 to "Haha thanks for me grow"
    )
    var currentImageIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(modifier = Modifier.fillMaxWidth(.9f)) {
            Image(
                painter = painterResource(picture[currentImageIndex].first),
                contentDescription = "Image",
                modifier = Modifier.fillMaxWidth(),
            )
        }
        Spacer(modifier = Modifier.height(80.dp)) // Use Spacer for consistent spacing
        Card(modifier = Modifier.fillMaxWidth(.9f)) {
            Text(
                text = picture[currentImageIndex].second,
                modifier = Modifier.padding(16.dp),
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Column {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(
                    onClick = {
                        currentImageIndex = (currentImageIndex - 1 + picture.size) % picture.size
                    }) {
                    Text("Previous")
                }
                Button(
                    onClick = { currentImageIndex = (currentImageIndex + 1) % picture.size }
                ) {
                    Text("Next")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewForPictures() {
    PictureView()
}