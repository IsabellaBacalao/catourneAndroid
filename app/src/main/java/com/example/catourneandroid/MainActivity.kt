package com.example.catourneandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catourneandroid.database.MyDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getTeams = MyDatabase.getDatabase(this).teamDao().getAllTeams();
        //call getTeams dans un view model pour visualiser
    }
}