package com.example.customgridview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyarrayAdapter extends ArrayAdapter<Image> {
    Activity context = null;
    ArrayList<Image> myArray = null;
    int LayoutId;

    public MyarrayAdapter(Activity context, int LayoutId, ArrayList<Image> arr) {
        super(context, LayoutId, arr);
        this.context = context;
        this.LayoutId = LayoutId;
        this.myArray = arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId, null);

        final Image myimage = myArray.get(position);

        // Lấy ImageView và load ảnh bằng Glide
        final ImageView imgitem = convertView.findViewById(R.id.imageView1);
        Glide.with(context)
                .load(myimage.getImg()) // getImg() trả về resource ID (int)
                .into(imgitem);

        // Lấy TextView và set tên ảnh
        final TextView myname = convertView.findViewById(R.id.textView1);
        myname.setText(myimage.getName());

        return convertView;
    }
}
