package arsensaliev.io.nasaapp.mvp.model.api

import arsensaliev.io.nasaapp.mvp.model.entity.PictureOfTheDayData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IDataSource {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Single<PictureOfTheDayData>
}