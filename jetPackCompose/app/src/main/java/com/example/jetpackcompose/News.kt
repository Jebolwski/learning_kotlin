@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.jetpackcompose

import android.R
import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

data class News(
    val id:Int,
    val text:String
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun News(navController: NavController, items:List<BottomNavigationItem>, selectedItem:Int){
    JetPackComposeTheme {
        var text by remember { mutableStateOf("") }
        var selectedItem = 1
        var index=0
        var arrayList: ArrayList<News> = arrayListOf()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Row (horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)) {
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Enter a news title") },
                        leadingIcon = { Icon(imageVector = Icons.Outlined.Newspaper, contentDescription = "News")}
                    )
                    IconButton(onClick = {
                        arrayList.add(News(id=index,text=text))
                        index++
                    }) {
                        Icon(
                            imageVector = Icons.Filled.AddBox,
                            contentDescription = "Add",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

                arrayList.forEachIndexed { index, item ->
                    ElevatedCard(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 28.dp, end = 28.dp, top = 15.dp),shape = RoundedCornerShape(15.dp)) {
                        Row {
                            Text(text = item.text, modifier = Modifier.padding(12.dp))
                            IconButton(onClick = {
                                var element = arrayList.find { news -> news.id==item.id }
                                arrayList.remove(element)
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Delete,
                                    contentDescription = "Delete",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }


                    }
                }

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedItem == index,
                                    onClick = {
                                        selectedItem = index
                                        navController.navigate(item.title)
                                    },
                                    label = {
                                        Text(text = item.title)
                                    },
                                    icon = {
                                        BadgedBox(
                                            badge = {
                                                if(item.badgeCount != null) {
                                                    Badge {
                                                        Text(text = item.badgeCount.toString())
                                                    }
                                                } else if(item.hasNews) {
                                                    Badge()
                                                }
                                            }
                                        ) {
                                            Icon(
                                                imageVector = if (index == selectedItem) {
                                                    item.selectedIcon
                                                } else item.unselectedIcon,
                                                contentDescription = item.title
                                            )
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) {
                }
            }



        }
    }
}

@Preview(showBackground = true)
@Composable
fun Page(){
    JetPackComposeTheme {
        var text by remember { mutableStateOf("") }
        var selectedItem = 1
        var arrayList: ArrayList<String> = arrayListOf()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Row (horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)) {
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Enter a news title") },
                        leadingIcon = { Icon(imageVector = Icons.Outlined.Newspaper, contentDescription = "News")}
                    )
                    IconButton(onClick = { arrayList.add(text)}) {
                        Icon(
                            imageVector = Icons.Filled.AddBox,
                            contentDescription = "Add",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
                ElevatedCard(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 28.dp, end = 28.dp, top = 15.dp),shape = RoundedCornerShape(15.dp)) {
                    arrayList.forEachIndexed { index, item ->
                        Text(text = item, modifier = Modifier.padding(12.dp))
                    }
                }
            }


        }
    }
}

