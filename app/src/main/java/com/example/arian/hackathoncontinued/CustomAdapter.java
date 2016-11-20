package com.example.arian.hackathoncontinued;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String>{
    public CustomAdapter(Context context, String[] clubs) {
        super(context, R.layout.custom_row ,clubs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.custom_row, parent, false);
        // get references.
        String singleClubItem = getItem(position);
        TextView itemText = (TextView) customView.findViewById(R.id.item_text);
        ImageView clubImage = (ImageView) customView.findViewById(R.id.my_image);

        // dynamically update the text from the array
        itemText.setText(singleClubItem);
        // using the same image every time
        if(position==0)
            clubImage.setImageResource(R.drawable.animal);
        else if(position==1)
            clubImage.setImageResource(R.drawable.picture2);
        else if(position==2)
            clubImage.setImageResource(R.drawable.picture3);
        else if(position==4)
            clubImage.setImageResource(R.drawable.picture4);



        // Now we can finally return our custom View or custom item
        return customView;
    }
}