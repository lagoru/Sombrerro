package com.example.lagoru.sombrerro.mvi

import android.support.v4.app.Fragment

class FragmentMviDelegate<in V, VS : ViewState<*>, P : MviPresenter<V, VS>> constructor(private var delegateCallback: MviDelegateCallback<V, VS, P>?,
                                                                                        private var fragment: Fragment?,
                                                                                        private var viewStateCache: ViewStateCache?,
                                                                                        private val keepPresenterDuringScreenOrientationChange: Boolean = true,
                                                                                        private val keepPresenterOnBackstack: Boolean = true) {
    private var onViewCreatedCalled = false
    private var presenter: P? = null

    private val activity: android.app.Activity
        get() {
            return fragment!!.activity ?: throw NullPointerException(
                    "Activity returned by Fragment.getActivity() is null. Fragment is " + fragment!!)
        }

    private var shouldRetainViewState: Boolean = false
        get() {
            if (activity.isChangingConfigurations) {
                if (keepPresenterDuringScreenOrientationChange) {
                    return true
                }
                return false
            }

            if (activity.isFinishing) {
                return false
            }

            if (keepPresenterOnBackstack /*&& fragment.isInBackStack()*/) { // TODO Adrian dodac sprawdzanie czy jest na backstacku
                return true
            }

            return !fragment!!.isRemoving
        }

    init {
        if (delegateCallback == null) {
            throw NullPointerException("delegateCallback == null")
        }

        if (fragment == null) {
            throw NullPointerException("fragment == null")
        }

        if (!keepPresenterDuringScreenOrientationChange && keepPresenterOnBackstack) {
            throw IllegalArgumentException("It is not possible to keep the presenter on backstack, "
                    + "but NOT keep presenter through screen orientation changes. Keep presenter on backstack also "
                    + "requires keep presenter through screen orientation changes to be enabled")
        }
    }

    fun onAttach(activity: android.app.Activity?) {}

    fun onAttach(context: android.content.Context?) {}

    fun onCreate(saved: android.os.Bundle?) {

    }

    fun onViewCreated(view: android.view.View?, savedInstanceState: android.os.Bundle?) {
        onViewCreatedCalled = true

        val viewState: VS? = viewStateCache?.getViewState<VS>(delegateCallback!!.viewStateIdentifierId)
        val viewStateWillBeRestored: Boolean = viewState != null
        presenter = delegateCallback!!.createPresenter(viewState)

        if (viewStateWillBeRestored) {
            delegateCallback!!.isRestoringViewState = true
        }
        // presenter is ready, so attach viewState
        presenter!!.attachView(delegateCallback!!.mvpView)

        if (viewStateWillBeRestored) {
            delegateCallback!!.isRestoringViewState = false
        }
    }

    fun onAttachFragment(childFragment: Fragment?) {}

    fun onActivityCreated(savedInstanceState: android.os.Bundle?) {
        if (!onViewCreatedCalled) {
            throw IllegalStateException(
                    "It seems that onCreateView() has never been called (or has returned null). This means that your fragment is headless (no UI). That is not allowed because it doesn't make sense to use Mosby with a Fragment without View.")
        }
    }

    fun onStart() {}

    fun onResume() {}

    fun onSaveInstanceState(outState: android.os.Bundle) {
        if (shouldRetainViewState) {
            viewStateCache!!.saveViewState(delegateCallback!!.viewStateIdentifierId, presenter!!.viewState)
        }
    }

    fun onPause() {}

    fun onStop() {}

    fun onConfigurationChanged(newConfig: android.content.res.Configuration?) {}

    fun onDestroyView() {
        onViewCreatedCalled = false

        presenter!!.detachView(shouldRetainViewState)
    }

    fun onDestroy() {
        presenter = null
        delegateCallback = null
        fragment = null
    }

    fun onDetach() {}
}