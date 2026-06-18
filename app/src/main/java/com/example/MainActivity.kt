package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.ViewList
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme(dynamicColor = false) {
        MainScreen()
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
  Scaffold(
    containerColor = Color(0xFFF9FAFA),
    topBar = {
      TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Color(0xFFF9FAFA)
        ),
        title = {
          Row(verticalAlignment = Alignment.CenterVertically) {
            // Logo placeholder
            Box(
              modifier = Modifier
                .size(32.dp)
                .background(Color.Yellow.copy(alpha = 0.2f), CircleShape),
              contentAlignment = Alignment.Center
            ) {
              Text("🌸", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              "কাঠগোলাপ",
              color = Color(0xFF1E4064),
              fontWeight = FontWeight.Bold,
              fontSize = 20.sp
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = {}) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
          }
        },
        actions = {
          IconButton(onClick = {}) {
            Icon(Icons.Default.Palette, contentDescription = "Theme", tint = Color.DarkGray)
          }
          IconButton(onClick = {}) {
            Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.DarkGray)
          }
        }
      )
    },
    bottomBar = {
      NavigationBar(
        containerColor = Color(0xFFF9FAFA),
        tonalElevation = 0.dp
      ) {
        NavigationBarItem(
          selected = true,
          onClick = { },
          icon = { Icon(Icons.Filled.Home, contentDescription = "হোম") },
          label = { Text("হোম", fontWeight = FontWeight.Bold) },
          colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color(0xFF1E4064),
            selectedTextColor = Color(0xFF1E4064),
            indicatorColor = Color(0xFFE2E8F0),
            unselectedIconColor = Color.DarkGray,
            unselectedTextColor = Color.DarkGray
          )
        )
        NavigationBarItem(
          selected = false,
          onClick = { },
          icon = { Icon(Icons.Outlined.ViewList, contentDescription = "ক্যাটাগরি") },
          label = { Text("ক্যাটাগরি") },
          colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.DarkGray,
            unselectedTextColor = Color.DarkGray
          )
        )
        NavigationBarItem(
          selected = false,
          onClick = { },
          icon = { Icon(Icons.Outlined.LibraryBooks, contentDescription = "লাইব্রেরি") },
          label = { Text("লাইব্রেরি") },
          colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.DarkGray,
            unselectedTextColor = Color.DarkGray
          )
        )
      }
    }
  ) { innerPadding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
        .verticalScroll(rememberScrollState())
    ) {
      SectionHeader(title = "Featured Novels", actionText = "সব দেখুন")
      FeaturedSection()

      Spacer(modifier = Modifier.height(16.dp))

      SectionHeader(title = "Recently Added", actionText = "সব দেখুন")
      LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        item {
          NovelCard(
            title = "আমার তোকেই লাগবে",
            author = "Nadiya Noor",
            views = "2.3K",
            status = "চলমান",
            imageUrl = "https://images.unsplash.com/photo-1544947950-fa07a98d237f?q=80&w=200&auto=format&fit=crop"
          )
        }
        item {
          NovelCard(
            title = "শেষ চৈত্রের ঘ্রাণ",
            author = "অজানা",
            views = "1K",
            status = "চলমান",
            imageUrl = "https://images.unsplash.com/photo-1512820790803-83ca734da794?q=80&w=200&auto=format&fit=crop"
          )
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      SectionHeader(title = "Most Popular", actionText = "সব দেখুন")
      LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        item {
          NovelCard(
            title = "এমপি তামিম সরকার",
            author = "কায়েনাত খান কবিতা",
            views = "1M",
            status = "চলমান",
            isPremium = true,
            imageUrl = "https://images.unsplash.com/photo-1589829085413-56de8ae18c73?q=80&w=200&auto=format&fit=crop"
          )
        }
        item {
          NovelCard(
            title = "শেষ চৈত্রের ঘ্রাণ",
            author = "নূরজাহান আকতার আলো",
            views = "500K",
            status = "চলমান",
            imageUrl = "https://images.unsplash.com/photo-1512820790803-83ca734da794?q=80&w=200&auto=format&fit=crop"
          )
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      SectionHeader(title = "Weekly Popular", actionText = "সব দেখুন")
      LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        item {
          NovelCard(
            title = "এমপি তামিম সরকার",
            author = "কায়েনাত খান কবিতা",
            views = "1M",
            status = "চলমান",
            isPremium = true,
            imageUrl = "https://images.unsplash.com/photo-1589829085413-56de8ae18c73?q=80&w=200&auto=format&fit=crop"
          )
        }
      }
      
      Spacer(modifier = Modifier.height(32.dp))
    }
  }
}

@Composable
fun SectionHeader(title: String, actionText: String) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 8.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = title,
      fontWeight = FontWeight.SemiBold,
      fontSize = 18.sp,
      color = Color(0xFF1E293B)
    )
    TextButton(onClick = { }, contentPadding = PaddingValues(0.dp)) {
      Text(
        text = actionText,
        color = Color(0xFF1E4064),
        fontSize = 14.sp
      )
    }
  }
}

@Composable
fun FeaturedSection() {
  LazyRow(
    contentPadding = PaddingValues(horizontal = 16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    item {
      Box(
        modifier = Modifier
          .width(320.dp)
          .height(200.dp)
          .clip(RoundedCornerShape(16.dp))
          .background(Color(0xFF3F5553))
      ) {
        Row(
          modifier = Modifier.fillMaxSize(),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Box(
            modifier = Modifier
              .weight(1f)
              .padding(start = 16.dp)
          ) {
            AsyncImage(
              model = "https://images.unsplash.com/photo-1544947950-fa07a98d237f?q=80&w=200&auto=format&fit=crop",
              contentDescription = "Book Cover",
              contentScale = ContentScale.Crop,
              modifier = Modifier
                .width(90.dp)
                .height(130.dp)
                .graphicsLayer {
                  rotationZ = -5f
                }
                .border(2.dp, Color.White.copy(alpha = 0.5f), RoundedCornerShape(4.dp))
                .clip(RoundedCornerShape(4.dp))
            )
          }
          Column(
            modifier = Modifier
              .weight(1f)
              .padding(end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
          ) {
            Text(
              text = "প্রিয় প্রণয়িনী",
              color = Color.White,
              fontWeight = FontWeight.Bold,
              fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = "জান্নাত নুসরাত",
              color = Color.White.copy(alpha = 0.8f),
              fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
              onClick = { },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2B5C82)),
              shape = RoundedCornerShape(24.dp)
            ) {
              Text("পড়ুন", color = Color.White)
            }
          }
        }
      }
    }
  }
}

@Composable
fun NovelCard(
  title: String,
  author: String,
  views: String,
  status: String,
  imageUrl: String,
  isPremium: Boolean = false,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier.width(300.dp),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)
    ) {
      Box(
        modifier = Modifier
          .fillMaxHeight()
          .width(100.dp)
      ) {
        AsyncImage(
          model = imageUrl,
          contentDescription = title,
          contentScale = ContentScale.Crop,
          modifier = Modifier.fillMaxSize()
        )
        if (isPremium) {
          Box(
            modifier = Modifier
              .align(Alignment.TopEnd)
              .background(
                Color(0xFFFFB800),
                RoundedCornerShape(bottomStart = 8.dp)
              )
              .padding(horizontal = 6.dp, vertical = 2.dp)
          ) {
            Text("PREMIUM", fontSize = 8.sp, fontWeight = FontWeight.Bold, color = Color.Black)
          }
        }
        Box(
          modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(4.dp)
            .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(4.dp))
            .padding(horizontal = 4.dp, vertical = 2.dp)
        ) {
          Text(status, color = Color.White, fontSize = 9.sp)
        }
      }
      Column(
        modifier = Modifier
          .weight(1f)
          .padding(12.dp)
      ) {
        Text(
          text = title,
          fontWeight = FontWeight.Bold,
          fontSize = 15.sp,
          color = Color.Black,
          maxLines = 1
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
          val infiniteTransition = rememberInfiniteTransition()
          val scale by infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = 1.2f,
            animationSpec = infiniteRepeatable(
              animation = tween(800, easing = FastOutSlowInEasing),
              repeatMode = RepeatMode.Reverse
            )
          )

          Icon(
            Icons.Filled.Verified,
            contentDescription = "Verified",
            tint = Color(0xFF1A66D2),
            modifier = Modifier
              .size(14.dp)
              .scale(scale)
          )
          Spacer(modifier = Modifier.width(4.dp))
          Text(
            text = author,
            fontSize = 12.sp,
            color = Color.Gray,
            maxLines = 1
          )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(
            Icons.Outlined.RemoveRedEye,
            contentDescription = "Views",
            modifier = Modifier.size(14.dp),
            tint = Color.Gray
          )
          Spacer(modifier = Modifier.width(4.dp))
          Text(text = views, fontSize = 12.sp, color = Color.Black)
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
          onClick = { },
          modifier = Modifier.height(32.dp),
          contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFE2E8F0),
            contentColor = Color.Black
          ),
          shape = RoundedCornerShape(16.dp)
        ) {
          // Icon for book inside the button
          Icon(
            Icons.Outlined.LibraryBooks,
            contentDescription = null,
            modifier = Modifier.size(14.dp)
          )
          Spacer(modifier = Modifier.width(4.dp))
          Text("পড়ুন", fontSize = 12.sp)
        }
      }
    }
  }
}

