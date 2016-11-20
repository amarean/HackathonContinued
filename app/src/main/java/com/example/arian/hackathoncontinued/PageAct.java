package com.example.arian.hackathoncontinued;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PageAct extends AppCompatActivity {

    public ArrayList<String> clubs = new ArrayList<String>();
    public ArrayList<String> likedClubs = new ArrayList<String>();
    public int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_page);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        createArray(clubs);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createArray(ArrayList<String> clubs){
        clubs.add("HES");
        clubs.add("GES");
        clubs.add("ACM-W");
    }
    /**
     * This method is called when the next button is clicked.
     */
    public void changeClub(View view) {
        display(pos);
        pos++;
        if(pos == clubs.size()){
            pos = 0;
        }
    }

    public void setLikedClubs(View view){
        TextView quantityTextView = (TextView) findViewById(R.id.clubName);
        likedClubs.add(quantityTextView.toString());
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int pos) {
        String clubName = "";
        TextView quantityTextView = (TextView) findViewById(R.id.clubName);
        quantityTextView.setText(clubs.get(pos));
        ImageView clubImageView = (ImageView) findViewById(R.id.schedule);
        if(pos == 0) {
            clubImageView.setImageResource(R.drawable.picture2);
        }else if(pos == 1){
            clubImageView.setImageResource(R.drawable.picture3);
        }
        else if(pos == 2) {
            clubImageView.setImageResource(R.drawable.picture4);
        }
    }

}
