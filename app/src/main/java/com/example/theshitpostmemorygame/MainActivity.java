package com.example.theshitpostmemorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Clase principal del juego de memoria
 *
 * @Author Dani
 */
public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder dialog;
    int activatruco = 0;
    Button boton_0, boton_1, boton_2, boton_3, boton_4, boton_5, boton_6, boton_7, boton_8, boton_9, boton_start;
    MenuItem ajustes;
    TextView tv1;
    MediaPlayer mp1;
    String numeroRecordar;                //  "01111"
    String numeroJugador;
    int checkedItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton_0 = findViewById(R.id.button_0);
        boton_1 = findViewById(R.id.button_1);
        boton_2 = findViewById(R.id.button_2);
        boton_3 = findViewById(R.id.button_3);
        boton_4 = findViewById(R.id.button_4);
        boton_5 = findViewById(R.id.button_5);
        boton_6 = findViewById(R.id.button_6);
        boton_7 = findViewById(R.id.button_7);
        boton_8 = findViewById(R.id.button_8);
        boton_9 = findViewById(R.id.button_9);
        boton_start = findViewById(R.id.button_start);
        tv1 = findViewById(R.id.points);
        //Animación de los botones
        AnimatorSet animadorBoton = new AnimatorSet();
        ObjectAnimator trasladar;

        trasladar = ObjectAnimator.ofFloat(boton_0, "translationX", -500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();

        trasladar = ObjectAnimator.ofFloat(boton_2, "translationX", -500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(boton_4, "translationX", -500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(boton_6, "translationX", -500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(boton_8, "translationX", -500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(boton_1, "translationX", 500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(boton_3, "translationX", 500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(boton_5, "translationX", 500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(boton_7, "translationX", 500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(boton_9, "translationX", 500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(boton_start, "translationY", 300f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();

        trasladar = ObjectAnimator.ofFloat(tv1, "translationY", -500f, 0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        //Los botones están desactivados cuando no se está jugando
        desactivarBotones();

    }

    /*
     *Menú
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        ajustes = menu.findItem(R.id.ajustes);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //Dificultad
            case R.id.dificultad:
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Selecciona la dificultad");
                String[] items = {"Fácil", "Difícil"};
                dialog.setSingleChoiceItems(items, checkedItem, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            checkedItem = 0;
                            break;
                        case 1:
                            checkedItem = 1;
                            break;
                    }
                });
                AlertDialog alert = dialog.create();
                alert.setCanceledOnTouchOutside(true);
                alert.show();
                break;
            //Trucos
            case R.id.trucos:
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("¿Quieres usar los trucos?");
                dialog.setNegativeButton("Desactivar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        activatruco = 0;
                    }
                });
                dialog.setPositiveButton("Activar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        activatruco = 1;
                    }
                });
                AlertDialog alert2 = dialog.create();
                alert2.setCanceledOnTouchOutside(true);
                alert2.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    *Se desactivan todos los botones excepto el de iniciar
     */
    private void desactivarBotones() {
        boton_0.setEnabled(false);
        boton_1.setEnabled(false);
        boton_2.setEnabled(false);
        boton_3.setEnabled(false);
        boton_4.setEnabled(false);
        boton_5.setEnabled(false);
        boton_6.setEnabled(false);
        boton_7.setEnabled(false);
        boton_8.setEnabled(false);
        boton_9.setEnabled(false);
    }
    /*
     *Se activan todos los botones
     */
    private void activarBotones() {
        boton_0.setEnabled(true);
        boton_1.setEnabled(true);
        boton_2.setEnabled(true);
        boton_3.setEnabled(true);
        boton_4.setEnabled(true);
        boton_5.setEnabled(true);
        boton_6.setEnabled(true);
        boton_7.setEnabled(true);
        boton_8.setEnabled(true);
        boton_9.setEnabled(true);
    }

    /*
    *Metodo llamado por el boton iniciar
     */
    public void iniciarJuego(View v) {
        //Se desactivan los ajustes para no cambiarlos en mitad del juego
        ajustes.setIcon(R.drawable.baseline_settings_25);
        ajustes.setEnabled(false);
        desactivarBotones();
        numeroRecordar = "";
        agregarUnNumeroAlFinal();
        if (activatruco == 1) {
            tv1.setTextSize(25);
            tv1.setText("Secuencia: " + numeroRecordar);
        } else {
            tv1.setText("Puntos: " + (numeroRecordar.length() - 1));
        }
        numeroJugador = "";
        emitirSonido(0);
    }

    private void emitirSonido(int posicion) {
        if (mp1 != null)
            mp1.release();
        //Sonido modo fácil
        if (checkedItem == 0) {
            if (numeroRecordar.charAt(posicion) == '0')
                mp1 = MediaPlayer.create(this, R.raw.cero);
            if (numeroRecordar.charAt(posicion) == '1')
                mp1 = MediaPlayer.create(this, R.raw.uno);
            if (numeroRecordar.charAt(posicion) == '2')
                mp1 = MediaPlayer.create(this, R.raw.dos);
            if (numeroRecordar.charAt(posicion) == '3')
                mp1 = MediaPlayer.create(this, R.raw.tres);
            if (numeroRecordar.charAt(posicion) == '4')
                mp1 = MediaPlayer.create(this, R.raw.cuatro);
            if (numeroRecordar.charAt(posicion) == '5')
                mp1 = MediaPlayer.create(this, R.raw.cinco);
            if (numeroRecordar.charAt(posicion) == '6')
                mp1 = MediaPlayer.create(this, R.raw.seis);
            if (numeroRecordar.charAt(posicion) == '7')
                mp1 = MediaPlayer.create(this, R.raw.siete);
            if (numeroRecordar.charAt(posicion) == '8')
                mp1 = MediaPlayer.create(this, R.raw.ocho);
            if (numeroRecordar.charAt(posicion) == '9')
                mp1 = MediaPlayer.create(this, R.raw.nueve);
        }
        //Sonido modo difícil
        if (checkedItem == 1) {
            if (numeroRecordar.charAt(posicion) == '0')
                mp1 = MediaPlayer.create(this, R.raw.fastcero);
            if (numeroRecordar.charAt(posicion) == '1')
                mp1 = MediaPlayer.create(this, R.raw.fastuno);
            if (numeroRecordar.charAt(posicion) == '2')
                mp1 = MediaPlayer.create(this, R.raw.fastdos);
            if (numeroRecordar.charAt(posicion) == '3')
                mp1 = MediaPlayer.create(this, R.raw.fasttres);
            if (numeroRecordar.charAt(posicion) == '4')
                mp1 = MediaPlayer.create(this, R.raw.fastcuatro);
            if (numeroRecordar.charAt(posicion) == '5')
                mp1 = MediaPlayer.create(this, R.raw.fastcinco);
            if (numeroRecordar.charAt(posicion) == '6')
                mp1 = MediaPlayer.create(this, R.raw.fastseis);
            if (numeroRecordar.charAt(posicion) == '7')
                mp1 = MediaPlayer.create(this, R.raw.fastsiete);
            if (numeroRecordar.charAt(posicion) == '8')
                mp1 = MediaPlayer.create(this, R.raw.fastocho);
            if (numeroRecordar.charAt(posicion) == '9')
                mp1 = MediaPlayer.create(this, R.raw.fastnueve);
        }
        mp1.start();
        mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (posicion < numeroRecordar.length() - 1) {
                    emitirSonido(posicion + 1);
                } else
                    activarBotones();
            }
        });

    }

    private void agregarUnNumeroAlFinal() {
        int ale = (int) (Math.random() * 10);
        switch (ale) {
            case 0:
                numeroRecordar = numeroRecordar + "0";
                break;
            case 1:
                numeroRecordar = numeroRecordar + "1";
                break;
            case 2:
                numeroRecordar = numeroRecordar + "2";
                break;
            case 3:
                numeroRecordar = numeroRecordar + "3";
                break;
            case 4:
                numeroRecordar = numeroRecordar + "4";
                break;
            case 5:
                numeroRecordar = numeroRecordar + "5";
                break;
            case 6:
                numeroRecordar = numeroRecordar + "6";
                break;
            case 7:
                numeroRecordar = numeroRecordar + "7";
                break;
            case 8:
                numeroRecordar = numeroRecordar + "8";
                break;
            case 9:
                numeroRecordar = numeroRecordar + "9";
                break;
        }
    }

    public void presionBoton0(View v) {
        numeroJugador = numeroJugador + "0";
        controlarSiEsCorrecto();
    }

    public void presionBoton1(View v) {
        numeroJugador = numeroJugador + "1";
        controlarSiEsCorrecto();
    }

    public void presionBoton2(View v) {
        numeroJugador = numeroJugador + "2";
        controlarSiEsCorrecto();
    }

    public void presionBoton3(View v) {
        numeroJugador = numeroJugador + "3";
        controlarSiEsCorrecto();
    }

    public void presionBoton4(View v) {
        numeroJugador = numeroJugador + "4";
        controlarSiEsCorrecto();
    }

    public void presionBoton5(View v) {
        numeroJugador = numeroJugador + "5";
        controlarSiEsCorrecto();
    }

    public void presionBoton6(View v) {
        numeroJugador = numeroJugador + "6";
        controlarSiEsCorrecto();
    }

    public void presionBoton7(View v) {
        numeroJugador = numeroJugador + "7";
        controlarSiEsCorrecto();
    }

    public void presionBoton8(View v) {
        numeroJugador = numeroJugador + "8";
        controlarSiEsCorrecto();
    }

    public void presionBoton9(View v) {
        numeroJugador = numeroJugador + "9";
        controlarSiEsCorrecto();
    }

    private void controlarSiEsCorrecto() {
        if (numeroJugador.charAt(numeroJugador.length() - 1) != numeroRecordar.charAt(numeroJugador.length() - 1)) {
            //Cuando se acaba el juego se reactivan los ajustes
            ajustes.setIcon(R.drawable.baseline_settings_24);
            ajustes.setEnabled(true);
            mp1 = MediaPlayer.create(this, R.raw.fallo);
            mp1.start();
            Toast.makeText(this, "Has fallado", Toast.LENGTH_LONG).show();
            desactivarBotones();
        } else if (numeroJugador.length() == numeroRecordar.length()) {
            desactivarBotones();
            numeroJugador = "";
            agregarUnNumeroAlFinal();
            emitirSonido(0);
            if (activatruco == 1) {
                tv1.setTextSize(25);
                tv1.setText("Secuencia: " + numeroRecordar);
            } else {
                tv1.setText("Puntos: " + (numeroRecordar.length() - 1));
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mp1 != null) {
            mp1.release();
            mp1 = null;
        }
    }
}
