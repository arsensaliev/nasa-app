package arsensaliev.io.nasaapp.mvp.model.navigation

import com.github.terrakok.cicerone.Screen


interface IScreens {
    fun earth(): Screen
    fun apod(): Screen
    fun settings(): Screen
}