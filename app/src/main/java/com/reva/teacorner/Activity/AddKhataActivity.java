package com.reva.teacorner.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.reva.teacorner.R;

public class AddKhataActivity extends AppCompatActivity {
EditText ednme,edmobikle,edtime,Amount;
AppCompatButton addto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_khata);
        ednme= findViewById(R.id.ednme);
        edmobikle= findViewById(R.id.edmobikle);
        edtime= findViewById(R.id.edtime);
        Amount= findViewById(R.id.Amount);
        addto= findViewById(R.id.addto);

        addto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addtask();
            }
        });
    }
    private  void addtask(){
        String name= ednme.getText().toString();
        String mobile= edmobikle.getText().toString();
        String time= edtime.getText().toString();
        String amount= Amount.getText().toString();

        if (name.isEmpty()){
            ednme.setError("Name Required");
            ednme.requestFocus();
            return;
        }
        if (mobile.isEmpty()){
            edmobikle.setError("Mobile Required");
            edmobikle.requestFocus();
            return;
        }
        if (time.isEmpty()){
            edtime.setError("TIme Required");
            edtime.requestFocus();
            return;
        }
        if (amount.isEmpty()){
            Amount.setError("Amount Required");
            Amount.requestFocus();
            return;
        }

        class SaveData extends AsyncTask<Void,Void,Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                Khata khata= new Khata();
                khata.setUsrname(name);
                khata.setMobile(mobile);
                khata.setDate(time);
                khata.setAmount(amount);
                khata.setPaid(false);

DataBaseClient.getInstance(getApplicationContext()).getChaiDatabse().khataDao().insert(khata);
                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                finish();
                startActivity(new Intent(getApplicationContext(), KhataActivity.class));
                Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
            }
        }

        SaveData st = new SaveData();
        st.execute();
    }


}