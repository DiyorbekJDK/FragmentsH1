package com.diyorbek.fragmenth1.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.diyorbek.fragmenth1.R

class FragmentFirrst : Fragment() {
    private var firtstListener: FirstListener? = null
    private lateinit var editText: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.btn1)
        editText = view.findViewById(R.id.editText)
        button.setOnClickListener {
            firtstListener?.sentOne(editText.text)
        }


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firtstListener = if (context is FirstListener)
            context
        else
            throw  java.lang.RuntimeException("Hellllllllloooooo!!!!!!!!!!!")
    }

    override fun onDetach() {
        super.onDetach()
        firtstListener = null
    }

    fun oneText(text: Editable) {
        editText.text = text
    }


    interface FirstListener {
        fun sentOne(text: Editable)
    }

}