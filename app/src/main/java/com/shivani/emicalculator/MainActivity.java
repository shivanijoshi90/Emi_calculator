package com.shivani.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText principal,rate,month;
    TextView txtEmi,txtTotalAmt,txtTotalInterest;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal =findViewById(R.id.principal);
        rate =findViewById(R.id.rate);
        month = findViewById(R.id.month);
        calculate =findViewById(R.id.calculate);
        txtEmi = findViewById(R.id.Emi);
        txtTotalAmt =findViewById(R.id.Total_amt);
        txtTotalInterest =findViewById(R.id.Interest_amt);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pri = Integer.parseInt(principal.getText().toString());
                double ret= Double.parseDouble(rate.getText().toString());
                int mon= Integer.parseInt(month.getText().toString());

                double r =ret/12*100;
                double cal =1;
                 for (int i=0;i<mon;i++){

                     cal *= (1+r);
                 }
                 double ans = pri*r*(cal/cal-1);
                 txtEmi.setText("Emi="+ans);
                 double total =ans*mon;
                 txtTotalAmt.setText("Total amt="+total);
                 double inter =total - pri;
                 txtTotalInterest.setText("Interest Amount="+inter);

            }
        });

        }
}