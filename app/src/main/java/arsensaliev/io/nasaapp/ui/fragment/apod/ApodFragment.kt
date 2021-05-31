package arsensaliev.io.nasaapp.ui.fragment.apod

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import arsensaliev.io.nasaapp.R
import arsensaliev.io.nasaapp.databinding.FragmentApodStartBinding
import arsensaliev.io.nasaapp.mvp.presenter.apod.ApodPresenter
import arsensaliev.io.nasaapp.mvp.view.apod.ApodView
import arsensaliev.io.nasaapp.ui.App
import arsensaliev.io.nasaapp.ui.BackButtonListener
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


class ApodFragment : MvpAppCompatFragment(), ApodView, BackButtonListener {
    @Inject
    @InjectPresenter
    lateinit var presenter: ApodPresenter

    @ProvidePresenter
    fun provide() = presenter

    private var ui: FragmentApodStartBinding? = null
    lateinit var bottomSheetUi: ConstraintLayout
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


    override fun setDescription(description: String) {
        bottomSheetUi.findViewById<TextView>(R.id.bottom_sheet_description).text = description
    }

    override fun startAnimation() {
        ui?.main?.transitionToEnd()
    }

    override fun setImage(url: String) {
        ui?.imageView?.load(url) {
            lifecycle(this@ApodFragment)
            error(R.drawable.ic_error)
            placeholder(R.drawable.ic_no_photo_vector)
        }
    }

    override fun setTitle(title: String) {
        bottomSheetUi.findViewById<TextView>(R.id.bottom_sheet_description_header).text = title
    }

    fun searchWiki() {
        val wikiText = ui?.inputEditText?.text.toString()
        startActivity(Intent(Intent.ACTION_VIEW).apply {
            data =
                Uri.parse("https://en.wikipedia.org/wiki/${wikiText}")
        })
    }

    private fun setBottomSheetBehavior(bottomSheet: ConstraintLayout) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    override fun backPressed(): Boolean = presenter.backClick()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentApodStartBinding.inflate(inflater, container, false).also { ui = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetUi = view.findViewById(R.id.bottom_sheet_container)
        setBottomSheetBehavior(bottomSheetUi)
        ui?.inputLayout?.setEndIconOnClickListener { searchWiki() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    companion object {
        fun newInstance() =
            ApodFragment().apply {}
    }

    init {
        App.instance.appComponent.inject(this)
    }
}