package com.example.mvvm_app.utils

import com.example.mvvm_app.R

object Utils {
    fun nameToColor(name: String): Int {
        return when (name) {
            "yellow" -> R.color.yellow
            "blue" -> R.color.blue
            "red" -> R.color.red
            "brown" -> R.color.brown
            "white" -> R.color.white
            else -> R.color.black
        }
    }
}
