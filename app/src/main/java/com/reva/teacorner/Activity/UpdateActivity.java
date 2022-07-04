package com.reva.teacorner.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.reva.teacorner.R;

public class UpdateActivity extends AppCompatActivity {
EditText  ednme,edmobikle,edtime,Amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ednme= findViewById(R.id.ednme);
        edmobikle= findViewById(R.id.edmobikle);
        edtime= findViewById(R.id.edtime);
        Amount= findViewById(R.id.Amount);

        final Khata khata= (Khata) getIntent().getSerializableExtra("khata");

        loadTask(khata);
        findViewById(R.id.btnupdt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
                updateTask(khata);
            }
        });

        findViewById(R.id.btndlt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteTask(khata);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();
            }
        });
    }

    private void loadTask(Khata task) {
        ednme.setText(task.getUsrname());
        edmobikle.setText(task.getMobile());
        edtime.setText(task.getDate());
        Amount.setText(task.getAmount());
    }

    private void updateTask(final Khata task) {
        final String sTask = ednme.getText().toString().trim();
        final String sDesc = edmobikle.getText().toString().trim();
        final String sFinishBy = edtime.getText().toString().trim();
        final String samnt = Amount.getText().toString().trim();

        if (sTask.isEmpty()) {
            ednme.setError("Name required");
            ednme.requestFocus();
            return;
        }

        if (sDesc.isEmpty()) {
            edmobikle.setError("Mobile Number required");
            edmobikle.requestFocus();
            return;
        }

        if (sFinishBy.isEmpty()) {
            edtime.setError("Time required");
            edtime.requestFocus();
            return;
        }
        if (samnt.isEmpty()) {
            edtime.setError("Amount required");
            edtime.requestFocus();
            return;
        }

        class UpdateTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                task.setUsrname(sTask);
                task.setMobile(sDesc);
                task.setDate(sFinishBy);
                task.setAmount(samnt);
                DataBaseClient.getInstance(getApplicationContext()).getChaiDatabse().khataDao().update(task);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(UpdateActivity.this, KhataActivity.class));
            }
        }

        UpdateTask ut = new UpdateTask();
        ut.execute();
    }


    private void deleteTask(final Khata task) {
        class DeleteTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                DataBaseClient.getInstance(getApplicationContext()).getChaiDatabse()
                        .khataDao()
                        .delete(task);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(UpdateActivity.this, KhataActivity.class));
            }
        }

        DeleteTask dt = new DeleteTask();
        dt.execute();

    }
}