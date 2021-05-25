package arsensaliev.io.nasaapp.ui.navigation

import arsensaliev.io.nasaapp.mvp.model.navigation.IScreens
import arsensaliev.io.nasaapp.ui.fragment.apod.ApodFragment
import arsensaliev.io.nasaapp.ui.fragment.chips.ChipsFragment
import arsensaliev.io.nasaapp.ui.fragment.earth.EarthFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun earth(): Screen = FragmentScreen { EarthFragment.newInstance() }
    override fun apod(): Screen = FragmentScreen { ApodFragment.newInstance() }
    override fun settings(): Screen = FragmentScreen { ChipsFragment.newInstance() }
}