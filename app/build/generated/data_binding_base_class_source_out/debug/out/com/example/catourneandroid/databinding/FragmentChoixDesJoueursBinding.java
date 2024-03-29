// Generated by view binder compiler. Do not edit!
package com.example.catourneandroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.catourneandroid.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentChoixDesJoueursBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final HorizontalScrollView ScrollViewPlayers;

  @NonNull
  public final Button btnStartAGame;

  @NonNull
  public final ImageButton buttonAddPlayer;

  @NonNull
  public final TextView errorNbPlayers;

  @NonNull
  public final EditText inputTextPlayers;

  @NonNull
  public final LinearLayout layoutPlayersZone;

  private FragmentChoixDesJoueursBinding(@NonNull RelativeLayout rootView,
      @NonNull HorizontalScrollView ScrollViewPlayers, @NonNull Button btnStartAGame,
      @NonNull ImageButton buttonAddPlayer, @NonNull TextView errorNbPlayers,
      @NonNull EditText inputTextPlayers, @NonNull LinearLayout layoutPlayersZone) {
    this.rootView = rootView;
    this.ScrollViewPlayers = ScrollViewPlayers;
    this.btnStartAGame = btnStartAGame;
    this.buttonAddPlayer = buttonAddPlayer;
    this.errorNbPlayers = errorNbPlayers;
    this.inputTextPlayers = inputTextPlayers;
    this.layoutPlayersZone = layoutPlayersZone;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentChoixDesJoueursBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentChoixDesJoueursBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_choix_des_joueurs, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentChoixDesJoueursBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ScrollViewPlayers;
      HorizontalScrollView ScrollViewPlayers = ViewBindings.findChildViewById(rootView, id);
      if (ScrollViewPlayers == null) {
        break missingId;
      }

      id = R.id.btnStartAGame;
      Button btnStartAGame = ViewBindings.findChildViewById(rootView, id);
      if (btnStartAGame == null) {
        break missingId;
      }

      id = R.id.button_add_player;
      ImageButton buttonAddPlayer = ViewBindings.findChildViewById(rootView, id);
      if (buttonAddPlayer == null) {
        break missingId;
      }

      id = R.id.errorNbPlayers;
      TextView errorNbPlayers = ViewBindings.findChildViewById(rootView, id);
      if (errorNbPlayers == null) {
        break missingId;
      }

      id = R.id.input_text_players;
      EditText inputTextPlayers = ViewBindings.findChildViewById(rootView, id);
      if (inputTextPlayers == null) {
        break missingId;
      }

      id = R.id.layout_players_zone;
      LinearLayout layoutPlayersZone = ViewBindings.findChildViewById(rootView, id);
      if (layoutPlayersZone == null) {
        break missingId;
      }

      return new FragmentChoixDesJoueursBinding((RelativeLayout) rootView, ScrollViewPlayers,
          btnStartAGame, buttonAddPlayer, errorNbPlayers, inputTextPlayers, layoutPlayersZone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
