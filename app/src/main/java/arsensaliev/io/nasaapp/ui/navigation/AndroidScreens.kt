package arsensaliev.io.movieapp.ui.navigation

import arsensaliev.io.movieapp.mvp.model.navigation.IScreens
import arsensaliev.io.movieapp.ui.fragment.movies.MoviesFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun main(): Screen = FragmentScreen { MainFragment.newInstance() }
}