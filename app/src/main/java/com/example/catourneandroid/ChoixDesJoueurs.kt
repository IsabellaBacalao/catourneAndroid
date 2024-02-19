package com.example.catourneandroid

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment


class ChoixDesJoueurs : Fragment() {

    private lateinit var viewPlayers: TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_choix_des_joueurs, container, false)

        val inputPlayers = view.findViewById<EditText>(R.id.input_text_players)
        val btnNewPlayer = view.findViewById<Button>(R.id.button_add_player)
        val layoutPlayers = view.findViewById<LinearLayout>(R.id.layout_players_zone)

        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(20, 10, 20, 20)

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

        return view
    }

}