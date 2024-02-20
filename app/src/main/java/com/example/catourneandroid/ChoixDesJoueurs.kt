package com.example.catourneandroid

import android.annotation.SuppressLint
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
import androidx.navigation.Navigation


class ChoixDesJoueurs : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_choix_des_joueurs, container, false)

        val inputPlayers = view.findViewById<EditText>(R.id.input_text_players)
        val btnNewPlayer = view.findViewById<ImageButton>(R.id.button_add_player)
        val layoutPlayers = view.findViewById<LinearLayout>(R.id.layout_players_zone)

        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(5, 1, 10, 3)


        //Add a new Player at the game
        btnNewPlayer.setOnClickListener {
            val namePlayer = inputPlayers.text.toString();
            val viewPlayer = TextView(context)

            viewPlayer.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            viewPlayer.layoutParams = params
            viewPlayer.text = namePlayer
            viewPlayer.setBackgroundResource(R.drawable.rounded_bg)
            viewPlayer.setPadding(5,5,5,5)
            viewPlayer.setTextAppearance(R.style.PlayersListStyle)
            viewPlayer.setHorizontallyScrolling(true)
            layoutPlayers.addView(viewPlayer)
            inputPlayers.setText("");
        }

        val btnStartAGame= view.findViewById<Button>(R.id.btnStartAGame)

        btnStartAGame.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_choixDesJoueurs_to_gameOn)
        }

        return view
    }

}