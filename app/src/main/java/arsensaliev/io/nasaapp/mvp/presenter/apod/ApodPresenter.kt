package arsensaliev.io.nasaapp.mvp.presenter.apod

import android.util.Log
import android.widget.Toast
import arsensaliev.io.nasaapp.mvp.model.repo.INasaApiRequests
import arsensaliev.io.nasaapp.mvp.view.apod.ApodView
import arsensaliev.io.nasaapp.ui.App
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class ApodPresenter @Inject constructor(
    @param:Named("ui")
    private val uiScheduler: Scheduler,
    @param:Named("apodImageRepo")
    private val nasaApiRequests: INasaApiRequests,
    private val router: Router,
) : MvpPresenter<ApodView>() {
    private val compositeDisposable = CompositeDisposable()


    private fun loadData() {
        val disposable: Disposable = nasaApiRequests.getApodImage()
            .observeOn(uiScheduler)
            .subscribe({ apodData ->
                apodData.url.let { viewState.setImage(it) }
                apodData.title.let { viewState.setTitle(it) }
                apodData.explanation.let { viewState.setDescription(it) }
            }, {
                it.printStackTrace()
                it.message?.let { it1 -> viewState.setImage(it1) }
            })

        compositeDisposable.addAll(disposable)
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    init {
        App.instance.appComponent.inject(this)
    }
}