package arsensaliev.io.nasaapp.di.module.repo

import arsensaliev.io.nasaapp.mvp.model.api.IDataSource
import arsensaliev.io.nasaapp.mvp.model.repo.IPictureOfTheDayRepo
import arsensaliev.io.nasaapp.mvp.model.repo.RetrofitPictureOfTheDayOfTheDayRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun pictureOfTheDayRepo(api: IDataSource): IPictureOfTheDayRepo =
        RetrofitPictureOfTheDayOfTheDayRepo(api)
}