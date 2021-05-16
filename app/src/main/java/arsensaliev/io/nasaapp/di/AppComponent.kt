package arsensaliev.io.nasaapp.di

import arsensaliev.io.nasaapp.di.module.app.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
    ]
)
interface AppComponent {

}