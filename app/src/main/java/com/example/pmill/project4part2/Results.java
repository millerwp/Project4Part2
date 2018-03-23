package com.example.pmill.project4part2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pmill on 3/23/2018.
 */

public class Results extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        String term = getIntent().getStringExtra("Term");
        String ant = getIntent().getStringExtra("Result");

        TextView termView = (TextView)findViewById(R.id.TVword);
        termView.setText(term);

        TextView antView = (TextView)findViewById(R.id.TVantonym);
        antView.setText(ant);
    }


}
