package com.example.navigationcompose.core.navigation

import android.app.FragmentManager.BackStackEntry
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.navigationcompose.DetailScreen
import com.example.navigationcompose.HomeScreen
import com.example.navigationcompose.LoginScreen
import com.example.navigationcompose.HomeScreen
import com.example.navigationcompose.SettingsScreen
import com.example.navigationcompose.core.navigation.type.createNavType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = Login){
        composable<Login> {
            LoginScreen{
                navController.navigate(Home)
            }
        }
        composable<Home> {
            HomeScreen{name -> navController.navigate(Detail(name = name))}
        }

        composable<Detail> {
            val detail = it.toRoute<Detail>()
            DetailScreen(detail.name,
                navigateBack = {navController.navigateUp()},
                navigateToSettings = { navController.navigate(Settings(it))})
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingsInfo>() to createNavType<SettingsInfo>())) { backStackEntry ->
            val settings:Settings = backStackEntry.toRoute()
            SettingsScreen(settings.info)
        }
    }
}