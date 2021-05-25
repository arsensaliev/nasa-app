package arsensaliev.io.nasaapp.di

import arsensaliev.io.nasaapp.di.module.api.ApiModule
import arsensaliev.io.nasaapp.di.module.app.AppModule
import arsensaliev.io.nasaapp.di.module.cicerone.CiceroneModule
import arsensaliev.io.nasaapp.di.module.repo.RepoModule
import arsensaliev.io.nasaapp.mvp.presenter.apod.ApodPresenter
import arsensaliev.io.nasaapp.mvp.presenter.chips.ChipsPresenter
import arsensaliev.io.nasaapp.mvp.presenter.earth.EarthPresenter
import arsensaliev.io.nasaapp.mvp.presenter.main.MainPresenter
import arsensaliev.io.nasaapp.ui.activity.MainActivity
import arsensaliev.io.nasaapp.ui.fragment.apod.ApodFragment
import arsensaliev.io.nasaapp.ui.fragment.chips.ChipsFragment
import arsensaliev.io.nasaapp.ui.fragment.earth.EarthFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        RepoModule::class,
        CiceroneModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(earthFragment: EarthFragment)
    fun inject(earthPresenter: EarthPresenter)
    fun inject(chipsFragment: ChipsFragment)
    fun inject(chipsPresenter: ChipsPresenter)
    fun inject(apodFragment: ApodFragment)
    fun inject(apodPresenter: ApodPresenter)
}