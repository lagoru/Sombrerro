package com.example.data

/**
 * Created by lagoru on 26.06.17.
 */
abstract class Mocker<Q, out R : Response> {
    abstract fun mock(query: Q): R
}