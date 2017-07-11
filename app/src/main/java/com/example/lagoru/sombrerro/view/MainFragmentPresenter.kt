package com.example.lagoru.sombrerro.view

import com.example.lagoru.sombrerro.mvi.MviPresenter

/**
 * Created by lagoru on 21.06.17.
 */

class MainFragmentPresenter : MviPresenter<MainFragment, MainFragmentViewState> {

    override var viewState: MainFragmentViewState
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}


    override fun attachView(view: MainFragment) {

    }

    override fun detachView(retainInstance: Boolean) {

    }
}