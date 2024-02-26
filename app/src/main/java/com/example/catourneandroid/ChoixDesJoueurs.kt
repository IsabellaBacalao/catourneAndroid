package com.example.catourneandroid

import TeamViewModel
import UserViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.catourneandroid.database.entity.TeamEntity
import com.example.catourneandroid.database.entity.UserEntity


class ChoixDesJoueurs : Fragment() {

    private val teamViewModel: TeamViewModel by viewModels(factoryProducer = { TeamViewModel.provideFactory() })
    private val userViewModel: UserViewModel by viewModels(factoryProducer = { UserViewModel.provideFactory() })
    private var count = 1;
    private var attentePosition = 1;
    private var nbPlayers = 0;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_choix_des_joueurs, container, false)

        val erreurNbPlayers = view.findViewById<TextView>(R.id.errorNbPlayers)
        val inputPlayers = view.findViewById<EditText>(R.id.input_text_players)
        val btnNewPlayer = view.findViewById<ImageButton>(R.id.button_add_player)
        val layoutPlayers = view.findViewById<LinearLayout>(R.id.layout_players_zone)

        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(5, 1, 10, 3)

        //CREATION DES TEAMS YELLOW ET RED
        val teamYellow1 = TeamEntity(idTeam = 1, statusTeam = "yellow", positionTeam = 1)
        val teamYellow2 = TeamEntity(idTeam = 2, statusTeam = "yellow", positionTeam = 2)

        val teamRed1 = TeamEntity(idTeam = 3, statusTeam = "red", positionTeam = 1)
        val teamRed2 = TeamEntity(idTeam = 4, statusTeam = "red", positionTeam = 2)

        val existingTeam = TeamEntity(idTeam = 5, statusTeam = "waiting", positionTeam = 3)

        teamViewModel.insertTeam(teamYellow1)
        teamViewModel.insertTeam(teamYellow2)
        teamViewModel.insertTeam(teamRed1)
        teamViewModel.insertTeam(teamRed2)
        teamViewModel.insertTeam(existingTeam)

        //Add a new Player at the game
        btnNewPlayer.setOnClickListener {
            val namePlayer = inputPlayers.text.toString();
            if (namePlayer != ""){
                nbPlayers += 1
                val viewPlayer = TextView(context)
                viewPlayer.layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                viewPlayer.layoutParams = params
                viewPlayer.text = namePlayer
                viewPlayer.setBackgroundResource(R.drawable.rounded_bg)
                viewPlayer.setPadding(15,8,15,8)
                viewPlayer.setTextAppearance(R.style.PlayersListStyle)
                viewPlayer.setHorizontallyScrolling(true)
                layoutPlayers.addView(viewPlayer)
                inputPlayers.setText("");

                //AJOUT DANS UNE TEAM
                if(count > 4) {
                    val user = UserEntity(pseudo = namePlayer, userPosition = attentePosition, idTeam = 5)
                    userViewModel.insertUser(user)
                    attentePosition +=1;

                }else {
                    val user = UserEntity(pseudo = namePlayer, userPosition = 0, idTeam = count)
                    userViewModel.insertUser(user)
                    count += 1
                }
            }
        }

        //START A GAME
        val btnStartAGame= view.findViewById<Button>(R.id.btnStartAGame)

        btnStartAGame.setOnClickListener {
            if( nbPlayers >= 4){
                Navigation.findNavController(view).navigate(R.id.action_choixDesJoueurs_to_gameOn)
                erreurNbPlayers.visibility = View.INVISIBLE;

            }else{
                erreurNbPlayers.visibility = View.VISIBLE;
            }
        }


        return view
    }

}