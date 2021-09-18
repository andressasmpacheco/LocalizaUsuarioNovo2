package br.com.localizausuarionovo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LocalizacaoActivity extends AppCompatActivity {
    Button meu_botao;
    static EditText lat, longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        meu_botao =  findViewById(R.id.botao_local);
        lat = findViewById(R.id.latitude);
        longi = findViewById(R.id.longitude);

        meu_botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}