package arsensaliev.io.movieapp.ui.fragment.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import arsensaliev.io.movieapp.databinding.FragmentMoviesBinding
import arsensaliev.io.movieapp.mvp.presenter.main.HomePresenter
import arsensaliev.io.movieapp.ui.adapter.MoviesRVAdapter
import arsensaliev.io.nasaapp.mvp.view.fragment.home.HomeView
import arsensaliev.io.nasaapp.ui.App
import arsensaliev.io.nasaapp.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class HomeFragment : MvpAppCompatFragment(), HomeView, BackButtonListener {
    private val presenter by moxyPresenter {
        HomePresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    private var ui: FragmentMoviesBinding? = null
    private var adapter: MoviesRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMoviesBinding.inflate(inflater, container, false).also { ui = it }.root

    override fun init() {
        val mLayoutManager = LinearLayoutManager(requireContext())
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        ui?.rvMovies?.layoutManager = mLayoutManager
        adapter = MoviesRVAdapter(presenter.moviesListPresenter).apply {
            App.instance.appComponent.inject(this)
        }
        ui?.rvMovies?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }


    override fun backPressed(): Boolean = presenter.backClick()

    companion object {
        fun newInstance() = MoviesFragment().apply {}
    }
}