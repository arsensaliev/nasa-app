package arsensaliev.io.nasaapp.mvp.model.api

import arsensaliev.io.nasaapp.BuildConfig
import arsensaliev.io.nasaapp.mvp.model.entity.EarthImages
import arsensaliev.io.nasaapp.mvp.model.entity.ApodData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {
    @GET("EPIC/api/natural/images")
    fun getEarthImages(@Query("api_key") apiKey: String = BuildConfig.NASA_API_KEY): Single<EarthImages>

    @GET("planetary/apod")
    fun getApodImage(@Query("api_key") apiKey: String = BuildConfig.NASA_API_KEY): Single<ApodData>
}