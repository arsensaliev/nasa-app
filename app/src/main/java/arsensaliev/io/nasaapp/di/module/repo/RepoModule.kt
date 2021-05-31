package arsensaliev.io.nasaapp.di.module.repo

import arsensaliev.io.nasaapp.mvp.model.api.IDataSource
import arsensaliev.io.nasaapp.mvp.model.repo.INasaApiRequests
import arsensaliev.io.nasaapp.mvp.model.repo.RetrofitNasaApiRequests
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepoModule {

    @Named("earthImagesRepo")
    @Singleton
    @Provides
    fun getEarthImagesRepo(api: IDataSource): INasaApiRequests =
        RetrofitNasaApiRequests(api)

    @Named("apodImageRepo")
    @Singleton
    @Provides
    fun getApodImageRepo(api: IDataSource): INasaApiRequests = RetrofitNasaApiRequests(api)
}