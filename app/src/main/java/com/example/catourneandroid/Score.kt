package com.example.catourneandroid

import UserViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.catourneandroid.database.entity.UserEntity


class Score : Fragment() {

    private val userViewModel: UserViewModel by viewModels(factoryProducer = { UserViewModel.provideFactory() })
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_score, container, false)

        userViewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->
            displayPlayersScore(users, view)
        })
        userViewModel.getAllUsers()

        return view
    }
    @SuppressLint("ResourceAsColor")
    private fun displayPlayersScore(users: List<UserEntity>, view: View){

        val layoutPlayersScore = view.findViewById<LinearLayout>(R.id.layout_players_score)
        val layoutBestPlayers = view.findViewById<LinearLayout>(R.id.layout_best_players)

        layoutPlayersScore.removeAllViews()

        val higherScore = users.maxByOrNull { it.score }?.score

        for(user in users){

            val pseudo = user.pseudo
            val score = user.score.toString()

            val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(5, 1, 10, 3)
            val player = TextView(context)

            player.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.gravity = Gravity.CENTER
            player.layoutParams = params
            player.text = "$pseudo   :   $score"
            player.setTextColor(R.color.white)
            player.gravity = Gravity.CENTER
            player.textSize = 20F
            player.setTextAppearance(R.style.PlayersListStyle)

            if( user.score == higherScore ){
                layoutBestPlayers.addView(player)
            }else{
                layoutPlayersScore.addView(player)
            }
        }
    }

}