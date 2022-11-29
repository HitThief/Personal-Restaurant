package com.example.assignment2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.assignment2.R

class BurgerDialogFragment : DialogFragment(R.layout.fragment_burger_dialog){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cancelbt: Button= view.findViewById(R.id.buttonCancel)
        val confirmbt: Button= view.findViewById((R.id.buttonConfirm))
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)

        cancelbt.setOnClickListener {
            dismiss()
        }

        val cp1 = view.findViewById<RadioButton>(R.id.rdButtonChicken)
        val cp2 = view.findViewById<RadioButton>(R.id.rdButtonMeat)
        val cp3 = view.findViewById<RadioButton>(R.id.rdButtonFish)


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
            else if (radioButton == cp3){
                str="Fish"
                price=6F

            }

            val m1:MainActivity = getActivity() as MainActivity;
            m1.receiveFeedback(price)

            dismiss()

        }
    }
}