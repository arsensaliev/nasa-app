package arsensaliev.io.nasaapp.ui.fragment.chips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arsensaliev.io.nasaapp.databinding.FragmentChipsBinding
import arsensaliev.io.nasaapp.mvp.presenter.chips.ChipsPresenter
import arsensaliev.io.nasaapp.mvp.view.chips.ChipsView
import arsensaliev.io.nasaapp.ui.App
import arsensaliev.io.nasaapp.ui.BackButtonListener
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class ChipsFragment : MvpAppCompatFragment(), ChipsView, BackButtonListener {
    @Inject
    @InjectPresenter
    lateinit var presenter: ChipsPresenter

    @ProvidePresenter
    fun provide() = presenter

    private var ui: FragmentChipsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentChipsBinding.inflate(inflater, container, false).also { ui = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ui?.chipGroup?.setOnCheckedChangeListener { chipGroup, position ->
            chipGroup.findViewById<Chip>(position)?.let {
                Snackbar.make(view, "Выбран ${it.text}", Snackbar.LENGTH_SHORT).show()
            }
        }

        ui?.chipClose?.setOnCloseIconClickListener {
            Snackbar.make(view, "Close is Clicked", Snackbar.LENGTH_SHORT).show()
        }

    }

    override fun backPressed(): Boolean = presenter.backClick()

    companion object {
        fun newInstance() = ChipsFragment().apply {}
    }

    init {
        App.instance.appComponent.inject(this)
    }
}