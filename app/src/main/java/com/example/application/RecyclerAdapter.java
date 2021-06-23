package com.example.application;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<String> title;
    ArrayList<String> description;
    //String [] discrption;
    ArrayList<String>Imageurl;
    public RecyclerAdapter(Context context, ArrayList<String> title, ArrayList<String>description,ArrayList<String> url)
    {
        this.title=title;
        this.description=description;
        this.Imageurl=url;
        this.context=context;
    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.recyler_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        holder.textView.setText(title.get(position));
        holder.textView1.setText(description.get(position));


        Picasso.with(context)
                .load(Imageurl.get(position))
                .into(holder.img);

        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,Details.class);
                intent.putExtra("currentItemId",position);
                intent.putExtra("titleArray",title);
                intent.putExtra("descArray",description);
                intent.putExtra("imageArray",Imageurl);
                context.startActivity(intent);

            }
        });

    }



    @Override
    public int getItemCount() {
        return title.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView1;
        ImageView img;
        Button b1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView =itemView.findViewById(R.id.text_title);
            textView1=itemView.findViewById(R.id.text_description);
            img=itemView.findViewById(R.id.imageView);
            b1=itemView.findViewById(R.id.btn_details);
        }
    }

}
