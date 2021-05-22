package arsensaliev.io.nasaapp.di.module.api

import arsensaliev.io.nasaapp.mvp.model.api.IDataSource
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    fun api(gson: Gson): IDataSource = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)

    @Singleton
    @Provides
    fun gson(): Gson = GsonBuilder()
        .create()
}