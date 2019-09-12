package com.example.carwash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText textinput;
    private RadioGroup rg1;
    private Button button;
    private TextView PriceText;
    private CarWash carWash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carWash = new CarWash();
        textinput = findViewById(R.id.Input);
        button = findViewById(R.id.button);
        PriceText = findViewById(R.id.PriceText);
        rg1 = findViewById(R.id.RadioGroup);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerChangedListener();
                displayPriceText();
            }
        });


    }

    private void registerChangedListener(){
        rg1.setOnCheckedChangeListener(radioGroup);
    }

    private RadioGroup.OnCheckedChangeListener radioGroup = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.radioButton1:
                    carWash.setTotal(CarWash.Exterior);
                    break;
                case R.id.radioButton2:
                    carWash.setTotal(CarWash.Interior);
                    break;
            }
        }
    };

    private void displayPriceText(){

        String priceText;
        if (!textinput.getText().toString().equals("")) {
            carWash.setNumberOfWashes(Integer.parseInt(textinput.getText().toString()));
            if(Integer.parseInt(textinput.getText().toString()) < 12) {
                priceText= String.valueOf(carWash.getTotalPrice());
            }else{
                priceText= String.valueOf(carWash.getTotalPrice()*0.75);
            }
            PriceText.setText("$" + priceText);
        } else {
            PriceText.setText("Please enter a value");
        }
    }

}

