package arsensaliev.io.nasaapp.mvp.presenter.earth

import arsensaliev.io.nasaapp.mvp.model.repo.INasaApiRequests
import arsensaliev.io.nasaapp.mvp.view.earth.EarthView
import arsensaliev.io.nasaapp.ui.App
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class EarthPresenter @Inject constructor(
    @param:Named("ui")
    private val uiScheduler: Scheduler,
    @param:Named("earthImagesRepo")
    private val nasaApiRequests: INasaApiRequests,
    private val router: Router,
) : MvpPresenter<EarthView>() {
    private val compositeDisposable = CompositeDisposable()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        val disposable: Disposable = nasaApiRequests.getLastEarthImages()
            .observeOn(uiScheduler)
            .subscribe({ item ->
                val earthImageItem = item.first()
                viewState.setImage(earthImageItem.fullImagePath)
            }, {
                it.printStackTrace()
                it.message?.let { it1 -> viewState.setImage(it1) }
            })

        compositeDisposable.addAll(disposable)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    init {
        App.instance.appComponent.inject(this)
    }
}