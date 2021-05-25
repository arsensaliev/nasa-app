package arsensaliev.io.nasaapp.mvp.model.repo

import arsensaliev.io.nasaapp.mvp.model.entity.ApodData
import arsensaliev.io.nasaapp.mvp.model.entity.EarthImages
import io.reactivex.rxjava3.core.Single

interface INasaApiRequests {
    fun getLastEarthImages(): Single<EarthImages>
    fun getApodImage(): Single<ApodData>
}