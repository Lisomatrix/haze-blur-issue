package pt.lisomatrix.haze

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.materials.CupertinoMaterials
import pt.lisomatrix.haze.ui.theme.HazeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val url = "https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg?crop=1.00xw:0.753xh;0,0.153xh&resize=1200:*"

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val hazeState = remember { HazeState() }

            HazeTheme {
                Scaffold(
                     modifier = Modifier
                        .fillMaxSize()
                        .hazeSource(hazeState)
                    ,
                    containerColor = Color.Cyan
                 ) { innerPadding ->

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                        ,
                    ) {


                        AsyncImage(
                            modifier = Modifier
                                .fillMaxSize()
                            ,
                            model = url,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                            ,
                            verticalArrangement = Arrangement.spacedBy(12.dp, alignment = Alignment.CenterVertically)
                        ) {
                            LazyRow(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(10, key = { it }) {
                                    SimpleBox(
                                        modifier = Modifier,
                                        hazeState
                                    )
                                }
                            }
                            LazyRow(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(10, key = { it }) {
                                    SimpleBox(
                                        modifier = Modifier,
                                        hazeState
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp)
                                    .clip(RoundedCornerShape(6.dp))
                                    .hazeEffect(hazeState, CupertinoMaterials.thick(Color.Red))
                                    .border(1.dp, Color.Black, RoundedCornerShape(6.dp))
                                ,
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "BOX",
                                    color = Color.White,
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun SimpleBox(
    modifier: Modifier = Modifier,
    hazeState: HazeState,
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .hazeEffect(hazeState, CupertinoMaterials.thick(Color.Red))
            .border(1.dp, Color.Black, RoundedCornerShape(6.dp))
            .size(
                80.dp
            )
        ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "BOX",
            color = Color.White,
        )
    }
}

