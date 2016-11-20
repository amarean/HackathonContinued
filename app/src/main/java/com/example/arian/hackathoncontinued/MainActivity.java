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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] clubs = {"ACMW", "HES", "GES", "Cooking"};
        String[] pictures ={"animal", "picture2", "picture3", "picture4"};
        // Replace the Array adapter with your custom adapter.
        // ListAdapter theListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        ListAdapter customListAdapter = new CustomAdapter(this, clubs);// Pass the clubs arrary to the constructor.
      //  ListAdapter customListAdapter2 = new CustomAdapter(this, pictures);// Pass the pictures arrary to the constructor.
        ListView customListView = (ListView) findViewById(R.id.custom_ListView);
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
    }


}
