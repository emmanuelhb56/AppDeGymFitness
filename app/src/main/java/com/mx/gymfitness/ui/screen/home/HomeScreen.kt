package com.mx.gymfitness.ui.screen.home

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mx.gymfitness.R
import com.mx.gymfitness.data.SquatViewModel
import com.mx.gymfitness.data.persistencia.Usuario
import com.mx.gymfitness.ui.screen.buttom_bar.Items_menu
import com.mx.gymfitness.ui.screen.buttom_bar.NavigationHost

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController, viewModel: SquatViewModel) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    val navigation_item = listOf(
        Items_menu.Pantalla1,
        Items_menu.Pantalla2,
        Items_menu.Pantalla3
    )

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { NavegacionInferior(navController,navigation_item)},
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(15.dp),
                elevation = 0.dp,
                backgroundColor = Color.White,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(65.dp)
                            .clip(shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = " Profile picture",
                            contentScale = ContentScale.Fit
                        )
                    }

                    Text(buildAnnotatedString {
                        append("Hola, ")
                        withStyle(
                            style = SpanStyle(
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        ) {
                            append("Usuario1231")
                        }
                    }, modifier = Modifier.padding(start = 10.dp))

                    Spacer(modifier = Modifier.weight(1f))

                    /*BadgedBox(modifier = Modifier.padding(end = 10.dp),
                        badge = {
                            Badge(
                                Modifier
                                    .clip(CircleShape)
                                    .background(Color.Red)
                                    .align(Alignment.BottomEnd)
                            )
                        }) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "notification icon",
                            tint = Color.Black
                        )
                    }*/
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = Color.Black,
                onClick = {
                navController.navigate("Usuario")
            }) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Usuario",
                    tint = Color.White
                )
            }
        },
        isFloatingActionButtonDocked = true
    ){
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            //color = Color.Black
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavigationHost(viewModel= viewModel,navController= navController)
            }
        }
    }
}


@Composable
fun currentRoute(navController: NavHostController): String?{
    val entrada by navController.currentBackStackEntryAsState()
    return entrada?.destination?.route
}

@Composable
fun NavegacionInferior(
    navController: NavHostController,
    menu_items: List<Items_menu>) {
    BottomAppBar(
        modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        elevation = 5.dp,
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        ),
        backgroundColor = Color.Black
    ) {
        BottomNavigation(
            modifier = Modifier.padding(
                0.dp,0.dp,60.dp,0.dp
            ),
            backgroundColor = Color.Black
        ) {
            val currentRoute = currentRoute(navController = navController)
            menu_items.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.ruta,
                    onClick = {navController.navigate(item.ruta)},
                    icon = {
                        Icon(
                            painter = painterResource(id = item.Icon),
                            contentDescription = item.title,
                            tint = Color.White
                        )
                    },
                    label = {Text(item.title, color = Color.White)},
                    alwaysShowLabel = false
                )
            }
        }
    }
}

