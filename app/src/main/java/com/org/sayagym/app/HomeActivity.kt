package com.org.sayagym.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

      val bundle =intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?:"",provider?:"")
        //aqui recuperamos los datos de email y contraseña guardados en los extras


    }
    private fun setup(email: String, provider: String){
        val emailText:TextView = findViewById(R.id.textViewEmailLOgOut)
        val providerText:TextView = findViewById(R.id.textViewProvider)
        emailText.text=email
        providerText.text=provider

        val logOutButton:Button = findViewById(R.id.logOutButton)
        logOutButton.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

        val infoPersonalButton:Button = findViewById(R.id.infoPersonalButton)
        infoPersonalButton.setOnClickListener{
            val personalInfoIntent = Intent(this, PersonalInfoActivity::class.java).apply {
            putExtra("email",email)

            }
            startActivity(personalInfoIntent)
        }

        val couchButton:Button = findViewById(R.id.couchButton)
        couchButton.setOnClickListener{
            val couchingIntent = Intent(this, CouchingActivity::class.java).apply {
                putExtra("email",email)
            }
            startActivity(couchingIntent)
        }

        val nutririonButton:Button = findViewById(R.id.nutritionButton)
        nutririonButton.setOnClickListener{
            val nutritionIntent = Intent(this, nutritionActivity::class.java).apply {
                putExtra("email", email)
            }
            startActivity(nutritionIntent)
        }

    }

}