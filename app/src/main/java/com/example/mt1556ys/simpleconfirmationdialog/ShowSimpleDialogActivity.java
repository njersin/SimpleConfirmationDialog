package com.example.mt1556ys.simpleconfirmationdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowSimpleDialogActivity extends AppCompatActivity implements SimpleDialog.SimpleDialogListener{

    TextView dialogResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_simple_dialog);

        dialogResult = (TextView) findViewById(R.id.dialog_result_text);

        Button showDialog = (Button) findViewById(R.id.show_dialog_button);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimpleDialog dialog = new SimpleDialog();

                Bundle dialogArgs = new Bundle();

                dialogArgs.putString("Message", "Custom Message - OK or Cancel?");

                dialog.setArguments(dialogArgs);

                //Show dialog on screen
                dialog.show(getFragmentManager(), dialog.getClass().getName());
            }
        });
    }

    public void userClickedOK() {
        dialogResult.setText("You selected OK");
    }

    public void userClickedCancel() {
        dialogResult.setText("You selected Cancel");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_simple_dialog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
