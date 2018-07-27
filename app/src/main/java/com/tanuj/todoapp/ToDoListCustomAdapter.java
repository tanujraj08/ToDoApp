package com.tanuj.todoapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ToDoListCustomAdapter extends BaseAdapter {
    private Context context;
    private List<ToDoList> toDoListItems;

    public ToDoListCustomAdapter(Context context, List<ToDoList> toDoListItems) {
        this.context = context;
        this.toDoListItems = toDoListItems;
    }

    @Override
    public int getCount() {
        return toDoListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return toDoListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        // CUstom Adapter View for Each Row.
        View toDoListCustomView = View.inflate(context, R.layout.todo_listview,null);

        TextView idTextView = (TextView) toDoListCustomView.findViewById(R.id.idTextView);
        TextView groupDateTextView = (TextView) toDoListCustomView.findViewById(R.id.groupDateTextView);
        TextView titleTextView = (TextView) toDoListCustomView.findViewById(R.id.titleTextView);
        TextView descriptionTextView = (TextView) toDoListCustomView.findViewById(R.id.descriptionTextView);
        TextView dateTextView = (TextView) toDoListCustomView.findViewById(R.id.dateTextView);
        ImageView statusImageView= (ImageView) toDoListCustomView.findViewById(R.id.statusImageView);

        idTextView.setText(toDoListItems.get(position).getId());
        titleTextView.setText(toDoListItems.get(position).getTitle());
        descriptionTextView.setText(toDoListItems.get(position).getDescription());
        dateTextView.setText(toDoListItems.get(position).getActionDate());

        // Change Image Based on Status Column Value.
        if (String.valueOf(toDoListItems.get(position).getStatus()).equals("0"))
            statusImageView.setImageResource(R.drawable.thumbsup);
        else
            statusImageView.setImageResource(R.drawable.done);


        // Group Header Date Will be In-Visible if the previous row has same date.
        if (position != 0) {
            if (!toDoListItems.get(position-1).getActionDate().equals(toDoListItems.get(position).getActionDate())) {
                groupDateTextView.setText(toDoListItems.get(position).getActionDate());
                groupDateTextView.setVisibility(View.VISIBLE);
            }
            else {
                groupDateTextView.setText("");
                groupDateTextView.setVisibility(View.GONE);
            }
        }
        else{
            groupDateTextView.setText(toDoListItems.get(position).getActionDate());
            groupDateTextView.setVisibility(View.VISIBLE);
        }

        return toDoListCustomView;
    }
}
