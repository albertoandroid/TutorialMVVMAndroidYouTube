package com.androiddesdecero.mvvmyoutube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AlCuadradoActivity extends AppCompatActivity {

    private EditText etAlCuadrado;
    private Button btAlCuadrado;
    private TextView tvAlCuadrado;
    private AlCuadradoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcuadrado);

        configView();
    }

    private void configView(){
        viewModel = ViewModelProviders.of(this).get(AlCuadradoViewModel.class);
        tvAlCuadrado = findViewById(R.id.tvAlCuadrado);
        etAlCuadrado = findViewById(R.id.edAlCuadrado);
        btAlCuadrado = findViewById(R.id.btCalcular);

        btAlCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.alCuadrado(etAlCuadrado.getText().toString());
            }
        });

        final Observer<String> observer = new Observer<String>() {
            @Override
            public void onChanged(String resultado) {
                tvAlCuadrado.setText(resultado);
            }
        };

        viewModel.getResultado().observe(this, observer);
    }
}
