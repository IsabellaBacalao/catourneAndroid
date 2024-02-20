package com.example.catourneandroid

import TeamViewModel
import UserViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

class GameOn : Fragment() {

    private val teamViewModel: TeamViewModel by viewModels(factoryProducer = { TeamViewModel.provideFactory() })
    private val userViewModel: UserViewModel by viewModels(factoryProducer = { UserViewModel.provideFactory() })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_game_on, container, false)

        /*// Observe changes in the list of teams
        teamViewModel.allTeams.observe(viewLifecycleOwner, Observer { teams ->
            val teamNames = teams.joinToString("\n") { it.statusTeam }

            //teamsTextView.text = teamNames
        })*/


        val viewPlayer = view.findViewById<TextView>(R.id.afficheplayers)

        teamViewModel.getAllTeams()

        // Observe the LiveData in your ViewModel
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->
            val userNames = users.joinToString("\n") { it.pseudo }
            viewPlayer.text = userNames
        })



        return view
    }
}