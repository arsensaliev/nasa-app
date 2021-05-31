package arsensaliev.io.nasaapp.mvp.model.repo

import arsensaliev.io.nasaapp.BuildConfig
import arsensaliev.io.nasaapp.mvp.model.api.IDataSource
import arsensaliev.io.nasaapp.mvp.model.entity.ApodData
import arsensaliev.io.nasaapp.mvp.model.entity.EarthImages
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitNasaApiRequests(val api: IDataSource) : INasaApiRequests {
    override fun getLastEarthImages(): Single<EarthImages> =
        api.getEarthImages(BuildConfig.NASA_API_KEY).subscribeOn(Schedulers.io())

    override fun getApodImage(): Single<ApodData> = api.getApodImage().subscribeOn(Schedulers.io())
}