package com.org.sayagym.app

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class nutritionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition)
        val bundle =intent.extras
        val email = bundle?.getString("email")
        var day:String
        val days = arrayOf("Lunes", "Martes", "Miercoles", "Jueves","Viernes","Sabado","Domingo")
        val daysIn = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Fryday",
                            "Saturday","Sunday")

        val db = FirebaseFirestore.getInstance()

        val adapter= ArrayAdapter(this, android.R.layout.simple_spinner_item,days)
        val spinnerDays:Spinner = findViewById(R.id.listDays)
        val breakfast:TextView = findViewById(R.id.breakfast)
        val lunch:TextView = findViewById(R.id.lunch)
        val dinner:TextView = findViewById(R.id.dinner)
        spinnerDays.adapter= adapter

        val selectedDay:TextView = findViewById(R.id.texDietDay)

        spinnerDays.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedDay.text = days[position]
               day = daysIn[position]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val  getDiet:Button = findViewById(R.id.getDietButton)
        getDiet.setOnClickListener {
            db.collection("diets_users")
                .document(email.toString())
                .collection("Foods")
                .document(selectedDay.text.toString())
                .get()
                .addOnSuccessListener {
                    if(it.exists()){
                       val b = it.get("Breakfast") as String?
                        val l = it.get("Lunch") as String?
                        val d = it.get("Dinner") as String?

                        breakfast.text = b
                        lunch.text = l
                        dinner.text = d
                    }else{
                        breakfast.text = ""
                        lunch.text = ""
                        dinner.text = ""
                    }
                }
        }
    }
}