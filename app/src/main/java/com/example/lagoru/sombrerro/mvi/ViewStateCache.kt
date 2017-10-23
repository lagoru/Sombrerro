package com.example.lagoru.sombrerro.mvi

/**
 * Created by lagoru on 19.06.17.
 */

class ViewStateCache {
    private var cache: HashMap<String, Any> = HashMap()

    public fun <T> getViewState(key: String): T {
        return cache.get(key) as T
    }

    public fun saveViewState(key: String, state: Any?) {
        if (state != null) {
            cache.put(key, state)
        } else {
            removeViewState(key)
        }
    }

    public fun removeViewState(key: String) {
        cache.remove(key)
    }

    public fun reset() {
        cache.clear()
    }
}