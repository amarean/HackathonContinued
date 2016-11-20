package com.example.arian.hackathoncontinued;

/*
The only difference here is we are going to use a our Custom adapter instead of an Array Adapter.
We pass the foods array as part of the constructor.
Note: we don't have an array of images so we use the same one every time,
else we would modify CustomAdapter to accept that array too.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<String> likes;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] clubs = {"A Capella Alliance at Ohio State University", "A Kid Again at Ohio State", "Acacia Fraternity", "Academy of Managed Care Pharmacy"};
        //listView = new ListView(MainActivity.this);
        // Replace the Array adapter with your custom adapter.
        // ListAdapter theListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        ListAdapter customListAdapter = new CustomAdapter(this, clubs);// Pass the clubs arrary to the constructor.
      //  ListAdapter customListAdapter2 = new CustomAdapter(this, pictures);// Pass the pictures arrary to the constructor.
        final ListView customListView = (ListView) findViewById(R.id.custom_ListView);
        customListView.setAdapter(customListAdapter);
        //customListView.setAdapter(customListAdapter2);

        customListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        if(position==0){
                            Intent intent = new Intent(view.getContext(), PageAct.class);
                            startActivity(intent);
                        }

                        //String club = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this,club, Toast.LENGTH_LONG).show();
                    }
                }
        );

        customListView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                //listView = new ListView(MainActivity.this);
                // Replace the Array adapter with your custom adapter.
                String[] likes = {"A Capella Alliance at The Ohio State University"};
                // ListAdapter theListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
                ListAdapter likedListAdapter = new CustomAdapter(MainActivity.this, likes);// Pass the clubs arrary to the constructor.
                //  ListAdapter customListAdapter2 = new CustomAdapter(this, pictures);// Pass the pictures arrary to the constructor.
                final ListView likeListAdapter = (ListView) findViewById(R.id.custom_ListView);
                customListView.setAdapter(likedListAdapter);

            }
            public void onSwipeLeft(){
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                MainActivity.this.onCreate(savedInstanceState);
            }
        });
    }


}
