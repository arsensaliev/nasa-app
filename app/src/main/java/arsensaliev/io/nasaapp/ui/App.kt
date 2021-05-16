package arsensaliev.io.nasaapp.ui

import android.app.Application
import arsensaliev.io.nasaapp.di.AppComponent
import arsensaliev.io.nasaapp.di.DaggerAppComponent
import arsensaliev.io.nasaapp.di.module.app.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}