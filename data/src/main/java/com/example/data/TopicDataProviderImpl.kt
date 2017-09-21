package com.example.data

import com.example.data.interfaces.TopicDataProvider
import com.example.data.query.TopicQuery
import com.example.data.response.TopicResponse
import io.reactivex.Observable

class TopicDataProviderImpl : TopicDataProvider {
    override fun performGetQuery(query: TopicQuery): Observable<TopicResponse> {
        return Observable.just(TopicResponse())
    }
}