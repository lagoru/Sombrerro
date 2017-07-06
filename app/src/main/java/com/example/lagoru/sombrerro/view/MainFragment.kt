package com.example.lagoru.sombrerro.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lagoru.sombrerro.R
import com.example.lagoru.sombrerro.mvi.MviFragment
import com.example.lagoru.sombrerro.mvi.ViewState
import javax.inject.Inject

/**
 * Created by lagoru on 21.06.17.
 */
class MainFragment : MviFragment<MainFragment, MainFragmentViewState, MainFragmentPresenter>() {

    val TAG: String = MainFragment::class.simpleName!!

    @Inject
    lateinit var presenter: MainFragmentPresenter

    override val viewStateIdentifierId: String
        get() = TAG


    override fun createPresenter(viewState: ViewState?): MainFragmentPresenter {
        return presenter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }
}