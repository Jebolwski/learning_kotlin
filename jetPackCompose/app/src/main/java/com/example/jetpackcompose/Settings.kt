package com.example.jetpackcompose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TipsAndUpdates
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Money
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavController,items:List<BottomNavigationItem>,selectedItem:Int){
    JetPackComposeTheme {
        var selectedItem = 2
        var text by remember {
            mutableStateOf(0.0)
        }
        var check by remember {
            mutableStateOf(false)
        }
        var percentage by remember {
            mutableStateOf(0.0)
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                val windowInfo = RememberWindowInfo()
                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Expanded){
                    NavigationRail {
                        items.forEachIndexed { index, item ->
                            NavigationRailItem(
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
                                            imageVector =
                                            if (index == selectedItem) item.selectedIcon else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
                else if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Medium){
                    Text("Medium")
                }else{
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
                                                    imageVector =
                                                    if (index == selectedItem) item.selectedIcon else item.unselectedIcon,
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
                /*Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)) {

                    TextField(value = text.toString(),
                        onValueChange = {text=it.toDouble()},label = { Text("Enter money") },
                        leadingIcon = { Icon(imageVector = Icons.Filled.Money, contentDescription = "Money")})

                    TextField(value = percentage.toString(),
                        onValueChange = {percentage=it.toDouble()},label = { Text("Tip percentage") },
                        leadingIcon = { Icon(imageVector = Icons.Filled.More, contentDescription = "Money")},
                        modifier = Modifier.padding(top = 15.dp))

                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(30.dp)) {
                        Text(text = "Round up tip?",fontSize=20.sp,
                            modifier = Modifier.padding(top=15.dp))
                        Switch(checked = check, onCheckedChange = {check=it})
                    }

                    var x:String="Tip amount : $"+((text*15.0)/100).toString().format(2)
                    if (check){
                        x="Tip amount : $"+((text*percentage)/100.0).toString().format(2)
                    }

                    Text(text = x,fontSize=24.sp,
                        modifier = Modifier.padding(top=15.dp))

                    var res:String="Total amount : $"+((text.toDouble()+(text.toDouble()*15)/100.0)).toString().format(2)
                    if (check){
                        res="Total amount : $"+((text.toDouble()+(text.toDouble()*percentage)/100.0)).toString().format(2)
                    }

                    Text(text = res,fontSize=24.sp,
                        modifier = Modifier.padding(top=15.dp))

                }*/


            }

        }
    }
}