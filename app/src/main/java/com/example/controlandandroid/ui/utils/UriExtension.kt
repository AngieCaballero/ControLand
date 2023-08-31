package com.example.controlandandroid.ui.utils

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns

fun Context.getNameFromUri(uri: Uri): String {
    contentResolver
        .query(uri, null, null, null, null)
        .use { cursor ->
            if (cursor == null) return@use
            if (cursor.moveToFirst() && cursor.count >= 1) {
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                return cursor.getString(nameIndex)
            }
        }
    return ""
}