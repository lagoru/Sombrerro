package com.example.lagoru.sombrerro.mocker

import com.example.data.Mocker
import com.example.data.model.Topic
import com.example.data.query.TopicQuery
import com.example.data.response.TopicResponse
import javax.inject.Inject

/**
 * Created by lagoru on 10.07.17.
 */
class TopicMocker @Inject constructor() : Mocker<TopicQuery, TopicResponse>() {
    override fun mock(query: TopicQuery): TopicResponse {
        return TopicResponse(topicList = listOf(Topic("Left"), Topic("Right"), Topic("Center")))
    }
}