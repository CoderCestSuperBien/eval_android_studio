package com.example.eval_android_studio_joris;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;

import bsh.Interpreter;

public class CalculatriceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

    }

    //la string resultat donne sa valeur à textEcran qui l'affiche à l'écran
    private String resultat = "";
    private TextView textEcran;



    //S'active lorsqu'on appuie sur une touche de la calculatrice
    public void onTouch(View v){

        textEcran = findViewById(R.id.ecranCalculatrice);
        String valeur = (String) v.getTag();

        //lorsqu'on appuie sur Clear textEcran et resultat sont réinitialisés
        if(valeur.equals("c"))
        {
            textEcran.setText("");
            resultat = "";
        }
        //sur égal, on active la méthode qui interprete la saisie de l'utilisateur et retourne le resultat de l'opération sous forme de string
        else if (valeur.equals("="))
        {
            resultat = interpreteEtCalcul(resultat);
            //on met à jour l'écran avec la nouvelle valeur de resultat
            updateEcran(resultat);
        }
        else
        {
            resultat = resultat + valeur;
            updateEcran(resultat);
        }

    }



    public void updateEcran(String resultat){

        textEcran.setText(resultat);
    }



    public String interpreteEtCalcul(String resultat)
    {
        Interpreter interpreter = new Interpreter();
        String result = null;

        try{

            if (interpreter.eval(resultat) instanceof Integer)
            {
                Integer res = (Integer) interpreter.eval(resultat);
                result = Integer.toString(res);
            }
            else if (interpreter.eval(resultat) instanceof Double)
            {
                Double res = (Double) interpreter.eval(resultat);
                result = String.valueOf(res);
            }

            return result;


        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }

    }

}
