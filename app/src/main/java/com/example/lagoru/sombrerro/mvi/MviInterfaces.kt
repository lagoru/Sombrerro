package com.example.lagoru.sombrerro.mvi

/**
 * Created by lagoru on 18.06.17.
 */

interface MvpPresenter<in V> {

    /**
     * Set or attach the view to this presenter
     */
    @android.support.annotation.UiThread
    fun attachView(view: V)

    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * `Activity.detachView()` or `Fragment.onDestroyView()`
     */
    @android.support.annotation.UiThread
    fun detachView(retainInstance: Boolean)
}

interface MviPresenter<in V, VS : ViewState<*>> : com.example.lagoru.sombrerro.mvi.MvpPresenter<V> {
    var viewState: VS
}

interface MviDelegateCallback<V, in VS : ViewState<*>, out P : MviPresenter<V, *>> {

    /**
     * Creates the presenter instance

     * @return the created presenter instance
     */
    fun createPresenter(viewState: VS?): P

    val viewStateIdentifierId: String

    /**
     * Get the MvpView for the presenter

     * @return The viewState associated with the presenter
     */
    val mvpView: V

    /**
     * This method will be called to inform that restoring
     * the view state is in progress (true as parameter value) and when restoring is finished (false
     * as parameter value). Typically this is set to true when the view is reattached to the
     * presenter
     * after orientation changes or when navigating back from backstack.
     * Usually this is useful if you want to know whether or not you should run certain animations
     * because of the state of the view has changed or the view has been reattached to the presenter
     * (i.e. orientation change, coming back from back stack) and therefore no animations should run.

     * @param restoringViewState true, if restoring view state is in progress, otherwise false
     */
    var isRestoringViewState: Boolean
}