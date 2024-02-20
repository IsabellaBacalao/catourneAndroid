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
        val viewPlayer = view.findViewById<TextView>(R.id.afficheplayers)

        // Observe changes in the list of teams
        teamViewModel.allTeams.observe(viewLifecycleOwner, Observer { teams ->
            if (teams != null) {
                val teamNames = teams.joinToString(",") { it.statusTeam }
                viewPlayer.text = teamNames
            } else {
                viewPlayer.text = "No teams available"
            }
        })
        teamViewModel.getAllTeams()
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->
            if (users != null) {
                val usersNames = users.joinToString(",") { it.pseudo }
                viewPlayer.text = usersNames
            } else {
                viewPlayer.text = "No teams available"
            }
        })

        // Observe the LiveData in your ViewModel
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->
            val usersNames = users.joinToString("\n") { it.pseudo }
            viewPlayer.text = usersNames
        })



        return view
    }
}