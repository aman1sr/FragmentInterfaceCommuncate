package com.example.fragmentinterfacecommunicate

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SenderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SenderFragment : Fragment() {
    private lateinit var communicator: Communicator


    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = context as Communicator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputField = view.findViewById<EditText>(R.id.edMessage)
        val buttonSend = view.findViewById<Button>(R.id.btnSend)

        buttonSend.setOnClickListener {
            inputField.text.toString()?.let {
                communicator.sendMessage(it)
            }

        }
    }
}