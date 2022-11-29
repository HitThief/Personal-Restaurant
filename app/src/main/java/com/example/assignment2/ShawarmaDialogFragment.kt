package com.example.assignment2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.assignment2.R

class ShawarmaDialogFragment : DialogFragment(R.layout.fragment_shawarma_dialog){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cancelbt: Button= view.findViewById(R.id.buttonCancel)
        val confirmbt: Button= view.findViewById((R.id.buttonConfirm))
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)

        cancelbt.setOnClickListener {
            dismiss()
        }

        val cp1 = view.findViewById<RadioButton>(R.id.rdButton1)
        val cp2 = view.findViewById<RadioButton>(R.id.rdButton2)


        confirmbt.setOnClickListener {
            val selectedOption: Int= radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)


            Toast.makeText(context,radioButton.text,Toast.LENGTH_SHORT).show()
            var str: String=""
            var price: Float = 0F

            if(radioButton == cp1){
                str ="Chicken"
                price=4F

            }
            else if (radioButton == cp2){
                str="Meat"
                price=5F

            }

            val m1:MainActivity = getActivity() as MainActivity;
            m1.receiveFeedback(price)

            dismiss()

        }
    }
}