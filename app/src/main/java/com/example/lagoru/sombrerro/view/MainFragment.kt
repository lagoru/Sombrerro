package com.example.lagoru.sombrerro.view

import com.example.lagoru.sombrerro.mvi.MviFragment
import com.example.lagoru.sombrerro.mvi.ViewState
import javax.inject.Inject

/**
 * Created by lagoru on 21.06.17.
 */
class MainFragment : MviFragment<MainFragment, MainFragmentViewState, MainFragmentPresenter>() {

    @Inject
    lateinit var presenter: MainFragmentPresenter

    override val viewStateIdentifierId: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.


    override fun createPresenter(viewState: ViewState?): MainFragmentPresenter {
        return presenter
    }
}