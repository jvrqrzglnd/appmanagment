package com.kripto.appmanager.util

fun String.firstCap() = this.lowercase().replaceFirstChar {
    it.uppercase()
}