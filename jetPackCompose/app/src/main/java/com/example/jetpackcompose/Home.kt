package com.example.jetpackcompose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DoNotDisturbOnTotalSilence
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController,items:List<BottomNavigationItem>,selectedItem:Int){
    JetPackComposeTheme {
        var selectedItem = 0
        val windowInfo = RememberWindowInfo()
        println(windowInfo.screenHeightInfo.toString()+ "messi")
        if (windowInfo.screenHeightInfo is WindowInfo.WindowType.Expanded){
            Text("Expanded")
        }
        else if (windowInfo.screenHeightInfo is WindowInfo.WindowType.Medium){
            Text("Medium")
        }else{
            Text("Compact")
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Row{
                    Image(painter = painterResource(id = R.drawable.business), contentDescription = "Image")
                    Column {
                        Text(text = "Photography")
                        Row {
                            Icon(imageVector = Icons.Outlined.DoNotDisturbOnTotalSilence, contentDescription = "Dots")
                            Text(text = "321")
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
                                        MainActivity.selectedItem = index
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

@Preview()
@Composable
fun Prev(){
    Row(modifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .background(Color(0xEBEBEBEB))){
        Image(painter = painterResource(id = R.drawable.business), contentDescription = "Image", modifier = Modifier.size(68.dp))
        Column(modifier=Modifier.padding(start=16.dp,end=16.dp,top=16.dp),
            verticalArrangement = Arrangement.Center) {
            Text(text = "Photography")
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top=8.dp)) {
                Icon(imageVector = Icons.Outlined.Inbox, contentDescription = "Dots", modifier = Modifier.size(15.dp))
                Text(text = "321",modifier=Modifier.padding(start=8.dp), fontSize = 10.sp)
            }
        }
    }
}