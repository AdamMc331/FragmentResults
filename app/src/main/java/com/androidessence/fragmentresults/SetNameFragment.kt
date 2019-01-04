package com.androidessence.fragmentresults

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_set_name.*

/**
 * A placeholder fragment containing a simple view.
 */
class SetNameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        finish_button.setOnClickListener {
            returnWithName()
        }
    }

    /**
     * Gets the name from the edit text and set the result for this fragment.
     */
    private fun returnWithName() {
        val name = name_input.text.toString()

        (targetFragment as? DisplayNameFragment)?.setName(name)
        activity?.supportFragmentManager?.popBackStackImmediate()
    }
}
