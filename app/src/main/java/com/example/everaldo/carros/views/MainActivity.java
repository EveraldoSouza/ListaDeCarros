package com.example.everaldo.carros.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.everaldo.carros.R;
import com.example.everaldo.carros.adapter.CarsListAdapter;
import com.example.everaldo.carros.constants.CarrosConstants;
import com.example.everaldo.carros.data.CarMock;
import com.example.everaldo.carros.entities.Car;
import com.example.everaldo.carros.listener.OnListClickInteractionListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //Instanciando ViewHolder and dando o name de mViewHolder
    ViewHolder mvViewHolder = new ViewHolder();
    //Instaciando um context
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mudando o icon do aplicativo no ActionBar
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mContext = this;

        CarMock carMock = new CarMock(this);
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        //PEDINDO PERMISSÃO COM THIS E OBTENDO A RECYCLERVIEW DA MAIN_ACTIVITY
        this.mvViewHolder.recyclerCars = (RecyclerView) this.findViewById(R.id.recycler_cars);

        OnListClickInteractionListener listener = new OnListClickInteractionListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarrosConstants.CARRO_ID, id);

                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        };

        //DEFINIR ADAPTER
        CarsListAdapter carsListAdapter = new CarsListAdapter(carList, listener);
        this.mvViewHolder.recyclerCars.setAdapter(carsListAdapter);


        //DEFINIR UM LAYOUT
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mvViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);


    }


    //Class private ViewHolder
    private static class ViewHolder{

        RecyclerView recyclerCars;


    }
}
