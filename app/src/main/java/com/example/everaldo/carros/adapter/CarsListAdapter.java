package com.example.everaldo.carros.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everaldo.carros.R;
import com.example.everaldo.carros.entities.Car;
import com.example.everaldo.carros.listener.OnListClickInteractionListener;
import com.example.everaldo.carros.viewholder.CarsViewHolder;

import java.util.List;

/**
 * Created by EVERALDO on 01/02/2018.
 */

public class CarsListAdapter extends RecyclerView.Adapter<CarsViewHolder> {

    private List<Car> mListCars;
    private OnListClickInteractionListener mOnListClickInteractionListener;

    //private int mContOnCreate = 0;
    //private int mContOnBind = 0;

    public CarsListAdapter(List<Car> cars, OnListClickInteractionListener listener) {
        this.mListCars = cars;
        this.mOnListClickInteractionListener = listener;
    }

    @Override
    public CarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // mContOnCreate++;
        //pegando o contexto
        Context context = parent.getContext();
        //RESPONSAVEL POR CRIAR UMA INTERFACE PARA DEPOIS INSTANCIAR E OBTER OS ELEMENTOS
        LayoutInflater inflater = LayoutInflater.from(context);
        //instanciando a row_car_list
        View carView = inflater.inflate(R.layout.row_car_list, parent, false);
        return new CarsViewHolder(carView); //passando para o viewholder e
        // obter os elementos e fazer a manipulação
    }

    @Override
    public void onBindViewHolder(CarsViewHolder holder, int position) {
        //mContOnBind++;
        Car car = this.mListCars.get(position);
        holder.bindDate(car, this.mOnListClickInteractionListener);
    }

    @Override
    public int getItemCount() {
        return this.mListCars.size();
    }
}
