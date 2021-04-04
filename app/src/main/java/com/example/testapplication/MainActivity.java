package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //String s1[];
   // int images[]={R.drawable.download,R.drawable.weather1};
    RecyclerView recyclerView;
    List<DataModel> model2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView= findViewById(R.id.recyclerview);
        model2= new ArrayList<>();


        //Retrofit
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://picsum.photos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Instance For Interface

        MyApiCall myApiCall = retrofit.create(MyApiCall.class);
        Call<List<DataModel>> call = myApiCall.getData();

        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
            if(response.code()!=200){
                //handle the error
                return;
            }

           List<DataModel> model= response.body();

            for (DataModel mode : model){
                model2.add(mode);
            }

            PutDataIntoRecyclerView(model2);

//            String json="";
//
//            json= "ID "+response.body().getId() +
//                    "\nDownload_url "+response.body().getDownload_url();

            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

            }
        });


    }

    private void PutDataIntoRecyclerView(List<DataModel> model2) {

        MyAdapter myAdapter =new MyAdapter(this,model2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager( linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }
}