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
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.catourneandroid.database.entity.UserEntity
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.util.concurrent.TimeUnit

class GameOn : Fragment() {

    private val userViewModel: UserViewModel by viewModels(factoryProducer = { UserViewModel.provideFactory() })
    private var firstAppear = 0;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_game_on, container, false)

        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->

            displayPseudosByTeamAndWaitingList(view, users)

            val btnPointForYellow = view.findViewById<ImageButton>(R.id.btnButYellow)
            btnPointForYellow.setOnClickListener{
                changeOfPlayersRedTeam(users, view)
                displayPseudosByTeamAndWaitingList(view, users)
            }

            val btnPointForRed = view.findViewById<ImageButton>(R.id.btnButRed)
            btnPointForRed.setOnClickListener{
                changeOfPlayersYellowTeam(users, view)
                displayPseudosByTeamAndWaitingList(view, users)
            }
        })
        userViewModel.getAllUsers()

        val btnGoSeeScore = view.findViewById<ImageButton>(R.id.btnGoScore)
        btnGoSeeScore.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_gameOn_to_score)
        }

        return view
    }
    private fun changeOfPlayersYellowTeam(users: List<UserEntity>, view: View){

        val viewKonfetti = view.findViewById<KonfettiView>(R.id.konfettiView)
        //KONFETTI
        val party = Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xFF5733, 0xA1280E, 0xE18471, 0xEA2F45),
            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
            position = Position.Relative(0.5, 0.3)
        )
        viewKonfetti.start(party)


        val waiting = users.filter { it.idTeam == 5 }
        val maxIdTeam = waiting.maxByOrNull { it.userPosition }?.userPosition

        val redTeam = users.filter { it.idTeam == 3 || it.idTeam == 4 }
        val yellowTeam = users.filter { it.idTeam == 1 || it.idTeam == 2 }

        //UPDATE SCORE REDTEAM
        for (user in redTeam){
            user.score += 1;
            userViewModel.updateScore(user);
        }

        //CHANGE POSITION OF THE PLAYERS
        val yellowTeamDes = yellowTeam.sortedByDescending { it.idTeam }

        if (waiting.isNotEmpty()){
            for (user in yellowTeamDes){
                if(user.idTeam == 2){
                    //UPDATE ID TEAM == > 5
                    user.idTeam = 5;
                    userViewModel.updateIdTeamByUserId(user);
                    if (maxIdTeam != null) {
                        user.userPosition = maxIdTeam
                    };
                    userViewModel.updatePositionUser(user);
                }
                if (user.idTeam == 1){
                    //UPDATE ID TEAM == > 2
                    user.idTeam = 2;
                    userViewModel.updateIdTeamByUserId(user);
                }
            }
            for (user in waiting){
                if(user.idTeam == 5){
                    if(user.userPosition == 1){
                        // PREMIER DE LA WAITING LIST ENTRE EN JEU
                        // ID TEAM == > 1
                        user.idTeam = 1;
                        userViewModel.updateIdTeamByUserId(user);
                        // POSITION ID == > 0
                        user.userPosition = 0;
                        userViewModel.updatePositionUser(user);
                    }else{
                        // CHANGEMENT POSITION ID
                        // user.userPosition == > position-1
                        user.userPosition -= 1;
                        userViewModel.updatePositionUser(user);
                    }
                }

            }
        }

    }
    private fun changeOfPlayersRedTeam(users: List<UserEntity>, view: View){

        val viewKonfetti = view.findViewById<KonfettiView>(R.id.konfettiView)
        //KONFETTI
        val party = Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xF0D71D, 0xF3E835, 0xF9F205, 0xF3EFA0),
            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
            position = Position.Relative(0.5, 0.3)
        )
        viewKonfetti.start(party)

        val waiting = users.filter { it.idTeam == 5 }
        val maxIdTeam = waiting.maxByOrNull { it.userPosition }?.userPosition

        val redTeam = users.filter { it.idTeam == 3 || it.idTeam == 4 }
        val yellowTeam = users.filter { it.idTeam == 1 || it.idTeam == 2 }

        for (user in yellowTeam){
            user.score += 1;
            userViewModel.updateScore(user);
        }

        //CHANGE POSITION OF THE PLAYERS
        if (waiting.isNotEmpty()){
            val redTeamDes = redTeam.sortedByDescending { it.idTeam }
            for (user in redTeamDes){
                if(user.idTeam == 4){
                    //UPDATE ID TEAM == > 4
                    user.idTeam = 5;
                    userViewModel.updateIdTeamByUserId(user);
                    if (maxIdTeam != null) {
                        user.userPosition = maxIdTeam
                    };
                    userViewModel.updatePositionUser(user);
                }
                if (user.idTeam == 3){
                    //UPDATE ID TEAM == > 4
                    user.idTeam = 4;
                    userViewModel.updateIdTeamByUserId(user);
                }
            }
            //ADD SCORE TO THE PLAYERS OF RED TEAM

            for (user in waiting){
                if(user.idTeam == 5){
                    if(user.userPosition == 1){
                        // PREMIER DE LA WAITING LIST ENTRE EN JEU
                        // ID TEAM == > 3
                        user.idTeam = 3;
                        userViewModel.updateIdTeamByUserId(user);
                        // POSITION ID == > 0
                        user.userPosition = 0;
                        userViewModel.updatePositionUser(user);
                    }else{
                        // CHANGEMENT POSITION ID
                        // user.userPosition == > position-1
                        user.userPosition -= 1;
                        userViewModel.updatePositionUser(user);
                    }
                }

            }
        }

    }
    @SuppressLint("ResourceAsColor")
    private fun displayPseudosByTeamAndWaitingList(view: View, users: List<UserEntity>){

        val layoutWaitingPlayers = view.findViewById<LinearLayout>(R.id.layout_waiting_players_zone)
        layoutWaitingPlayers.removeAllViews()

        val y_attaque = view.findViewById<TextView>(R.id.yellow_team_atq)
        val y_def = view.findViewById<TextView>(R.id.yellow_team_def)
        val r_attaque = view.findViewById<TextView>(R.id.red_team_atq)
        val r_def = view.findViewById<TextView>(R.id.red_team_def)

        //AFFICHE DANS LORDRE
        val sortedUsers = users.sortedBy { it.userPosition }

        for (user in sortedUsers) {
            val teamId = user.idTeam
            val pseudo = user.pseudo
            when (teamId) {
                1 -> {y_attaque.text = pseudo}
                2 -> {y_def.text = pseudo}
                3 -> {r_attaque.text = pseudo}
                4 -> {r_def.text = pseudo}
                5 -> {
                    val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
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
                    waitingPlayer.isAllCaps = true
                    waitingPlayer.setTextAppearance(R.style.PlayersListStyle)
                    layoutWaitingPlayers.addView(waitingPlayer)
                }
            }
        }

    }

}