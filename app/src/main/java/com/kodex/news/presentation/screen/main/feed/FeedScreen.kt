package com.kodex.news.presentation.screen.main.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodex.news.R
import com.kodex.news.domain.model.ItemNews
import com.kodex.news.presentation.ui.component.NewsItem
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import kotlin.String

@Composable
fun FeedScreen() {
    var searchText by remember { mutableStateOf("") }
    val sampleNewsItem = listOf(
        ItemNews(
            id = "1",
            title = "Primary and Secondary Constructors in Kotlin",
            description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
            publishedBy = "Tech News Daily",
            publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
            imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
            isFavorite = false,
        ),
        ItemNews(
            id = "2",
            title = "Primary and Secondary Constructors in Kotlin",
            description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
            publishedBy = "Tech News Daily",
            publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
            imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
            isFavorite = false,
        ),
        ItemNews(
            id = "5",
            title = "Primary and Secondary Constructors in Kotlin",
            description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
            publishedBy = "Tech News Daily",
            publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
            imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
            isFavorite = false,
        ),
        ItemNews(
            id = "4",
            title = "Primary and Secondary Constructors in Kotlin",
            description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
            publishedBy = "Tech News Daily",
            publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
            imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
            isFavorite = false,
        ),
        ItemNews(
            id = "3",
            title = "Primary and Secondary Constructors in Kotlin",
            description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
            publishedBy = "Tech News Daily",
            publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
            imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
            isFavorite = false,
        ),

    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Поиск",
                    tint = Color.Gray
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search),
                    fontSize = 18.sp
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(sampleNewsItem){
                NewsItem(
                    modifier = Modifier.padding(top = 10.dp),
                    itemNews = it,
                    onFavoriteClicked = {},
                    onReadClicked = {},
                )
            }
        }
    }
}