package com.example.userlist

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.liveData
import com.example.userlist.retrofitInstance.ApiService
import com.example.userlist.retrofitInstance.RetrofitInstance

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val listView: ListView = findViewById(R.id.listView)
        textView.visibility = View.GONE

        val retrofitService = RetrofitInstance
            .getRetrofitInstance()
            .create(ApiService::class.java)

        val responseLiveData = liveData {
            try {
                val response = retrofitService.getUsers()
                emit(response)
            } catch (e: Exception) {
                textView.visibility = View.VISIBLE
                textView.text = "Error: ${e.message}"
            }
        }

        responseLiveData.observe(this) { response ->
            if (response.isSuccessful) {
                val usersResponse = response.body()
                usersResponse?.let { users ->
                    val adapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_2,
                        android.R.id.text1,
                        users.data
                    )
                    listView.adapter = adapter
                    textView.visibility = View.GONE
                }
            } else {
                textView.visibility = View.VISIBLE
                textView.text = "Error: ${response.code()} ${response.message()}"
            }
        }
    }
}