package com.reva.teacorner.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.reva.teacorner.FixValue;
import com.reva.teacorner.R;

public class SignupActivity extends AppCompatActivity {
TextView lgntxt1;
EditText ednme,edmobl,edpass;
String strname,strmobl,strpass;
SharedPreferences sharedPreferences;
AppCompatButton signinbtn;
ConstraintLayout conssign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        lgntxt1= findViewById(R.id.lgntxt1);
        ednme= findViewById(R.id.ednme);
        edmobl= findViewById(R.id.edmobl);
        edpass= findViewById(R.id.edpass);
        conssign= findViewById(R.id.conssign);
        signinbtn= findViewById(R.id.signinbtn);

        lgntxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               validation();
            }
        });
    }

    public void validation(){
        strname=ednme.getText().toString();
        strmobl=edmobl.getText().toString();
        strpass=edpass.getText().toString();

        if (ednme.length()==0){
            Snackbar.make(conssign,"Please Enter Name",Snackbar.LENGTH_SHORT).show();
            ednme.getError();

        }
        if (edmobl.length()==0){
            Snackbar.make(conssign,"Please Enter Mobile No.",Snackbar.LENGTH_SHORT).show();
            edmobl.getError();

        }
        if (edpass.length()==0){
            Snackbar.make(conssign,"Please Enter Password",Snackbar.LENGTH_SHORT).show();
            edpass.getError();

        }
        getdata();
    }
    public  void getdata(){
        sharedPreferences= getSharedPreferences(FixValue.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(FixValue.FIRSTNAME,strname);
        editor.putString(FixValue.MOBILE,edmobl.toString());
        editor.putString(FixValue.PASSWORD,edpass.toString());
    }
}