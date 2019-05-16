package com.example.jkpc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PostViewActivity extends AppCompatActivity {
    private ArrayList<Comment> mArrayList;
    private CustomAdapter2 mAdapter;
    private RecyclerView mRecyclerView;
    Intent intent = getIntent() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postView);

        TextView writer = (TextView) findViewById(R.id.editText7) ;
        String viewWriter= intent.getStringExtra("contact_writer") ;
        if(viewWriter!=null) writer.setText(viewWriter) ;

        TextView title = (TextView) findViewById(R.id.editText6) ;
        String viewTitle = intent.getStringExtra("contact_title") ;
        if(viewTitle!=null) title.setText(viewTitle) ;

        TextView content = (TextView) findViewById(R.id.post_contents_text) ;
        String viewContent = intent.getStringExtra("contact_content") ;
        if(viewContent!=null) content.setText(viewContent);

        final EditText editTextName = (EditText) findViewById(R.id.editText5) ;
        final EditText editTextContents = (EditText) findViewById(R.id.editText4) ;
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mArrayList = new ArrayList<>();

        mAdapter = new CustomAdapter2(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        Button buttonInsert = (Button)findViewById(R.id.button6);
        Button buttonIntent = (Button)findViewById(R.id.button3);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = editTextName.getText().toString();
                String strContents = editTextContents.getText().toString() ;

                Comment com = new Comment(strName, strContents) ;

                mArrayList.add(com) ;
                mAdapter.notifyDataSetChanged();
            }
        });
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(PostViewActivity.this, PostListActivity.class) ;
                startActivity(intent) ;
            }
        });

        /*mAdapter.setItemClick(new CustomAdapter.ItemClick() {
            @Override
            public void onClick(View view, int position) {

            }
        });*/
    }

}
