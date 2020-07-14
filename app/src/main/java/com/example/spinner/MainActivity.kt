package com.example.spinner

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

   private var spCity: Spinner? = null
   private var Text: TextView?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        spinner()
        initClicks()
    }



    private fun initClicks(){
        spCity?.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext,"вы выбрали"+selectedItem,Toast.LENGTH_LONG).show()
                Text?.text= selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }


private fun spinner(){
    val adapt = ArrayAdapter.createFromResource(this, R.array.Cities,android.R.layout.simple_spinner_item)
    adapt.setDropDownViewResource(android.R.layout.simple_spinner_item)
    spCity?.adapter=adapt
}

    private fun initViews(){
     spCity = findViewById<Spinner>(R.id.spCity)
    Text= findViewById(R.id.Text)
}

}
