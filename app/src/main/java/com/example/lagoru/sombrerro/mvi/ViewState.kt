package com.example.lagoru.sombrerro.mvi

interface ViewState<in VS> {
    fun flattenState(vararg states: VS)
}