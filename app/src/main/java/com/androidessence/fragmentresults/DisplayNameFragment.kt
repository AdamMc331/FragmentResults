package com.androidessence.fragmentresults

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A fragment used for displaying a name. It contains a button which will launch a separate fragment to set the name.
 */
class DisplayNameFragment : Fragment() {

    private var name: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        set_name_button.setOnClickListener {
            launchSetNameFragment()
        }
    }

    /**
     * Launches a new fragment where the user can set their name.
     */
    private fun launchSetNameFragment() {
        val newFragment = SetNameFragment()
        val tag = SetNameFragment::class.java.simpleName

        newFragment.setTargetFragment(this, SET_NAME_REQUEST_CODE)
        (activity as? MainActivity)?.replace(newFragment, tag)
    }

    /**
     * Check if we have a [fragmentResult] and handle accordingly.
     */
    override fun onResume() {
        super.onResume()

        name_textview.text = getString(R.string.your_name_is).format(name)
    }

    fun setName(name: String) {
        this.name = name
    }

    companion object {
        const val SET_NAME_REQUEST_CODE = 1
        const val NEW_NAME = "newName"
    }
}
