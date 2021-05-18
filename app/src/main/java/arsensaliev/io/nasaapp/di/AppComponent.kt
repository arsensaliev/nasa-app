package arsensaliev.io.nasaapp.di

import arsensaliev.io.nasaapp.di.module.api.ApiModule
import arsensaliev.io.nasaapp.di.module.app.AppModule
import arsensaliev.io.nasaapp.di.module.cicerone.CiceroneModule
import arsensaliev.io.nasaapp.di.module.repo.RepoModule
import arsensaliev.io.nasaapp.mvp.presenter.home.HomePresenter
import arsensaliev.io.nasaapp.mvp.presenter.main.MainPresenter
import arsensaliev.io.nasaapp.ui.activity.MainActivity
import arsensaliev.io.nasaapp.ui.fragment.home.HomeFragment
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
    fun inject(homeFragment: HomeFragment)
    fun inject(homePresenter: HomePresenter)
}