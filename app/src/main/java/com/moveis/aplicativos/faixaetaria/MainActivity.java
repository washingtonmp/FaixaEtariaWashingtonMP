package com.moveis.aplicativos.faixaetaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText edtDia, edtMes, edtAno;
    private Button btnCalcular;
    private int dia, mes, ano, day, month, year, idade;
    private Calendar currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtDia = findViewById(R.id.edtDiaId);
        edtMes = findViewById(R.id.edtMesId);
        edtAno = findViewById(R.id.edtAnoId);
        btnCalcular = findViewById(R.id.btnCalcularId);



    }

    public void calcularFE(View view){

        // dia vazio
        if (edtDia.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Campo não pode estar vazio", Toast.LENGTH_LONG).show();
            edtDia.requestFocus();
        } else if (edtMes.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Campo não pode estar vazio", Toast.LENGTH_LONG).show();
            edtMes.requestFocus();

        } else  if (edtAno.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Campo não pode estar vazio", Toast.LENGTH_LONG).show();
            edtAno.requestFocus();

        }  else {

            // recupera data atual
            currentTime = Calendar.getInstance();
            day = currentTime.get(Calendar.DAY_OF_MONTH);
            month = currentTime.get(Calendar.MONTH);
            year = currentTime.get(Calendar.YEAR);

            // Recupera data de nascimento
            dia = Integer.parseInt(edtDia.getText().toString());
            mes = Integer.parseInt(edtMes.getText().toString());
            ano = Integer.parseInt(edtAno.getText().toString());

            // Testa se mês é valido
            if ((Integer.parseInt(edtMes.getText().toString()) > 0) && (Integer.parseInt(edtMes.getText().toString()) <= 12)) {

                // Testa se dia >0
                if (Integer.parseInt(edtDia.getText().toString()) > 0) {

                    // Testa se mes é fevereito
                    if (Integer.parseInt(edtMes.getText().toString()) == 2) {

                        // Testa se foi digitado apenas 28 dias
                        if (Integer.parseInt(edtDia.getText().toString()) <= 28) {

                            calcularFaixaEtaria();

                        } else {

                            Toast.makeText(getApplicationContext(), "Fevereiro possui apenas 28 dias", Toast.LENGTH_LONG).show();

                        }

                    }else if (Integer.parseInt(edtDia.getText().toString()) <= 31) {

                        calcularFaixaEtaria();

                    }else {
                        Toast.makeText(getApplicationContext(), "Meses não pode passar de 31 dias", Toast.LENGTH_LONG).show();
                    }



                } else {
                       Toast.makeText(getApplicationContext(), "0 não é um dia válido", Toast.LENGTH_LONG).show();
                }


            } else {

                Toast.makeText(getApplicationContext(), "Mês incorreto!", Toast.LENGTH_LONG).show();
                edtMes.requestFocus();

            }

        }

    }

    public void calcularFaixaEtaria(){

        idade= year-ano;
        if (month<mes){

            if (day<dia){

                if(idade<=12){
                    Toast.makeText(getApplicationContext(), "Criança", Toast.LENGTH_LONG).show();
                }else if((idade>12) ||(idade<=18)){
                    Toast.makeText(getApplicationContext(), "Adolescente", Toast.LENGTH_LONG).show();
                } else if (idade>18){
                    Toast.makeText(getApplicationContext(), "Adulto", Toast.LENGTH_LONG).show();
                }

            }else {
                idade= year-ano-1;
                if(idade<=12){
                    Toast.makeText(getApplicationContext(), "Criança", Toast.LENGTH_LONG).show();
                }else if((idade>12) ||(idade<=18)){
                    Toast.makeText(getApplicationContext(), "Adolescente", Toast.LENGTH_LONG).show();
                } else if (idade>18){
                    Toast.makeText(getApplicationContext(), "Adulto", Toast.LENGTH_LONG).show();
                }

            }


        } else{
            idade= (year-ano)-1;
            if(idade<=12){
                Toast.makeText(getApplicationContext(), "Criança", Toast.LENGTH_LONG).show();
            }else if((idade>12)&&(idade<=18)){
                Toast.makeText(getApplicationContext(), "Adolescente", Toast.LENGTH_LONG).show();
            } else if (idade>18){
                Toast.makeText(getApplicationContext(), "Adulto", Toast.LENGTH_LONG).show();
            }

        }
        





    }


}
