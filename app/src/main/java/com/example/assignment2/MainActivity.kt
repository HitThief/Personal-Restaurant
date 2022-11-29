package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.assignment2.PizzaDialogFragment
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tvPrice: TextView = findViewById(R.id.txtVwPrice)
        var flag : String = "cash"
        val spinnerVal : Spinner = findViewById(R.id.spinnerPaymentMethod)
        var options = arrayOf("cash","credit card")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        val btConfirm: Button = findViewById(R.id.buttonConfirm1)
        btConfirm.setOnClickListener(){
            val txtVw: TextView = findViewById(R.id.textView6)
            txtVw.text = "Please proceed to the counter and thank you for choosing us"
        }

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.food_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var pizzaDialog = PizzaDialogFragment()
        var shawarmaDialog = ShawarmaDialogFragment()
        var burgerDialog = BurgerDialogFragment()

        when (item.itemId) {
            //R.id.idPizza -> Toast.makeText(this, "Pizza selected", Toast.LENGTH_SHORT).show()
            R.id.idPizza -> pizzaDialog.show(supportFragmentManager,"pizzaDialog")
            R.id.idShawarma -> shawarmaDialog.show(supportFragmentManager, "shawarmaDialog")
            R.id.idBurger -> burgerDialog.show(supportFragmentManager, "burgerDialog")
        }

        return true
    }

    fun receiveFeedback(feedback: Float){
        val TVprice : TextView = findViewById(R.id.txtVwPrice)
        TVprice.text = feedback.toString()
    }
}


