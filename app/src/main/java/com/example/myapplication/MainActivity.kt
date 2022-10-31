package com.example.myapplication
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import extensions.Extensions.toast
import utils.FirebaseUtils.firebaseAuth


class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
   lateinit var editText: EditText
    lateinit var editText2: EditText
    lateinit var createAccountInputsArray: Array<EditText>
    lateinit var User: user


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = Firebase.database
        setContentView(R.layout.activity_main)
        createAccountInputsArray = arrayOf(edittext,edittext2)
        title = "GroceryApp"
        auth = FirebaseAuth.getInstance()
       editText = findViewById(R.id.edittext) as EditText
        editText2=findViewById(R.id.edittext2) as EditText

        this.button.setOnClickListener{
            val email = this.editText.getText().toString().trim()
            val password = this.editText2.getText().toString().trim()
            User= user(email,password)
            if(email.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent =  Intent(this@MainActivity,MainActivity2::class.java)
                        intent.putExtra("email", email)
                        intent.putExtra("password", password)
                        startActivity(intent)
                        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }

                }
            }else{
                Toast.makeText(this, "Empty Fields are not allowed", Toast.LENGTH_SHORT).show()
            }



        }




        this.button2.setOnClickListener{
            val email = this.editText.getText().toString().trim()
            val password = this.editText2.getText().toString().trim()
            if(email.isNotEmpty() && password.isNotEmpty()){
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if(it.isSuccessful){
                    this.editText.setText("Enter Username")
                    this.editText2.setText("Enter Password")
                    User= user(email,password)

                    Toast.makeText(this, "Please Sign In", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }

                }
            }else{
              Toast.makeText(this, "Empty Fields are not allowed", Toast.LENGTH_SHORT).show()
            }

        }






        




    }





        

    }



















