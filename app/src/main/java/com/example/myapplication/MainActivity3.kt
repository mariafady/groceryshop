package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*


class MainActivity3 : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var button: Button
    lateinit var button2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var editText: EditText
        var editText2: EditText
        var editText3: EditText
        var button: Button
        var button2: Button
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        editText = findViewById(R.id.edittext)
        editText2 = findViewById(R.id.edittext2)
        editText3 = findViewById(R.id.edittext3)
        val bundle : Bundle? = intent.extras
        val email : String? = intent.getStringExtra("email")
        val password : String? = intent.getStringExtra("password")
        val User: user = user(email.toString(), password.toString())



        button.setOnClickListener( object : View.OnClickListener {
            override fun onClick(p0: View) {
                User.setFirstName(editText.toString())
                User.setLastName(editText2.toString())
                User.setPhoneNumber(editText3.toString())
                Toast.makeText(this@MainActivity3,"Saved !",Toast.LENGTH_LONG).show()
            }

        } )
        button2.setOnClickListener( object : View.OnClickListener {
            override fun onClick(p0: View) {
                val intent =  Intent(this@MainActivity3,MainActivity2::class.java)
                intent.putExtra("user", User.toString())
                startActivity(intent)
            }

        } )
    }
}