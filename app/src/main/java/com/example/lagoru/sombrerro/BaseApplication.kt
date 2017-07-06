package com.example.lagoru.sombrerro

import android.app.Application
import com.example.lagoru.sombrerro.di.ApplicationComponent
import com.example.lagoru.sombrerro.di.DaggerApplicationComponent
import com.example.lagoru.sombrerro.di.DaggerFragmentComponent
import com.example.lagoru.sombrerro.di.FragmentComponent
import com.example.lagoru.sombrerro.mvi.MviFragment
import com.example.lagoru.sombrerro.view.MainFragment

/**
 * Created by lagoru on 13.06.17.
 */
class BaseApplication : Application() {
    lateinit var graph: ApplicationComponent
    lateinit var fragmentGraph: FragmentComponent

    override fun onCreate() {
        super.onCreate()
        baseApplication = this
        graph = DaggerApplicationComponent.builder().build()
        graph.inject(this)
        fragmentGraph = DaggerFragmentComponent.builder().applicationComponent(graph).build()
    }

    fun inject(fragment: MviFragment<*, *, *>) {
        if (fragment is MainFragment) {
            fragmentGraph.inject(fragment)
        }
    }
}

var baseApplication: BaseApplication? = null