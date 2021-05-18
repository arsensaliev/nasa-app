package arsensaliev.io.nasaapp.mvp.presenter.home

import arsensaliev.io.nasaapp.mvp.model.entity.PictureOfTheDayData
import arsensaliev.io.nasaapp.mvp.model.repo.IPictureOfTheDayRepo
import arsensaliev.io.nasaapp.mvp.view.home.HomeView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class HomePresenter : MvpPresenter<HomeView>() {
    @field:Named("ui")
    @Inject
    lateinit var uiScheduler: Scheduler

    @Inject
    lateinit var pictureOfTheDayRepo: IPictureOfTheDayRepo

    @Inject
    lateinit var router: Router

    private val compositeDisposable = CompositeDisposable()

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {
        var post: PictureOfTheDayData? = null

        val disposable: Disposable = pictureOfTheDayRepo.getPictureOfTheDay()
            .observeOn(uiScheduler)
            .subscribe({ picture ->
                picture.url?.let { viewState.setImage(it) }
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
}