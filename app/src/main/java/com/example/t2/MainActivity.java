package com.example.t2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Actions {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout doodleView = findViewById(R.id.doodleView);
        initView(doodleView);
    }

    private void initView(FrameLayout doodleView) {
        addText(doodleView,"I", scaleX(50), scaleY(50), 50,
                Color.rgb(145,123,76));
        TextView uw = addText(doodleView,"UW", scaleX(50), scaleY(1650), 50,
                Color.rgb(51,0,111));

        // Adds a line under "UW".
//        addLine(doodleView, 0, scaleY(1950), scaleX(1440), scaleY(1950), 5,
//                Color.rgb(145,123,76));
    }
}