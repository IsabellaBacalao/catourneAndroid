package com.example.catourneandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.Navigation

class Home : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val btnToAddPlayers = view.findViewById<ImageButton>(R.id.btnFragmentChoixDesJoueurs)

        btnToAddPlayers.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homepage_to_choixDesJoueurs)
        }
        return view
    }
}