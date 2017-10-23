package com.example.lagoru.sombrerro.utils

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.lagoru.sombrerro.R
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

object FragmentUtils {
    private val TAG = "FragmentUtils"

    val fragmentContainerId: Int = R.id.fragmentContainer

    val overlayContainerId: Int = R.id.overlayContainer

    fun showFragment(clazz: KClass<*>, fragmentManager: FragmentManager, containerId: Int = fragmentContainerId, bundle: Bundle? = null): Fragment? {
        try {
            return showFragment(construct(clazz) as Fragment, fragmentManager, containerId, bundle)
        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
        return null
    }

    fun showFragment(fragment: Fragment, fragmentManager: FragmentManager, containerId: Int = fragmentContainerId, bundle: Bundle? = null): Fragment {
        Log.d(TAG, "adding new fragment to container")
        fragment.arguments = bundle
        val transaction = fragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        transaction.add(containerId, fragment)
        transaction.commit()
        return fragment
    }

    fun removeFragment(fragment: Fragment, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction().remove(fragment).commit()
    }

    fun getFragmentInMainContainer(activity: AppCompatActivity): Fragment? {
        return getFragmentInContainer(activity, fragmentContainerId)
    }

    fun getFragmentInOverlayContainer(activity: AppCompatActivity): Fragment? {
        return getFragmentInContainer(activity, overlayContainerId)
    }

    fun getFragmentInContainer(activity: AppCompatActivity, fragmentContainer: Int): Fragment? {
        return getFragmentInContainer(activity.supportFragmentManager, fragmentContainer)
    }

    fun getFragmentInContainer(supportFragmentManager: FragmentManager, fragmentContainer: Int): Fragment? {
        return supportFragmentManager.findFragmentById(fragmentContainer)
    }

    fun showFragmentIfContainerIsEmpty(fragmentClazz: KClass<*>, supportFragmentManager: FragmentManager,
                                       fragmentContainer: Int, bundle: Bundle? = null): Fragment? {
        return getFragmentInContainer(supportFragmentManager, fragmentContainer) ?:
                showFragment(fragmentClazz, supportFragmentManager, fragmentContainer, bundle)
    }

    fun showOverlayFragment(clazz: KClass<*>, fragmentManager: FragmentManager, bundle: Bundle): Fragment? {
        return showFragment(clazz, fragmentManager, overlayContainerId, bundle)
    }

    //helper for contructor - we can use java newInstance but why ??
    fun <T : Any> construct(kClass: KClass<T>): T? {
        val ctor = kClass.primaryConstructor
        return if (ctor != null && ctor.parameters.isEmpty())
            ctor.call() else
            null
    }
}