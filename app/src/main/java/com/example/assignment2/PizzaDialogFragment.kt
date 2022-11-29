package com.example.assignment2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.assignment2.R

class PizzaDialogFragment : DialogFragment(R.layout.fragment_pizza_dialog){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cancelbt: Button= view.findViewById(R.id.button9)
        val confirmbt: Button= view.findViewById((R.id.button8))
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)

        cancelbt.setOnClickListener {
            dismiss()
        }

        val cp1 = view.findViewById<RadioButton>(R.id.radioButton2)
        val cp2 = view.findViewById<RadioButton>(R.id.radioButton3)
        val cp3 = view.findViewById<RadioButton>(R.id.radioButton)


        confirmbt.setOnClickListener {
            val selectedOption: Int= radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)


            Toast.makeText(context,radioButton.text,Toast.LENGTH_SHORT).show()
            var str: String=""
            var price: Float = 0F

            if(radioButton == cp1){
                str ="margarita"
                price=4F

            }
            else if (radioButton == cp2){
                str="pepperoni"
                price=5F

            }
            else if (radioButton == cp3){
                str="fajita"
                price=5.5F
            }

            val m1:MainActivity = getActivity() as MainActivity;
            m1.receiveFeedback(price)

            dismiss()

        }
    }
}