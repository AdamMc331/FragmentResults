package com.androidessence.fragmentresults

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Base fragment class which has all of the helper method for launching a fragment for result and handling them.
 *
 * @property[mainActivity] Helper variable to get the activity reference as a MainActivity to avoid casting.
 * @property[targetFragment] Helper variable to get the target fragment as a BaseFragment to avoid casting.
 * @property[fragmentResult] The result of a fragment that we launched.
 */
open class BaseFragment : Fragment() {
    private val mainActivity: MainActivity?
        get() = activity as? MainActivity

    private val targetFragment: BaseFragment?
        get() = getTargetFragment() as? BaseFragment

    protected var fragmentResult: Bundle? = null
        private set

    /**
     * Before adding our new fragment, we set the current fragment as the [targetFragment] so that it can be referenced
     * when we call [setResult]. This is only necessary if we want to launch a fragment and collect information from it.
     */
    fun startFragmentForResult(fragment: Fragment, requestCode: Int, tag: String) {
        fragment.setTargetFragment(this, requestCode)
        mainActivity?.replace(fragment, tag)
    }

    /**
     * Adds the request code to the result and sets the value to be read in [onResume].
     */
    fun setResult(data: Bundle) {
        data.putInt(REQUEST_CODE, targetRequestCode)
        targetFragment?.fragmentResult = data
        mainActivity?.supportFragmentManager?.popBackStackImmediate()
    }

    companion object {
        const val REQUEST_CODE = "requestCode"
    }
}