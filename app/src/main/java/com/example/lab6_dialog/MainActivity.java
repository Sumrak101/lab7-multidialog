package com.example.lab6_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void OnCloseButtonClick(View view){
        String[] mInredients = {"Томаты", "Шампиньоны","Курица","Маслины"};

        final boolean[]  mSelectedIngredients = {false, false,false,false};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выберите ингридиенты для пиццы")
                .setIcon(R.drawable.pizza)
                .setCancelable(false)
                //множественный выбор
                .setMultiChoiceItems(mInredients, null, new DialogInterface.OnMultiChoiceClickListener(){
                public void onClick(DialogInterface dialog, int which, boolean isChecked){
                    mSelectedIngredients[which] = isChecked;
            }
        })
                .setPositiveButton("Ок",
                 new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        finish();
                    }
                 });


        AlertDialog alert = builder.create();
        alert.show();
    }


}