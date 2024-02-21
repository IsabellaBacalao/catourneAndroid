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
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.catourneandroid.database.entity.UserEntity

class GameOn : Fragment() {

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

        //GET ALL PLAYERS WAITING LIST
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { usersWaiting ->
            displayPseudosWaitingList(usersWaiting, view)
        })
        userViewModel.getUserByIdTeam(5)

        val btnPointForYellow = view.findViewById<ImageButton>(R.id.btnButYellow)
        btnPointForYellow.setOnClickListener{
            changeOfPlayersRedTeam()
        }
        val btnPointForRed = view.findViewById<ImageButton>(R.id.btnButRed)
        btnPointForRed.setOnClickListener{
            changeOfPlayersYellowTeam()
        }

        return view
    }
    private fun changeOfPlayersYellowTeam(){
        //CHANGE OF ATTAQUE
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { usersPlaying ->
            val redTeam = usersPlaying.filter { it.idTeam == 3 || it.idTeam == 4 }
            val yellowTeam = usersPlaying.filter { it.idTeam == 1 || it.idTeam == 2 }
            //CHANGE POSITION OF THE PLAYERS
            for (user in yellowTeam){
                if (user.idTeam == 1){
                    //UPDATE ID TEAM == > 2

                }else{
                    // UPDATE ID TEAM == > 5

                    val userGoToWaitingList = user
                }
            }
            //ADD SCORE TO THE PLAYERS OF RED TEAM
            for (user in redTeam){
                //UPDATE SCORE == > +1
            }
        })
        userViewModel.getUsersByPosition(0)

        // CHANGE OF THE WAITING LIST
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { usersWaiting ->
            val maxIdTeam: Int? = usersWaiting.maxByOrNull { it.idTeam }?.idTeam
            //RECHERCHE DU DERNIER WAITING LIST
            //UPDATE POSITION ID de userGoToWaitingList ==> maxIdTeam
            val sortedWaitingList = usersWaiting.sortedBy { it.userPosition }
            for (user in sortedWaitingList){
                if(user.userPosition == 1){
                    // PREMIER DE LA WAITING LIST ENTRE EN JEU
                    // ID TEAM == > 1
                    // POSITION ID == > 0
                }else{
                    // CHANGEMENT POSITION ID
                    // user.userPosition == > position-1
                }
            }
        })
        userViewModel.getUserByIdTeam(5)

    }
    private fun changeOfPlayersRedTeam(){
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { usersPlaying ->
            val redTeam = usersPlaying.filter { it.idTeam == 3 || it.idTeam == 4 }
            val yellowTeam = usersPlaying.filter { it.idTeam == 1 || it.idTeam == 2 }
            //CHANGE POSITION OF THE PLAYERS
            for (user in redTeam){
                if (user.idTeam == 3){
                    //UPDATE ID TEAM == > 4

                }else{
                    // UPDATE ID TEAM == > 5
                    val userGoToWaitingList = user
                }
            }
            //ADD SCORE TO THE PLAYERS OF RED TEAM
            for (user in yellowTeam){
                //UPDATE SCORE == > +1
            }
        })
        userViewModel.getUsersByPosition(0)

        // CHANGE OF THE WAITING LIST
        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { usersWaiting ->
            val maxIdTeam: Int? = usersWaiting.maxByOrNull { it.idTeam }?.idTeam
            //RECHERCHE DU DERNIER WAITING LIST
            //UPDATE POSITION ID de userGoToWaitingList ==> maxIdTeam
            val sortedWaitingList = usersWaiting.sortedBy { it.userPosition }
            for (user in sortedWaitingList){
                if(user.userPosition == 1){
                    // PREMIER DE LA WAITING LIST ENTRE EN JEU
                    // ID TEAM == > 3
                    // POSITION ID == > 0
                }else{
                    // CHANGEMENT POSITION ID
                    // user.userPosition == > position-1
                }
            }
        })
        userViewModel.getUserByIdTeam(5)
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
            }
        }
    }
    @SuppressLint("ResourceAsColor")
    private fun displayPseudosWaitingList(users: List<UserEntity>, view: View, ){

        val layoutWaitingPlayers = view.findViewById<LinearLayout>(R.id.layout_waiting_players_zone)

        val sortedWaitingList = users.sortedBy { it.userPosition }
        for (user in sortedWaitingList){
            val pseudo = user.pseudo

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