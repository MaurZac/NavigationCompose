package com.example.navigationcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.navigationcompose.core.navigation.SettingsInfo


@Composable
fun SettingsScreen(settingsInfo:  SettingsInfo){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Settings Screen", fontSize = 25.sp)
        Text(text = settingsInfo.name)
        Text(text = settingsInfo.id.toString())
        Text(text = settingsInfo.darkMode.toString())
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.weight(1f))
    }
}