package com.example.navigationcompose.core.navigation.type

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T: Parcelable> createNavType():NavType<T>{
    return object : NavType<T>(isNullableAllowed = true) {
        override fun get(bundle: Bundle, key: String): T? {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(key, T::class.java)
            } else {
                bundle.getParcelable(key)
            }
        }

        override fun parseValue(value: String): T {
            // Use the custom JSON instance for decoding
            return json.decodeFromString<T>(value)
        }

        override fun serializeAsValue(value: T): String {
            // Use the custom JSON instance for encoding
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: T) {
            bundle.putParcelable(key, value)
        }
    }
}