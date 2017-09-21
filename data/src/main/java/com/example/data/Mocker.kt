package com.example.data

import io.reactivex.Observable

abstract class Mocker<Query, Res : Response> : DataGetter<Query, Res> {

    override fun performGetQuery(query: Query): Observable<Res> {
        return Observable.just(mock(query))
    }

    abstract fun mock(query: Query): Res
}