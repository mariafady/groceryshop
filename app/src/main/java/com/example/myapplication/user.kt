package com.example.myapplication

class user {
    lateinit var username : String
    lateinit var password : String
    lateinit var firstname : String
    lateinit var lastname : String
    lateinit var phonenumber : String
  constructor(username:String, password: String){
      this.username = username
      this.password = password
    }
    fun setFirstName(firstname: String){
        this.firstname = firstname
    }
    fun setLastName(lastname : String){
        this.lastname = lastname
    }
    fun setPhoneNumber(phonenumber: String){
        this.phonenumber = phonenumber
    }
    override fun toString(): String{
        val string: String
        string = this.username + " " + this.password + " " + this.firstname + " " + this.lastname + " " + this.phonenumber
        return string
    }




}