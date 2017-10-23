package com.example.lagoru.sombrerro.view

import com.example.lagoru.sombrerro.mvi.MviPresenter

/**
 * Created by lagoru on 21.06.17.
 */

class MainFragmentPresenter : MviPresenter<MainFragment, MainFragmentViewState>() {

    override fun initializeState(): MainFragmentViewState {
        return MainFragmentViewState(true)
    }

    override fun attachView(view: MainFragment) {

    }

    override fun detachView(retainInstance: Boolean) {

    }
}