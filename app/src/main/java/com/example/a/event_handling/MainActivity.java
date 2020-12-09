package com.example.a.event_handling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_bc_cg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_bc_cg = findViewById(R.id.tv_bc_cg);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                TextView statusText = findViewById(R.id.tv_bc_cg);
                statusText.setText("Button clicked");
                }
            }
        );

        btn.setOnLongClickListener(new Button.OnLongClickListener() {
            public boolean onLongClick(View view) {
                TextView statusText = findViewById(R.id.tv_bc_cg);
                statusText.setText("Long button click");
                return true;
            }
        }
        );


    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.btn_clk:
                setTitle("Button Click");
                btn.setVisibility(View.VISIBLE);
                tv_bc_cg.setVisibility(View.VISIBLE);
                //textView1.setVisibility(View.INVISIBLE);
                //textView2.setVisibility(View.INVISIBLE);
                return true;

            case R.id.mot_ev:
                setTitle("Motion Event");
                btn.setVisibility(View.INVISIBLE);
                tv_bc_cg.setVisibility(View.INVISIBLE);
                //textView1.setVisibility(View.VISIBLE);
                //textView2.setVisibility(View.VISIBLE);

                return true;
            case R.id.com_ges:

                setTitle("Common Gestures");
                //btn.setVisibility(View.INVISIBLE);
                //tv_bc_cg.setVisibility(View.VISIBLE);
                //textView1.setVisibility(View.INVISIBLE);
                //textView2.setVisibility(View.INVISIBLE);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}