package com.messager.og2.cs465.cs465messager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ConversationEntryAdapter extends ArrayAdapter<ConversationEntry> {
    private Context context;
    private int layoutResourceId;
    private ConversationEntry[] conversationEntries;
    private Person withPerson;

    public ConversationEntryAdapter(Context context, int resource, ConversationEntry[] conversationEntries, Person withPerson) {
        super(context, resource, conversationEntries);
        this.context = context;
        this.layoutResourceId = resource;
        this.conversationEntries = conversationEntries;
        this.withPerson = withPerson;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImageView left_image;
        TextView text;
        ImageView right_image;

        if (row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
        }

        left_image = (ImageView)row.findViewById(R.id.left_image);
        text = (TextView)row.findViewById(R.id.text);
        right_image = (ImageView)row.findViewById(R.id.right_image);

        ConversationEntry conversationEntry = conversationEntries[position];

        if (conversationEntry.person == withPerson)
        {
            left_image.setVisibility(View.GONE);

            right_image.setImageResource(conversationEntry.person.image);
            right_image.setVisibility(View.VISIBLE);
        }
        else
        {
            left_image.setImageResource(conversationEntry.person.image);
            left_image.setVisibility(View.VISIBLE);

            right_image.setVisibility(View.GONE);
        }

        text.setText(conversationEntry.chatText);

        return row;
    }
}