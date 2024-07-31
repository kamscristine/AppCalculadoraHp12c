package com.example.calculadorahp12c;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;

    private Button btnEnter;
    private Button btnBackSpace;

    private EditText visor;

    private Calculadora calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1 = findViewById(R.id.btnUm);
        btn2 = findViewById(R.id.btnDois);
        btn3 = findViewById(R.id.btnTres);
        btn4 = findViewById(R.id.btnQuatro);
        btn5 = findViewById(R.id.btnCInco);
        btn6 = findViewById(R.id.btnSeis);
        btn7 = findViewById(R.id.btnSete);
        btn8 = findViewById(R.id.btnOIto);
        btn9 = findViewById(R.id.btnNove);
        btn0 = findViewById(R.id.btnZero);

        btnEnter = findViewById(R.id.btnEnter);
        btnBackSpace = findViewById(R.id.btnBack);

        visor = findViewById(R.id.visor);
        visor.setShowSoftInputOnFocus(false); // nao deixa o teclado do proprio celular aparecer

        btn1.setOnClickListener(botaoCLick("1"));
        btn2.setOnClickListener(botaoCLick("2"));
        btn3.setOnClickListener(botaoCLick("3"));
        btn4.setOnClickListener(botaoCLick("4"));
        btn5.setOnClickListener(botaoCLick("5"));
        btn6.setOnClickListener(botaoCLick("6"));
        btn7.setOnClickListener(botaoCLick("7"));
        btn8.setOnClickListener(botaoCLick("8"));
        btn9.setOnClickListener(botaoCLick("9"));
        btn0.setOnClickListener(botaoCLick("0"));

        btnEnter.setOnClickListener((v) -> {
            double valor = Double.valueOf(visor.getText().toString());
            calculadora.setNumero(valor);
            calculadora.enter();
        });

        btnBackSpace.setOnClickListener((v) -> {
            int inicioSelecao = visor.getSelectionStart() - 1;
            inicioSelecao = Math.max(inicioSelecao, 0);
            int finalSelecao = visor.getSelectionEnd();
            visor.getText().delete(inicioSelecao, finalSelecao);
        });

    }

    public View.OnClickListener botaoCLick(final String s) {
        return (v) -> {
          int  inicioSelecao = visor.getSelectionStart();
          int finalSelecao = visor.getSelectionEnd();
          visor.getText().replace(inicioSelecao, finalSelecao, s);
        };
    }


}