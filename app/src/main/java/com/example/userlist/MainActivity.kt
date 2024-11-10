package com.example.userlist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.tracing.perfetto.handshake.protocol.Response
import com.example.userlist.retrofitInstance.ApiService
import com.example.userlist.retrofitInstance.RetrofitInstance
import com.example.userlist.ui.theme.UserListTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)



        val myList: LiveData<Result<UserListAlbum>> = liveData {
            val response = RetrofitInstance.getRetrofitInstance().create(ApiService::class.java)
                .getSpecificAlbums(
                    2
                )
        }

    }



    }
