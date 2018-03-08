package com.nossafirma.firebaseapp.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseUser
//import jdk.nashorn.internal.runtime.ECMAException.getException
//import org.junit.experimental.results.ResultMatchers.isSuccessful
import com.nossafirma.firebaseapp.firebaseapp.extensions.getText


class LoginActivity : AppCompatActivity() {

    //private var mAuth: FirebaseAuth? = null
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        btLogin.setOnClickListener {
            mAuth.signInWithEmailAndPassword(inputEmail.getText(), inputSenha.getText())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = mAuth.currentUser
                            Toast.makeText(this, "Success!",
                                    Toast.LENGTH_SHORT).show()
//                            updateUI(user)
                        } else {
                            Toast.makeText(this, task.exception?.message,
                                    Toast.LENGTH_SHORT).show()
//                            updateUI(null)
                        }

                        // ...
                    }
        }

        btLogout.setOnClickListener {
            mAuth.signOut()
            Toast.makeText(this, "Disconnected...",
                    Toast.LENGTH_SHORT).show()
        }

        btCriarConta.setOnClickListener {
            mAuth.createUserWithEmailAndPassword(inputEmail.getText(), inputSenha.getText())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = mAuth.currentUser
//                            updateUI(user)
                        } else {
                            Toast.makeText(this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
//                            updateUI(null)
                        }

                        // ...
                    }
        }

        btEnviarEmail.setOnClickListener {
            val user = mAuth.currentUser
            user?.sendEmailVerification()
                    ?.addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {

                        } else {

                        }
                    })
        }


    }
}
