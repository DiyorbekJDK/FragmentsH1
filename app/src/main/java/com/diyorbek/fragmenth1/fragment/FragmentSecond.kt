package com.diyorbek.fragmenth1.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.diyorbek.fragmenth1.R

class FragmentSecond : Fragment() {
    private lateinit var editTExt2: EditText
    private var secondListener: SecondListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.btn2)
        editTExt2 = view.findViewById(R.id.editText2)
        button.setOnClickListener {
            secondListener?.sendTwo(editTExt2.text)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        secondListener = if (context is SecondListener)
            context
        else
            throw  java.lang.RuntimeException("Errror in Two!!!!!!!!!")
    }

    override fun onDetach() {
        super.onDetach()
        secondListener = null
    }

    fun twoText(text: Editable) {
        editTExt2.text = text
    }

    interface SecondListener {
        fun sendTwo(text: Editable)
    }
}