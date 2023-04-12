package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import android.*
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

import android.widget.Toast
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val number:EditText=findViewById(R.id.numberOfOrder)
        val show:TextView=findViewById(R.id.answer)
        val foodType:Spinner=findViewById(R.id.spinnerType)
        val price:TextView=findViewById(R.id.pricePiece)
        var flag:String="Shawrma"
        

        number.setText("1")

        var options= arrayOf("Shawrma","Pizza")
        foodType.adapter=
            ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        foodType.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                flag=options.get(position)
                if(flag=="Shawrma")
                    price.text="1.5"
                else
                    price.text="2"

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val button:Button=findViewById(R.id.btnCalc)
        button.setOnClickListener{
            var x:Int=number.text.toString().toInt()
            show.text=calculate(flag,x).toString() + " JD"


        }


    }
    override fun onCreateOptionsMenu(menu:Menu):Boolean{
        val inflater=menuInflater
        inflater.inflate(R.menu.star_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var RateDialog=RateDialogClass()
        RateDialog.show(supportFragmentManager,"Rate")

        return true;
    }


}
public fun calculate(a :String,b: Int) :Double{
    if(a=="Shawrma")
        return b*1.5
    else
        return b*2.0
}