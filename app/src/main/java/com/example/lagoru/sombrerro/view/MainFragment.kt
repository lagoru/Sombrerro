package com.example.lagoru.sombrerro.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.data.model.Topic
import com.example.lagoru.sombrerro.R
import com.example.lagoru.sombrerro.mvi.MviFragment
import com.example.lagoru.sombrerro.mvi.ViewState
import kotlinx.android.synthetic.main.fragment_main.*
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

    fun renderTopic(topics: List<Topic>) {
        circleLayout.removeAllViews()
        for (topic in topics) {
            val textView = TextView(context)
            textView.text = topic.title
            textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            circleLayout.addView(textView)
        }
    }
}