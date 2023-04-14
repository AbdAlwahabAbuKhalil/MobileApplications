package com.example.homework1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

/**
 * A simple [Fragment] subclass.
 * Use the [calculator.newInstance] factory method to
 * create an instance of this fragment.
 */
class calculator : Fragment() {
    private lateinit var view: View
    private lateinit var number: EditText
    private lateinit var show: TextView
    private lateinit var foodType: Spinner
    private lateinit var price: TextView
    private lateinit var button:Button

    private var flag: String = "Shawrma"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calculator, container, false)
        number = view.findViewById(R.id.numberOfOrder)
        show = view.findViewById(R.id.answer)
        foodType = view.findViewById(R.id.spinnerType)
        price = view.findViewById(R.id.pricePiece)
        button=view.findViewById(R.id.btnCalc)
        number.setText("1")

        button.setOnClickListener{
            var x:Int=number.text.toString().toInt()
            show.text=calculate(flag,x).toString() + " JD"


        }

        var options= arrayOf("Shawrma","Pizza")
        foodType.adapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, options)

        foodType.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
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

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment calculator.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            calculator().apply {
                arguments = Bundle().apply {

                }
            }
    }
}

public fun calculate(a :String,b: Int) :Double{
    if(a=="Shawrma")
        return b*1.5
    else
        return b*2.0
}
