package com.example.a2_lr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static public ArrayList<Integer> matrixA, matrixB, matrixC, matrixC2, matrixC3, matrixD;

    static public Integer maxA, minB, nA, nB, inxA, inxB;

    private Button btnMatrixA, btnMatrixB, btnStart, btnMatrixC, btnMatrixC2, btnMatrixC3, btnMatrixD;

    private TextView tvMaxA, tvMinB;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMatrixA = (Button)findViewById(R.id.btnMatrixA);
        btnMatrixB = (Button)findViewById(R.id.btnMatrixB);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnMatrixC = (Button)findViewById(R.id.btnMatrixC);
        btnMatrixC2 = (Button)findViewById(R.id.btnMatrixC2);
        btnMatrixC3 = (Button)findViewById(R.id.btnMatrixC3);
        btnMatrixD = (Button)findViewById(R.id.btnMatrixD);

        tvMaxA = (TextView)findViewById(R.id.tvMaxA);
        tvMinB = (TextView)findViewById(R.id.tvMaxB);

        btnStart.setEnabled(false);
        btnMatrixC.setEnabled(false);
        btnMatrixC2.setEnabled(false);
        btnMatrixC3.setEnabled(false);
        btnMatrixD.setEnabled(false);

        maxA = -1000;
        minB = 1000;
        nA = 0;
        nB = 0;
        inxA = -1;
        inxB = -1;

        matrixA = new ArrayList<Integer>();
        matrixB = new ArrayList<Integer>();
        matrixC = new ArrayList<Integer>();
        matrixC2 = new ArrayList<Integer>();
        matrixC3 = new ArrayList<Integer>();
        matrixD = new ArrayList<Integer>();

        btnMatrixA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openABActivity("A");
            }
        });

        btnMatrixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openABActivity("B");
            }
        });

        btnMatrixC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCDActivity("C");
            }
        });

        btnMatrixC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCDActivity("C2");
            }
        });

        btnMatrixC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCDActivity("C3");
            }
        });

        btnMatrixD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCDActivity("D");
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Start();
            }
        });
    }

    private void Start() {
        matrixC.clear();
        matrixC2.clear();
        matrixC3.clear();
        matrixD.clear();

        Integer value = 0;

        for (Integer el : matrixA) {
            value = el * minB;
           matrixC.add(value);
        }

        for (int i = 0; (i < matrixA.toArray().length); i++) {
            if(matrixA.get(i) == 0) {
                matrixC3.add(i);
            } else {
                value = matrixA.get(i) * minB;
                matrixC2.add(value);
            }
        }

        for (Integer el : matrixB) {
            value = el * maxA;
            matrixD.add(value);
        }

        btnMatrixC.setEnabled(true);
        btnMatrixC2.setEnabled(true);
        btnMatrixC3.setEnabled(true);
        btnMatrixD.setEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvMaxA.setText("");
        tvMinB.setText("");
        if(maxA != -1000)  tvMaxA.setText("max(A): " + maxA + " inx: " + inxA);

        if(minB != 1000) tvMinB.setText("min(B): " + minB + " inx: " + inxB);

        if(maxA == -1000 || minB == 1000)  btnStart.setEnabled(false);
        else btnStart.setEnabled(true);
    }

    private void openABActivity(String selMat){
        ActivityAB activityAB = new ActivityAB();
        activityAB.selMat = selMat;
        Intent intent = new Intent(this, ActivityAB.class);
        startActivity(intent);
    }

    private void openCDActivity(String selMat){
        ActivityCD activityCD = new ActivityCD();
        activityCD.selMat = selMat;
        Intent intent = new Intent(this, ActivityCD.class);
        startActivity(intent);
    }
}
