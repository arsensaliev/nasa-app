package arsensaliev.io.nasaapp.mvp.model.repo

import arsensaliev.io.nasaapp.BuildConfig
import arsensaliev.io.nasaapp.mvp.model.api.IDataSource
import arsensaliev.io.nasaapp.mvp.model.entity.PictureOfTheDayData
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitPictureOfTheDayOfTheDayRepo(val api: IDataSource) : IPictureOfTheDayRepo {
    override fun getPictureOfTheDay(): Single<PictureOfTheDayData> =
        api.getPictureOfTheDay(BuildConfig.NASA_API_KEY).subscribeOn(Schedulers.io())
}