package com.example.lagoru.sombrerro.mvi

/**
 * Created by lagoru on 20.06.17.
 */
interface ViewState<in VS> {
    fun flattenState(vararg states: VS)
}