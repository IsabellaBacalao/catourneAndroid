package com.example.catourneandroid

import TeamViewModel
import UserViewModel
import android.os.Bundle
import com.example.catourneandroid.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.catourneandroid.database.entity.TeamEntity
import com.example.catourneandroid.database.entity.UserEntity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val teamViewModel: TeamViewModel by viewModels(factoryProducer = { TeamViewModel.provideFactory() })
    private val userViewModel: UserViewModel by viewModels(factoryProducer = { UserViewModel.provideFactory() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --------- TEAMS
        val teamYellow1 = TeamEntity(idTeam = 1, statusTeam = "yellow", positionTeam = 1)
        val teamYellow2 = TeamEntity(idTeam = 2, statusTeam = "yellow", positionTeam = 2)

        val teamRed1 = TeamEntity(idTeam = 3, statusTeam = "red", positionTeam = 1)
        val teamRed2 = TeamEntity(idTeam = 4, statusTeam = "red", positionTeam = 2)

        teamViewModel.insertTeam(teamYellow1)
        teamViewModel.insertTeam(teamYellow2)
        teamViewModel.insertTeam(teamRed1)
        teamViewModel.insertTeam(teamRed2)

        //val teamsTextView: TextView = findViewById(R.id.teamsTextView)

        // --------- USERS

        // Observe changes in the list of teams
        teamViewModel.allTeams.observe(this, Observer { teams ->
            val teamNames = teams.joinToString("\n") { it.statusTeam }
            //teamsTextView.text = teamNames
        })

        teamViewModel.getAllTeams()

        // Observe the LiveData in your ViewModel
        userViewModel.allUsers.observe(this, Observer { users ->
            // Update UI with the list of users
        })

        // Example: Inserting a user
        val user = UserEntity( pseudo = "User1", idTeam = 1)
        userViewModel.insertUser(user)
    }
}