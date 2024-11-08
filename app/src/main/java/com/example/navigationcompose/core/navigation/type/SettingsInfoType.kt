package com.example.navigationcompose.core.navigation.type

import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.example.navigationcompose.core.navigation.SettingsInfo
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    prettyPrint = true
}

