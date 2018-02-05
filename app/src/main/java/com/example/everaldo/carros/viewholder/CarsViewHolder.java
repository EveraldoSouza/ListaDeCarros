package com.example.everaldo.carros.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.everaldo.carros.R;
import com.example.everaldo.carros.entities.Car;
import com.example.everaldo.carros.listener.OnListClickInteractionListener;

/**
 * Created by EVERALDO on 01/02/2018.
 */

public class CarsViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImgCarPicture;
    private TextView mTextCarModel;
    private TextView mTextViewDetails;

    //CRIANDO CONSTRUTOR
    public CarsViewHolder(View itemView) {
        //Elementos de interface
        super(itemView);
        this.mImgCarPicture = (ImageView) itemView.findViewById(R.id.img_car_pic);
        this.mTextCarModel = (TextView) itemView.findViewById(R.id.text_car_model);
        this.mTextViewDetails = (TextView) itemView.findViewById(R.id.text_view_details);

    }

    //atrui valores aos elementos
    public void bindDate(final Car car, final OnListClickInteractionListener listener) {
        //alterar valor
        this.mTextCarModel.setText(car.model);
        this.mImgCarPicture.setImageDrawable(car.picture);

        //adicionar evento de click
        this.mTextViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(car.id);
            }
        });
    }
}
