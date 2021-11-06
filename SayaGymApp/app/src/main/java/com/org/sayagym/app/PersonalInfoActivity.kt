package com.org.sayagym.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.org.sayagym.app.data.repo.FirebaseRepo


class PersonalInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)
        createUser()
        showHome()
        getData()


    }
    private fun createUser(){

        val bundle =intent.extras
        val email = bundle?.getString("email")

        val name: EditText = findViewById(R.id.textPersonName)
        val lastName: EditText = findViewById(R.id.textPersonLastName)
        val age: EditText = findViewById(R.id.textAge)
        val size: EditText = findViewById(R.id.textSize)
        val finalSize: EditText = findViewById(R.id.textFInalSize)
        val arms: EditText = findViewById(R.id.textArms)
        val legs: EditText = findViewById(R.id.textLegs)
        val shoulder: EditText = findViewById(R.id.textShoulders)
        val chest: EditText = findViewById(R.id.textChest)
        val finalArms: EditText = findViewById(R.id.textFinalArms)
        val finalLegs: EditText = findViewById(R.id.textFinalLegs)
        val finalShoulders: EditText = findViewById(R.id.textFinalShoulders)
        val finalChest: EditText = findViewById(R.id.textFinalChest)

        val model = FirebaseRepo()
        val save: Button = findViewById(R.id.saveButton)


        save.setOnClickListener{
            model.setDataUser(name.text.toString().trim(),lastName.text.toString().trim(),age.text.toString().trim(),
                size.text.toString().trim(),finalSize.text.toString().trim(),arms.text.toString().trim(),legs.text.toString().trim(),
                shoulder.text.toString().trim(),chest.text.toString().trim(),finalArms.text.toString().trim(),
                finalLegs.text.toString().trim(),finalShoulders.text.toString().trim(),finalChest.text.toString().trim(),
                email.toString())
        }
        val getData: Button = findViewById(R.id.getInfoButton)
        getData.setOnClickListener{
            getData()
        }

        val delete:Button = findViewById(R.id.deleteButton)
        delete.setOnClickListener{
            model.deleteDataUser(email.toString())
        }
    }



    private fun getData(){
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val db = FirebaseFirestore.getInstance()

        val name: EditText = findViewById(R.id.textPersonName)
        val lastName: EditText = findViewById(R.id.textPersonLastName)
        val age: EditText = findViewById(R.id.textAge)
        val size: EditText = findViewById(R.id.textSize)
        val finalSize: EditText = findViewById(R.id.textFInalSize)
        val arms: EditText = findViewById(R.id.textArms)
        val legs: EditText = findViewById(R.id.textLegs)
        val shoulder: EditText = findViewById(R.id.textShoulders)
        val chest: EditText = findViewById(R.id.textChest)
        val finalArms: EditText = findViewById(R.id.textFinalArms)
        val finalLegs: EditText = findViewById(R.id.textFinalLegs)
        val finalShoulders: EditText = findViewById(R.id.textFinalShoulders)
        val finalChest: EditText = findViewById(R.id.textFinalChest)

        db.collection("users_information").document(email.toString()).get().addOnSuccessListener {

               name.setText(it.get("name") as String?)
               lastName.setText(it.get("last name") as String?)
               age.setText(it.get("age") as String?)
               size.setText(it.get("size") as String?)
               finalSize.setText(it.get("finalSize") as String?)
               arms.setText(it.get("arms") as String?)
               legs.setText(it.get("legs") as String?)
               shoulder.setText(it.get("shoulders") as String?)
               chest.setText(it.get("chest") as String?)
               finalArms.setText(it.get("finalArmas") as String?)
               finalLegs.setText(it.get("finalLegs") as String?)
               finalShoulders.setText(it.get("finalShoulders") as String?)
               finalChest.setText(it.get("finalChest") as String?)


        }
    }

    private fun showHome() {
        val backHomeButton: Button = findViewById(R.id.backHomeButton)

        backHomeButton.setOnClickListener {
            onBackPressed()
        }

    }
    private fun showAlert(){

    }
}
