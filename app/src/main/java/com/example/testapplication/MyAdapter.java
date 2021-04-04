package com.example.testapplication;

import android.app.MediaRouteButton;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    //String data1[];
    List<DataModel> model1;
    //String image[];

    public  MyAdapter(Context ct, List<DataModel> model1){

       // data1=s1;
   // image=imag1;
        this.context=ct;
        this.model1= model1;


}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.my_row, parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      //Glide
        Glide.with(context)
                .load(model1.get(position).getDownload_url())
        .into(holder.img);
    }

    @Override
    public int getItemCount()
    {
        return model1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textView1;
    ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           // textView1= itemView.findViewById(R.id.textView);
            img= itemView.findViewById(R.id.imageView);

        }
    }
}
