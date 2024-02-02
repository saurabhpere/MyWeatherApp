package com.myweatherapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myweatherapp.resource.extension.get
import com.myweatherapp.resource.extension.myAppPreferences
import com.myweatherapp.ui.feature.home.HomeScreen
import com.myweatherapp.ui.feature.home.HomeViewModel
import com.myweatherapp.ui.feature.registration.RegistrationScreen
import com.myweatherapp.ui.feature.login.LoginScreen
import com.myweatherapp.ui.feature.login.LoginViewModel
import com.myweatherapp.ui.feature.registration.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WeatherAppTheme{
                Scaffold (Modifier.padding(16.dp)){
                    it.calculateBottomPadding()
                    it.calculateTopPadding()

                    WeatherAppNavigation(navController)
                }
            }
        }
    }
}

@Composable
fun WeatherAppNavigation(navController: NavHostController) {
    val context = LocalContext.current
    NavHost(navController, startDestination = if (context.myAppPreferences.get("loggedin", false))"home" else "login") {
        composable(route = "login") {
            LoginScreen(navController, hiltViewModel<LoginViewModel>())
        }
        composable(route = "registration") {
            RegistrationScreen(navController, hiltViewModel<RegistrationViewModel>())
        }

        composable(route = "home") {
            HomeScreen(hiltViewModel<HomeViewModel>())
        }
    }
}