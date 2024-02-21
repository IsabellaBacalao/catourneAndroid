package com.example.catourneandroid

import UserViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation

class Home : Fragment() {

    private val userViewModel: UserViewModel by viewModels(factoryProducer = { UserViewModel.provideFactory() })

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val btnToAddPlayers = view.findViewById<ImageButton>(R.id.btnFragmentChoixDesJoueurs)

        userViewModel.deleteUsers()


        btnToAddPlayers.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homepage_to_choixDesJoueurs)
        }
        return view
    }
}