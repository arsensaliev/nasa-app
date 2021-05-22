package arsensaliev.io.nasaapp.mvp.model.repo

import arsensaliev.io.nasaapp.mvp.model.entity.PictureOfTheDayData
import io.reactivex.rxjava3.core.Single

interface IPictureOfTheDayRepo {
    fun getPictureOfTheDay(): Single<PictureOfTheDayData>
}