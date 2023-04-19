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

var tester=1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val calc=calculator()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.showFragment,calc)
            commit()
        }





    }
    override fun onCreateOptionsMenu(menu:Menu):Boolean{
        val inflater=menuInflater
        inflater.inflate(R.menu.star_menu,menu)
        inflater.inflate(R.menu.resturent,menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        //var id: String = item.itemId.toString()
        var title:String=item.title.toString()
        //Toast.makeText(this,title,Toast.LENGTH_SHORT).show()
        //2131231137
        if (title == "Rate") {
            var RateDialog = RateDialogClass()
            RateDialog.show(supportFragmentManager, "Rate")
        } else {
            val calc = calculator()
            val product = menue()
            if (tester == 1) {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.showFragment, product)
                    commit()
                }
                tester = 0

            } else {

                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.showFragment, calc)
                    commit()
                }
                tester = 1
            }

        }
        return true;
    }
}
