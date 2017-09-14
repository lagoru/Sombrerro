package com.example.data

import io.reactivex.Observable

/**
 * Created by lagoru on 26.06.17.
 */
abstract class Mocker<Query, Res : Response> : DataGetter<Query, Res> {

    override fun performGetQuery(query: Query): Observable<Res> {
        return Observable.just(mock(query))
    }

    abstract fun mock(query: Query): Res
}