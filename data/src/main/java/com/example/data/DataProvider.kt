package com.example.data

/**
 * Created by lagoru on 26.06.17.
 */
abstract class DataGetter<in Q, out R : Response> constructor(private var mocker: Mocker<Q, R>?) {
    fun getData(query: Q): R {
        return mocker?.mock(query) ?: askServer(query)
    }

    abstract fun askServer(query: Q): R
}

abstract class DataSaver<in D, out R : Response> {
    abstract fun saveData(data: D): R
}