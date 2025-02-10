package ru.noxis.composeuitemplates.features.profile_ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import ru.noxis.composeuitemplates.R
import ru.noxis.composeuitemplates.features.profile_ui.data.ImageWithText
import ru.noxis.composeuitemplates.features.profile_ui.data.Posts
import ru.noxis.composeuitemplates.features.profile_ui.data.posts_list
import ru.noxis.composeuitemplates.features.profile_ui.data.tag_posts_list
import ru.noxis.composeuitemplates.ui.theme.ComposeUITemplatesTheme

@Composable
fun ProfileScreen(
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))
        Stats("Saturo Gojo", "10.1M", "100")
        Spacer(modifier = Modifier.height(16.dp))
        FeedComponent() {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostsComponent(
                postsList = posts_list,
                modifier = Modifier.fillMaxWidth()
            )

            1 -> PostsComponent(
                postsList = tag_posts_list,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun PostsComponent(
    postsList: List<Posts>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.scale(1.01f)
    ) {
        items(posts_list.size) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = posts_list[it].imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            crossfade(true)
                            placeholder(drawableResId = R.drawable.gojo)
                            scale(Scale.FILL)
                        }).build()
                ),
                contentDescription = posts_list[it].text,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}

@Composable
private fun FeedComponent(
    modifier: Modifier = Modifier,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    val imageWithText = listOf(
        ImageWithText(
            image = painterResource(id = R.drawable.ic_grid),
            text = "Posts"
        ),
        ImageWithText(
            image = painterResource(id = R.drawable.ic_instagram_tag),
            text = "Tags"
        )
    )
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedIndex,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(
                selected = selectedIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(18.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
private fun Stats(
    username: String,
    followers: String,
    following: String
) {
    val name_list = listOf(
        "hitenn24",
        "dishant___gandhi"
    )

    val otherCount = 3

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = username,
            style = MaterialTheme.typography.titleLarge,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed By ")
                name_list.forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if (index < name_list.size - 1) {
                        append(", ")
                    }
                }
                if (otherCount > 2) {
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            },
            letterSpacing = 0.5.sp,
            lineHeight = 20.sp,
            fontSize = 12.sp,
            color = Color.DarkGray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "7",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.DarkGray
                )
                Text(
                    text = "Posts",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            VerticalDivider(
                modifier = Modifier
                    .height(70.dp)
                    .width(1.dp)
                    .padding(top = 2.dp, bottom = 2.dp),
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = followers,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.DarkGray
                )
                Text(
                    text = "Followers",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.LightGray
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            VerticalDivider(
                modifier = Modifier
                    .height(70.dp)
                    .width(1.dp)
                    .padding(top = 2.dp, bottom = 2.dp),
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = following,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.DarkGray
                )
                Text(
                    text = "Following",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.LightGray
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            TextButton(
                colors = ButtonDefaults
                    .textButtonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xFFF94C84),
                    ),
                onClick = {},
                modifier = Modifier.weight(0.4f)
            ) {
                Text(
                    "Follow"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            TextButton(
                colors = ButtonDefaults
                    .textButtonColors(
                        containerColor = Color(0xFF2B2B2B),
                        contentColor = Color.White
                    ),
                onClick = {},
                modifier = Modifier.weight(0.4f)
            ) {
                Text(
                    "Message"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
private fun TopBar() {
    Column(
        modifier = Modifier
            .clickable(onClick = { })
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cover),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
                Box(
                    modifier = Modifier
                        .height(90.dp)
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                        .align(Alignment.BottomStart)
                )
            }
            ProfileImage(
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun ProfileImage(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    Surface(
        color = Color(0xFF17181F),
        shadowElevation = elevation,
        shape = RoundedCornerShape(40.dp),
        modifier = modifier,
        border = BorderStroke(
            3.dp,
            Brush.linearGradient(
                listOf(
                    Color(0xFFbc2a8d),
                    Color(0xFF8a3ab9)
                )
            )
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.gojo),
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(40.dp)),
            contentScale = ContentScale.Crop,
        )
    }
}


@PreviewLightDark
@Composable
fun ProfilePreview() {
    ComposeUITemplatesTheme {
        ProfileScreen()
    }
}