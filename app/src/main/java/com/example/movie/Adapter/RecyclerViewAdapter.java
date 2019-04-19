package com.example.movie.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movie.Model.Movie;
import com.example.movie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.tvTitle.setText(dataList.get(i).getTitle());
        holder.tvYear.setText(dataList.get(i).getYear());
        holder.tvImdb.setText(dataList.get(i).getImdbID());
        holder.tvType.setText(dataList.get(i).getType());
        Picasso.get().load(dataList.get(i).getPoster()).into(holder.ivPoster);

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
    private TextView tvTitle;
    private TextView tvYear;
    private TextView tvImdb;
    private TextView tvType;
    private ImageView ivPoster;

        ViewHolder(View itemView) {
            super(itemView);

            tvTitle=(TextView)itemView.findViewById(R.id.tvTitle);
            tvYear=(TextView)itemView.findViewById(R.id.tvYear);
            tvImdb=(TextView)itemView.findViewById(R.id.tvImdbId);
            tvType=(TextView)itemView.findViewById(R.id.tvType);
            ivPoster=(ImageView) itemView.findViewById(R.id.ivPoster);

        }}

    }
