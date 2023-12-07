package com.example.myapplication.navigation

enum class AppScreens {
    Home;

    companion object {
        fun fromRoute(route: String): AppScreens = when (route.substringBefore("/")) {
            Home.name -> Home


            else -> throw IllegalArgumentException("Route is not recognised")
        }
    }
}