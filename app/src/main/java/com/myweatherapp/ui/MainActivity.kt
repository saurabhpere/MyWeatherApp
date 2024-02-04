package com.myweatherapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.myweatherapp.resource.extension.get
import com.myweatherapp.resource.extension.myAppPreferences
import com.myweatherapp.ui.feature.home.HomeScreen
import com.myweatherapp.ui.feature.home.HomeViewModel
import com.myweatherapp.ui.feature.registration.RegistrationScreen
import com.myweatherapp.ui.feature.login.LoginScreen
import com.myweatherapp.ui.feature.login.LoginViewModel
import com.myweatherapp.ui.feature.navigation.WeatherAppNavigation
import com.myweatherapp.ui.feature.registration.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val locationPermissionState = rememberMultiplePermissionsState(
                listOf( android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION)
            )
            WeatherAppTheme{
                Scaffold (containerColor = Color.LightGray){
                    it.calculateBottomPadding()
                    it.calculateTopPadding()

                    WeatherAppNavigation(navController, locationPermissionState)
                }
            }
        }
    }
}