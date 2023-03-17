package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
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



}
public fun calculate(a :String,b: Int) :Double{
    if(a=="Shawrma")
        return b*1.5
    else
        return b*2.0
}