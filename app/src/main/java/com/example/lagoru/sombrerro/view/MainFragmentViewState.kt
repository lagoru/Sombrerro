package com.example.lagoru.sombrerro.view

import com.example.data.model.Topic
import com.example.lagoru.sombrerro.mvi.ViewState

/**
 * Created by lagoru on 27.06.17.
 */
class MainFragmentViewState constructor(var isLoadingTopics: Boolean = false,
                                        var topicList: MutableList<Topic>? = null,
                                        var isFirstDatasLoading: Boolean = false,
                                        var isNextDatasLoading: Boolean = false) : ViewState<MainFragmentViewState> {

    override fun flattenState(vararg states: MainFragmentViewState) {
        for (pieceOfState in states) {
            if (pieceOfState.topicList != null) {
                isLoadingTopics = false
                if (topicList == null) topicList = pieceOfState.topicList
                else topicList?.addAll(pieceOfState.topicList!!)
            }
        }
    }
}