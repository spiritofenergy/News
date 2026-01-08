package com.kodex.news.data.repository

import com.kodex.news.domain.model.NewsItemApp
import kotlinx.datetime.LocalDateTime

class NewsRepository() {
    suspend fun loadNews(): List<NewsItemApp>{
       return listOf(
           NewsItemApp(
               id = "1",
               title = "Constructor",
               description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
               publishedBy = "Tech News Daily",
               publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
               imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
               isFavorite = false,
           ),
           NewsItemApp(
               id = "2",
               title = "Primary and Secondary Constructors in Kotlin",
               description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
               publishedBy = "Tech News Daily",
               publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
               imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
               isFavorite = false,
           ),
           NewsItemApp(
               id = "5",
               title = "Primary and Secondary Constructors in Kotlin",
               description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
               publishedBy = "Tech News Daily",
               publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
               imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
               isFavorite = false,
           ),
           NewsItemApp(
               id = "4",
               title = "Primary and Secondary Constructors in Kotlin",
               description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
               publishedBy = "Tech News Daily",
               publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
               imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
               isFavorite = false,
           ),
           NewsItemApp(
               id = "3",
               title = "Primary and Secondary Constructors in Kotlin",
               description = "Before starting, let’s think of a situation where you and your friend are walking on a road and somebody calls you by your name. What will you do? You will immediately turn back and respond. This is called Constructor . Here you are the class, with your name as the class name. Whenever someone calls you, with your name, you respond immediately. So, a Constructor is something that is called just after the creation of object i.e. whenever you are called by your name you will respond and this responding is the work that the constructor does.",
               publishedBy = "Tech News Daily",
               publishedAt = LocalDateTime(2026, 6, 15, 10, 0),
               imageUrl = "https://blog.mindorks.com/images/primary-secondary-const-kotlin-banner.png",
               isFavorite = false,
           ),
        )
    }
}