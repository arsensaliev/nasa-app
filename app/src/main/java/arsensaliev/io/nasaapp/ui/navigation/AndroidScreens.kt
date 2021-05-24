package arsensaliev.io.nasaapp.ui.navigation

import arsensaliev.io.nasaapp.mvp.model.navigation.IScreens
import arsensaliev.io.nasaapp.ui.fragment.chips.ChipsFragment
import arsensaliev.io.nasaapp.ui.fragment.home.HomeFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun home(): Screen = FragmentScreen { HomeFragment.newInstance() }
    override fun filter(): Screen = FragmentScreen { ChipsFragment.newInstance() }
}