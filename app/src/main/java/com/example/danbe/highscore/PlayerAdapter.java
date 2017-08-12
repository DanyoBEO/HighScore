package com.example.danbe.highscore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

/**
 * Created by danbe on 6/30/2017.
 */

public class PlayerAdapter extends ArrayAdapter<Player> {

    public PlayerAdapter(Context context, List<Player> players){
        super(context, 0, players);
    }


    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_leaderboard, parent, false);
        }

        Player currentPlayer = getItem(position);

        TextView nameView = listItemView.findViewById(R.id.player_name);
        nameView.setText(currentPlayer.getName());

        TextView scoreView = listItemView.findViewById(R.id.score);
        scoreView.setText(currentPlayer.getScore());


        return listItemView;

    }
}
