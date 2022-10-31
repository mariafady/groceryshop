package com.example.myapplication


import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bundle : Bundle? = intent.extras
        val string : String? = intent.getStringExtra("email")
        val string1 : String? = intent.getStringExtra("password")
        var button: Button
        var button2: Button
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                startActivity(Intent(this@MainActivity2,MapsActivity::class.java))
            }

        })

        button2.setOnClickListener( object : View.OnClickListener {
            override fun onClick(p0: View) {
                val intent =  Intent(this@MainActivity2,MainActivity3::class.java)
                intent.putExtra("email", string)
                intent.putExtra("password", string1)
                startActivity(intent)
            }

    } )
}}