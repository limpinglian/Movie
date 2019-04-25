package com.example.movie.Adapter;

import android.content.Context;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.Model.Movie;
import com.example.movie.R;
import com.squareup.picasso.Picasso;
import android.support.annotation.NonNull;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Movie> dataList;
    private Context context;

    public RecyclerViewAdapter(Context context,List<Movie> dataList){
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).
                inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(dataList.get(position)==null){
            Log.d("Null Value","Failed");        }
        else {
            holder.tvTitle.setText(dataList.get(position).getTitle());
            holder.tvYear.setText(dataList.get(position).getYear());
            holder.tvImdb.setText(dataList.get(position).getImdbID());
            holder.tvType.setText(dataList.get(position).getType());
            Picasso.get().load(dataList.get(position).getPoster()).into(holder.ivPoster);

        }
        /*if (dataList.get(i).getPoster() != null) {
            Glide.with(context)
                    .load(dataList.get(i).getPoster().replace("https", "http"))
                    .asBitmap()
                    .fitCenter()
                    .into(holder.ivPoster);
            Log.d("Image","Glide"+dataList.get(i).getPoster());
        }*/

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setMovie(List<Movie>movies){
        this.dataList=movies;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle) TextView tvTitle;
        @BindView(R.id.tvYear)TextView tvYear;
        @BindView(R.id.tvImdbId)TextView tvImdb;
        @BindView(R.id.tvType)TextView tvType;
        @BindView(R.id.ivPoster)ImageView ivPoster;


        ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

        }}




    }
