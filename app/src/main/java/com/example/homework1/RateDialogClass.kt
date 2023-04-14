package com.example.homework1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.*
import androidx.fragment.app.DialogFragment

class RateDialogClass:DialogFragment(R.layout.rate_dialog) {
    override fun onViewCreated(view:View,savedInstanceState:Bundle?){

        val submit:Button=view.findViewById(R.id.submitBtn)
        val cancel:Button=view.findViewById(R.id.cancelBtn)
        val radioGroup=view.findViewById<RadioGroup>(R.id.rateRadioGroup)

        cancel.setOnClickListener{
            dismiss()
        }

        submit.setOnClickListener{
            val selectedOption:Int=radioGroup.checkedRadioButtonId
            val radioButton=view.findViewById<RadioButton>(selectedOption)

            if(radioButton.isChecked){

            Toast.makeText(context,radioButton.text.toString().plus(" ").plus("was clicked"),Toast.LENGTH_SHORT).show()
            dismiss()}

            Toast.makeText(context,"Nothing selected",Toast.LENGTH_SHORT).show()
            dismiss()

        }

    }
}