package com.example.a.event_handling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat gDetector;

    TextView tv_bc_cg;
    TextView tv_me1;
    TextView tv_me2;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout myLayout = findViewById(R.id.activity_main);


        //myLayout.setOnTouchListener(new ConstraintLayout.OnTouchListener() {
            //public boolean onTouch(View view, MotionEvent m) {
                //handleTouch(m);
                //return true;
            //}
        //}
        //);

        tv_bc_cg = findViewById(R.id.tv_bc_cg);
        tv_me1 = findViewById(R.id.tv_me1);
        tv_me2 = findViewById(R.id.tv_me2);
        btn = (Button) findViewById(R.id.btn);

        btn.setVisibility(View.INVISIBLE);
        tv_bc_cg.setVisibility(View.INVISIBLE);
        tv_me1.setVisibility(View.INVISIBLE);
        tv_me1.setVisibility(View.INVISIBLE);

        this.gDetector = new GestureDetectorCompat(this,this);
        gDetector.setOnDoubleTapListener(this);


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
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        handleTouch(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        tv_bc_cg.setText ("onDown");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
        tv_bc_cg.setText("onFling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        tv_bc_cg.setText("onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        tv_bc_cg.setText("onScroll");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        tv_bc_cg.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        tv_bc_cg.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        tv_bc_cg.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        tv_bc_cg.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        tv_bc_cg.setText("onSingleTapConfirmed");
        return true;
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
                tv_bc_cg.setText("");
                btn.setVisibility(View.VISIBLE);
                tv_bc_cg.setVisibility(View.VISIBLE);
                tv_me1.setVisibility(View.INVISIBLE);
                tv_me2.setVisibility(View.INVISIBLE);
                return true;

            case R.id.mot_ev:
                setTitle("Motion Event");
                btn.setVisibility(View.INVISIBLE);
                tv_bc_cg.setVisibility(View.INVISIBLE);
                tv_me1.setVisibility(View.VISIBLE);
                tv_me2.setVisibility(View.VISIBLE);

                return true;
            case R.id.com_ges:

                setTitle("Common Gestures");
                tv_bc_cg.setText("");
                btn.setVisibility(View.INVISIBLE);
                tv_bc_cg.setVisibility(View.VISIBLE);
                tv_me1.setVisibility(View.INVISIBLE);
                tv_me2.setVisibility(View.INVISIBLE);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void handleTouch(MotionEvent m) {
        TextView textView1 = findViewById(R.id.tv_me1);
        TextView textView2 = findViewById(R.id.tv_me2);

        int pointerCount = m.getPointerCount();

        for (int i = 0; i < pointerCount; i++)
        {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;


            switch (action)
            {
                case MotionEvent.ACTION_DOWN:
                    actionString = "DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "PNTR DOWN";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "PNTR UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "MOVE";
                    break;
                default:
                    actionString = "";
            }

            String touchStatus = "Action: " + actionString + " Index: " +
                    actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
            if (id == 0)
                textView1.setText(touchStatus);
            else
                textView2.setText(touchStatus);
        }
    }

}