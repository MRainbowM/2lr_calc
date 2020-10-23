package com.example.a2_lr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityAB extends AppCompatActivity {

    private Button btnCreateAB, btnClose;
    private EditText etN;
    private GridView gvMatAB;
    private TextView tvNameAB;

    private Integer N;

    public static String selMat;

    private ArrayList<Integer> matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_b);

        gvMatAB = (GridView) findViewById(R.id.gvMatAB);
        btnCreateAB = (Button) findViewById(R.id.btnCreateAB);
        btnClose = (Button) findViewById(R.id.btnClose);
        etN = (EditText) findViewById(R.id.etN);
        tvNameAB = (TextView) findViewById(R.id.tvNameAB);

        matrix = new ArrayList<Integer>();

        btnCreateAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etN.getText().toString().length() == 0)  return;

                N = Integer.parseInt(etN.getText().toString());

                MainActivity mainActivity = new MainActivity();

                Integer maxVal = -1000;
                Integer minVal = 1000;
                matrix.clear();
                for (Integer i = 0; i < N; i++) {
                    Integer k = (int) (Math.random()* 20 - 10);
                    // Math.random() * (max - min) + min;
                    matrix.add(k);
                    if(maxVal < k)  {
                        mainActivity.inxA = i;
                        maxVal = k;
                    }
                    if(minVal > k)  {
                        mainActivity.inxB = i;
                        minVal = k;
                    }
                }

                if(selMat == "A") {
                    mainActivity.matrixA = matrix;
                    mainActivity.maxA = maxVal;
                    mainActivity.nA = N;
                } else if(selMat == "B") {
                    mainActivity.matrixB = matrix;
                    mainActivity.minB = minVal;
                    mainActivity.nB = N;
                }

                renderGrid(matrix);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity mainActivity = new MainActivity();
        if(selMat == "A") {
            tvNameAB.setText("Матрица А");
            if(mainActivity.matrixA.toArray().length > 0) {
                renderGrid(mainActivity.matrixA);
            }
        } else if(selMat == "B") {
            tvNameAB.setText("Матрица В");
            if(mainActivity.matrixB.toArray().length > 0) {
                renderGrid(mainActivity.matrixB);
            }
        }
    }

    private void renderGrid(ArrayList<Integer> matrix){
        gvMatAB.setAdapter(null);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, matrix);
        gvMatAB.setAdapter(adapter);
    }

    private void closeActivity() {
        this.finish();
    }

}
