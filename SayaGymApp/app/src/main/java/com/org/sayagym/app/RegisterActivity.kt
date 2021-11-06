package com.org.sayagym.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "INICIO DE SESION"
        setup()

    }

    private fun setup() {

        val singUpButton: Button = findViewById(R.id.signUpButton)
        val loginButton: Button = findViewById(R.id.loginButton)
        val editTextMail: EditText = findViewById(R.id.editTextMail)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)
        singUpButton.setOnClickListener {
            if (editTextMail.text.isNotEmpty() && editTextPassword.text.isNotEmpty()) {

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    editTextMail.text.toString(),
                    editTextPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        showAlertUser()

                    }
                }

            }
        }

        loginButton.setOnClickListener {
            if (editTextMail.text.isNotEmpty() && editTextPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    editTextMail.text.toString(),
                    editTextPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email.toString()?: "", ProviderType.BASIC)
                    } else {
                        showAlert()

                    }
                }

            }

        }

    }


    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Usuario y/o constraseña son incorrectos intente nuevamente")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showAlertUser(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Usuario ya existente")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType) {

        val homeIntent = Intent(this, HomeActivity::class.java).apply {

            putExtra("email",email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

}