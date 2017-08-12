package com.example.danbe.highscore;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by danbe on 6/29/2017.
 */

public class LeaderBoard extends Activity {
    private static final String SHEETS_URL = "https://spreadsheets.google.com/tq?key=1rdsVuAPiTUfwQzOBvhxS2IFDQ_Kvk_AcSQVQd5GVr1w";

    private PlayerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leader_board);

        ListView playerListView = findViewById(R.id.list);

        mAdapter = new PlayerAdapter(this, new ArrayList<Player>());

        playerListView.setAdapter(mAdapter);

        HiScoreAsyncTask task = new HiScoreAsyncTask();

        task.execute(SHEETS_URL);
    }

    public class HiScoreAsyncTask extends AsyncTask<String, Void, List<Player>> {

        protected List<Player> doInBackground(String... urls){
            if(urls.length < 1 || urls[0] == null){
                return null;
            }

            List<Player> result = QueryUtils.fetchPlayerData(urls[0]);
            return result;
        }

        protected  void onPostExecute(List<Player> data){
            mAdapter.clear();

            if(data == null && data.isEmpty()){
                mAdapter.addAll(data);
            }

        }

    }

}
