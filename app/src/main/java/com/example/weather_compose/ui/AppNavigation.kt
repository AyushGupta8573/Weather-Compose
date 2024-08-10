package com.example.weather_compose.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather_compose.ui.screens.WeatherScreen
import com.example.weather_compose.ui.screens.WeatherViewModel

enum class Screen(val route: String) {
    Home("home"),
    Setting("settings")
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val vm: WeatherViewModel = viewModel()
    val nc = rememberNavController()

    NavHost(navController = nc, startDestination = Screen.Home.route) {
        composable(Screen.Home.route){
            WeatherScreen(
                modifier = modifier,
                state = vm.state.collectAsState().value
            ){
                nc.navigate(Screen.Setting.route)
            }
        }
        composable(Screen.Setting.route){
            Text("Settings not available")
        }
    }
}