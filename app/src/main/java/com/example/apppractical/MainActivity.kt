package com.example.apppractical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.apppractical.ApiInterface
import com.example.apppractical.RetrofitClient
import com.example.apppractical.UserData
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUserList()
    }

    fun getUserList() {
        var apiInterface = RetrofitClient.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val res = apiInterface.getAllUsers()
                if (res.isSuccessful()) {
                    rvUser.layoutManager = LinearLayoutManager(applicationContext)
                    val adapter = res.body()?.data?.let { UserAdapter(this@MainActivity, it) }
                    rvUser.adapter = adapter
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        res.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (ex:Exception){
                println("response error")
            }
        }

    }

}