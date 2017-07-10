package com.example.data

import com.example.data.query.TopicQuery
import com.example.data.response.TopicResponse

/**
 * Created by lagoru on 06.07.17.
 */
class TopicDataProvider(mocker: Mocker<TopicQuery, TopicResponse>?) : DataGetter<TopicQuery, TopicResponse>(mocker) {
    override fun askServer(query: TopicQuery): TopicResponse {
        return TopicResponse() //TODO implement this
    }
}