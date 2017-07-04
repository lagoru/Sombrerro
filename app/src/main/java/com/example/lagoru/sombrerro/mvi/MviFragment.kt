package com.example.lagoru.sombrerro.mvi


import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import javax.inject.Inject

/**
 * Created by lagoru on 18.06.17.
 */
abstract class MviFragment<V, VS : ViewState, P : MviPresenter<V, VS>> : Fragment(), MviDelegateCallback<V, P> {

    @Inject
    lateinit var viewStateCache: ViewStateCache

    override var isRestoringViewState = false

    private var _mvpDelegeate: FragmentMviDelegate<V, VS, P>? = null
    protected var mvpDelegate: FragmentMviDelegate<V, VS, P>? = null
        get() {
            if (_mvpDelegeate == null) {
                _mvpDelegeate = FragmentMviDelegate<V, VS, P>(this, this, viewStateCache)
            }
            return _mvpDelegeate ?: throw AssertionError("Set to null by another thread")
        }

    override val mvpView: V
        get() {
            try {
                return this as V
            } catch (e: ClassCastException) {
                val msg = "Couldn't cast the View to the corresponding View interface. Most likely you forgot to add \"Activity implements YourMvpViewInterface\".\""
                android.util.Log.e(this.toString(), msg)
                throw RuntimeException(msg, e)
            }
        }

    @CallSuper override fun onAttach(activity: android.app.Activity?) {
        super.onAttach(activity)
        mvpDelegate!!.onAttach(activity)
    }

    @CallSuper override fun onAttach(context: android.content.Context?) {
        super.onAttach(context)
        mvpDelegate!!.onAttach(context)
    }

    @CallSuper override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)
        mvpDelegate!!.onAttachFragment(childFragment)
    }

    @CallSuper override fun onActivityCreated(savedInstanceState: android.os.Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mvpDelegate!!.onActivityCreated(savedInstanceState)
    }

    @CallSuper override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        mvpDelegate!!.onCreate(savedInstanceState)
    }

    @CallSuper override fun onViewCreated(view: android.view.View?, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mvpDelegate!!.onViewCreated(view, savedInstanceState)
    }

    @CallSuper override fun onStart() {
        super.onStart()
        mvpDelegate!!.onStart()
    }

    @CallSuper override fun onResume() {
        super.onResume()
        mvpDelegate!!.onResume()
    }

    @CallSuper override fun onPause() {
        super.onPause()
        mvpDelegate!!.onPause()
    }

    @CallSuper override fun onSaveInstanceState(outState: android.os.Bundle) {
        super.onSaveInstanceState(outState)
        mvpDelegate!!.onSaveInstanceState(outState)
    }

    @CallSuper override fun onStop() {
        super.onStop()
        mvpDelegate!!.onStop()
    }

    @CallSuper override fun onDestroyView() {
        super.onDestroyView()
        mvpDelegate!!.onDestroyView()
    }

    @CallSuper override fun onDestroy() {
        super.onDestroy()
        mvpDelegate!!.onDestroy()
    }

    @CallSuper override fun onDetach() {
        super.onDetach()
        mvpDelegate!!.onDetach()
    }

    @CallSuper override fun onConfigurationChanged(newConfig: android.content.res.Configuration?) {
        super.onConfigurationChanged(newConfig)
        mvpDelegate!!.onConfigurationChanged(newConfig)
    }
}