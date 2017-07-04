package com.example.lagoru.sombrerro.navigator

import android.support.v4.app.FragmentManager
import com.example.lagoru.sombrerro.baseApplication
import com.example.lagoru.sombrerro.mvi.MviFragment
import com.example.lagoru.sombrerro.utils.FragmentUtils
import com.example.lagoru.sombrerro.view.MainFragment


/**
 * Created by lagoru on 04.07.17.
 */
class FragmentNavigator constructor(private var supportFragmentManager: FragmentManager) {

    fun openMainScreen(): MainFragment {
        return injectDagger(FragmentUtils.showFragmentIfContainerIsEmpty(MainFragment::class,
                supportFragmentManager, FragmentUtils.fragmentContainerId)!! as MviFragment<*, *, *>) as MainFragment
    }

    private fun injectDagger(fragment: MviFragment<*, *, *>): MviFragment<*, *, *> {
        baseApplication!!.inject(fragment)
        return fragment
    }
}