package com.example.jkpc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        Button button = (Button) findViewById(R.id.button) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PostActivity.this, PostViewActivity.class) ;
                EditText editText1 = (EditText)findViewById(R.id.editText3) ;
                intent.putExtra("contact_writer", editText1.getText().toString()) ;

                EditText editText = (EditText)findViewById(R.id.editText) ;
                intent.putExtra("contact_title", editText.getText().toString()) ;

                EditText editText2 = (EditText)findViewById(R.id.editText2) ;
                intent.putExtra("contact_content", editText2.getText().toString());

                startActivity(intent);
            }
        });
    }
}