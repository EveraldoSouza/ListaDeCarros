package com.example.everaldo.carros.views;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.everaldo.carros.R;
import com.example.everaldo.carros.constants.CarrosConstants;
import com.example.everaldo.carros.data.CarMock;
import com.example.everaldo.carros.entities.Car;

public class DetailsActivity extends AppCompatActivity {

    //Instaciando a class ViewHolder
    private ViewHolder mViewHolder = new ViewHolder();
    private CarMock mCarMock;
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Mundano o icon do aplicativo
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //Instaciando CarMock
        this.mCarMock = new CarMock(this);

        //Instaciando os atributos da class ViewHolder que são text_model, text_horse_power e text_price
        this.mViewHolder.imgCarPicture = (ImageView) this.findViewById(R.id.img_car_pic);
        this.mViewHolder.textManufacture = (TextView) this.findViewById(R.id.text_manufacture);
        this.mViewHolder.textModel = (TextView) this.findViewById(R.id.text_car_model);
        this.mViewHolder.textHorsePower = (TextView) this.findViewById(R.id.text_horse_power);
        this.mViewHolder.textPrice = (TextView) this.findViewById(R.id.text_price);

        //Responsavel por obter o valor passado por parametro
        this.getDataFromActivity();
        
        //Responsavel por atribuir os valores aos elementos de interface
        this.setData();

    }
    //Responsavel por atribuir os valores aos elementos de interface

    private void setData(){

        this.mViewHolder.imgCarPicture.setImageDrawable(this.mCar.picture);
        this.mViewHolder.textManufacture.setText(this.mCar.manufacturer);
        this.mViewHolder.textModel.setText(this.mCar.model);
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
        this.mViewHolder.textPrice.setText("R$ " + String.valueOf(this.mCar.price));
    }

    //Responsavel por obter o valor passado por parametro
    private void getDataFromActivity(){
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            this.mCar = this.mCarMock.get(extras.getInt(CarrosConstants.CARRO_ID));
        }
    }

    //Class ViewHolder
    private static class ViewHolder{
        ImageView imgCarPicture; //para a imagem do carro
        TextView textManufacture; //para o nome do fabricante do carro
        TextView textModel; //para o modelo do carro
        TextView textHorsePower; //para o a quantidade de cavalos no carro
        TextView textPrice; //para o preco do carro
    }
}
