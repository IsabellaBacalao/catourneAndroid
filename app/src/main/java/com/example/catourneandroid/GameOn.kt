package com.example.catourneandroid

import TeamViewModel
import UserViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.catourneandroid.database.entity.UserEntity

class GameOn : Fragment() {

    private val teamViewModel: TeamViewModel by viewModels(factoryProducer = { TeamViewModel.provideFactory() })
    private val userViewModel: UserViewModel by viewModels(factoryProducer = { UserViewModel.provideFactory() })
    /*
    YELLOW ATTAQUE      1
    YELLOW DEF          2

    RED ATTAQUE         3
    RED DEF             4
     */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_game_on, container, false)

        //GET ALL OF THE PLAYERS
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->
            displayPseudosByTeam(users, view)
        })
        userViewModel.getAllUsers()

        return view
    }

    @SuppressLint("ResourceAsColor")
    private fun displayPseudosByTeam(users: List<UserEntity>, view: View, ){

        val y_attaque = view.findViewById<TextView>(R.id.yellow_team_atq)
        val y_def = view.findViewById<TextView>(R.id.yellow_team_def)
        val r_attaque = view.findViewById<TextView>(R.id.red_team_atq)
        val r_def = view.findViewById<TextView>(R.id.red_team_def)


        for (user in users) {
            val teamId = user.idTeam
            val pseudo = user.pseudo
            when (teamId) {
                1 -> {y_attaque.text = pseudo}
                2 -> {y_def.text = pseudo}
                3 -> {r_attaque.text = pseudo}
                4 -> {r_def.text = pseudo}
                5 -> {
                    val layoutWaitingPlayers = view.findViewById<LinearLayout>(R.id.layout_waiting_players_zone)

                    val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
                    params.setMargins(5, 1, 10, 3)
                    val waitingPlayer = TextView(context)

                    waitingPlayer.layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    params.gravity = Gravity.CENTER
                    waitingPlayer.layoutParams = params
                    waitingPlayer.text = pseudo
                    waitingPlayer.setTextColor(R.color.white)
                    waitingPlayer.gravity = Gravity.CENTER
                    waitingPlayer.textSize = 20F
                    waitingPlayer.setTextAppearance(R.style.PlayersListStyle)
                    layoutWaitingPlayers.addView(waitingPlayer)
                }
            }
        }
    }
}