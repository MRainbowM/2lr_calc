package com.example.a2_lr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityCD extends AppCompatActivity {
    public static String selMat;

    private Button btnClose1;
    private GridView gvMatCD;
    private TextView tvNameCD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_d);

        gvMatCD = (GridView) findViewById(R.id.gvMatCD);
        btnClose1 = (Button) findViewById(R.id.btnClose1);
        tvNameCD = (TextView) findViewById(R.id.tvNameCD);

        btnClose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivity();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity mainActivity1 = new MainActivity();
        if(selMat == "C") {
            tvNameCD.setText("Матрица C (ci=ai*min{bi})");
            if(mainActivity1.matrixC.toArray().length > 0) {
                renderGrid(mainActivity1.matrixC);
            }
        } else if(selMat == "C2") {
            tvNameCD.setText("Матрица С2 (сжатая, без нулей)");
            if(mainActivity1.matrixC2.toArray().length > 0) {
                renderGrid(mainActivity1.matrixC2);
            }
        } else if(selMat == "C3") {
            tvNameCD.setText("Матрица С3 (индексы отброшенных нулей)");
            if(mainActivity1.matrixC3.toArray().length > 0) {
                renderGrid(mainActivity1.matrixC3);
            }
        } else if(selMat == "D") {
            tvNameCD.setText("Матрица D (di=bi*max{ai})");
            if(mainActivity1.matrixD.toArray().length > 0) {
                renderGrid(mainActivity1.matrixD);
            }
        }
    }

    private void renderGrid(ArrayList<Integer> matrix1){
        gvMatCD.setAdapter(null);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, matrix1);
        gvMatCD.setAdapter(adapter);
    }

    private void closeActivity() {
        this.finish();
    }
}
