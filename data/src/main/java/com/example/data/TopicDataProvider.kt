package com.example.data

import com.example.data.query.TopicQuery
import com.example.data.response.TopicResponse
import io.reactivex.Observable

/**
 * Created by lagoru on 06.07.17.
 */
class TopicDataProvider : DataGetter<TopicQuery, TopicResponse>() {
    override fun performGetQuery(query: TopicQuery): Observable<TopicResponse> {
        return Observable.just(TopicResponse())
    }
}