package com.example.pmill.project4part2;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onValuesClick(View view)
    {
        if(view.getId() == R.id.Bvalues) {
            Intent i = new Intent(MainActivity.this, EnterValues.class);
            startActivity(i);
        }
    }

    public void onResultClick(View view)
    {
        if(view.getId() == R.id.Bresults) {
            EditText searchTerm = (EditText)findViewById(R.id.TFterm);
            String searchString = searchTerm.getText().toString();

            String resultAnt = helper.searchTerm(searchString);

            Intent i = new Intent(MainActivity.this, Results.class);
            i.putExtra("Term", searchString);
            i.putExtra("Result",resultAnt);
            startActivity(i);
        }
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
