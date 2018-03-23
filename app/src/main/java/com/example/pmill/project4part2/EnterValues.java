package com.example.pmill.project4part2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

/**
 * Created by pmill on 3/23/2018.
 */

public class EnterValues extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entervalues);
    }

    public void onAddClick(View view)
    {
        if(view.getId() == R.id.Badd) {
            EditText pair1 = (EditText)findViewById(R.id.TFword);
            EditText pair2 = (EditText)findViewById(R.id.TFantonym);
            String word1 = pair1.getText().toString();
            String antonym = pair2.getText().toString();
            WordPair wordPair = new WordPair(word1,antonym);

            helper.insertWordPair(wordPair);
        }
    }
}
