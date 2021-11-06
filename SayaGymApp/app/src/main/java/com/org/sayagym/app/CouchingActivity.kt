package com.org.sayagym.app
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.org.sayagym.app.data.repo.FirebaseRepo
class CouchingActivity : AppCompatActivity() {
     val firebase = FirebaseRepo()
     val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_couching)
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val couches = arrayOf("marta", "Marcos")
        val routines = arrayOf("Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5","Dia 6")
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item,couches)
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item,routines)
        val spinner: Spinner = findViewById(R.id.coachesList)
        val spinnerTwo:Spinner = findViewById(R.id.routinesList)
        val selected:TextView = findViewById(R.id.coachSelected)
        val routine:TextView = findViewById(R.id.rutineSelected)
        val selectCoach:Button = findViewById(R.id.saveCoach)
        val textCoach:TextView = findViewById(R.id.textCoach)
        val exe1:TextView=findViewById(R.id.exe1)
        val exe2:TextView=findViewById(R.id.exe2)
        val exe3:TextView=findViewById(R.id.exe3)
        val exe4:TextView=findViewById(R.id.exe4)
        val exe5:TextView=findViewById(R.id.exe5)
        val exe6:TextView=findViewById(R.id.exe6)
        val exe7:TextView=findViewById(R.id.exe7)
        val exe8:TextView=findViewById(R.id.exe8)
        val exe9:TextView=findViewById(R.id.exe9)
        val exe10:TextView=findViewById(R.id.exe10)
        spinner.adapter = adapter2
        spinnerTwo.adapter = adapter1

        spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selected.text = couches[position]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spinnerTwo.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                routine.text = routines[position]

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
                }
            }


        db.collection("users_information").document(email.toString()).get().
        addOnSuccessListener {
            val c= it.get("coach") as String?
            if(c != null){
                textCoach.text = "Tu entrenador seleccionado es:"
                selected.text = it.get("coach") as String?
                spinner.visibility=View.GONE
                selectCoach.visibility =View.GONE
            }else{
                spinner.visibility= View.VISIBLE
                selectCoach.visibility= View.VISIBLE
            }
        }

            selectCoach.setOnClickListener{
                db.collection("users_information").document(email.toString()).get().
                addOnSuccessListener {
                   val c= it.get("coach") as String?
                    if(c != null){
                        textCoach.text= "Tu entrenador seleccionado es:"
                        selected.text = it.get("coach") as String?
                        spinner.visibility=View.GONE
                        selectCoach.visibility =View.GONE
                    }else{
                        firebase.dataCoach(email.toString(),selected.text.toString())
                    }
                }
            }

        val selectRoutine:Button= findViewById(R.id.selectRoutinebtn)
        selectRoutine.setOnClickListener{
            db.collection(selected.text.toString()).document(routine.text.toString()).get().addOnSuccessListener {
                if(it.exists()) {
                    exe1.text = it.get("R1") as String?
                    exe2.text = it.get("R2") as String?
                    exe3.text = it.get("R3") as String?
                    exe4.text = it.get("R4") as String?
                    exe5.text = it.get("R5") as String?
                    exe6.text = it.get("R6") as String?
                    exe7.text = it.get("R7") as String?
                    exe8.text = it.get("R8") as String?
                    exe9.text = it.get("R9") as String?
                    exe10.text = it.get("R10") as String?
                    setFragment()
                }else{
                    exe1.text = ""
                    exe2.text = ""
                    exe3.text = ""
                    exe4.text = ""
                    exe5.text = ""
                    exe6.text = ""
                    exe7.text = ""
                    exe8.text = ""
                    exe9.text = ""
                    exe10.text = ""
                }
            }
        }
    }

    private fun setFragment() {
         val fragment = Frag_Coaches()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.startRoutine,fragment)
        fragmentTransaction.commit()
    }
}