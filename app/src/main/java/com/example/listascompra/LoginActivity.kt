package com.example.listascompra

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.inflate
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.listascompra.databinding.ActivityLoginBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: String
    private val SIGN_IN_CODE = 310
    private lateinit var binding: ActivityLoginBinding
    /*private lateinit var constraintLayout: ConstraintLayout
    private lateinit var buttonSignIn: Button
    private lateinit var buttonSignUp: Button
    private lateinit var textviewUsername: TextView
    private lateinit var textviewPassword: TextView*/
    /*private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //constraintLayout = findViewById(R.id.activity_login_cl)
        //buttonSignUp = findViewById(R.id.button_sign_up)
        //buttonSignIn = findViewById(R.id.button_login)
        //textviewUsername = findViewById(R.id.textview_username)
        //textviewPassword = findViewById(R.id.textview_password)
        auth = Firebase.auth

        binding.buttonSignUp.setOnClickListener(View.OnClickListener {
            if(!binding.textviewUsername.text.isNullOrEmpty() && !binding.textviewPassword.text.isNullOrEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.textviewUsername.text.toString(),binding.textviewPassword.text.toString())
                    .addOnCompleteListener(OnCompleteListener {
                        if (it.isSuccessful) {
                            //user = auth.currentUser?.uid.toString()
                            mainActivity()
                        } else {
                            println("Error en el registro")
                        }
                    })

            }
        })

        binding.buttonLogin.setOnClickListener(View.OnClickListener {
            if(binding.textviewUsername.text.isNullOrEmpty() && !binding.textviewPassword.text.isNullOrEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.textviewUsername.text.toString(),binding.textviewPassword.text.toString())
                    .addOnCompleteListener(OnCompleteListener {
                        if (it.isSuccessful) {
                            //user = auth.currentUser?.uid.toString()
                            mainActivity()
                        } else {
                            println("Error en el acceso")
                        }
                    })

            }
        })

        binding.buttonGoogle.setOnClickListener(View.OnClickListener {
            val googleConfig = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .requestId()

            val googleCli = GoogleSignIn.getClient(this, googleConfig.build())

            startActivityForResult(googleCli.signInIntent, SIGN_IN_CODE)
        })

    }

    override fun onStart() {
        super.onStart()

        if(auth.currentUser != null) {
            user = FirebaseAuth.getInstance().currentUser?.uid.toString()
            println("Usuario ya conectado: $user")

            mainActivity()
        } else {
            showViews()
        }
    }

    private fun showViews() {
        //activity_login_cl.visibility = View.VISIBLE
        binding.activityLoginCl.visibility = View.VISIBLE
    }

    private fun mainActivity() {
      val intent = Intent(this, MainActivity::class.java)
        //intent.putExtra("username", user)

        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == SIGN_IN_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)

                if(account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener {
                            if(it.isSuccessful) {
                                mainActivity()
                            } else {
                                println("Error inicio de sesión con Google")
                            }
                        }
                }
            } catch (e: ApiException) {
                println("Error")
            }



        }
    }

}