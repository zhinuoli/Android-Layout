package com.example.t2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout doodleView;

    private int width;
    private int height;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sets the UI layout to this activity.
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        doodleView = findViewById(R.id.doodleView);

        // wait for views to actually be laid out on the screen before we do any measurements
        doodleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout(){
                doodleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                width = doodleView.getWidth();
                height = doodleView.getHeight();

                TextView uw = addText(doodleView,"UW", scaleX(0.4f), scaleY(0.2f), 50, Color.rgb(145,123,76));
                TextView appDev = addText(doodleView,"AppDev", scaleX(0.3f), scaleY(0.3f), 50, Color.rgb(51,0,111));
                ImageView heart = addImage(doodleView, R.drawable.heart, scaleX(0.3f), scaleY(0.5f), (int)(width*0.4), (int)(height*0.4));

            }
        });

        // Adds a line under "UW".
//        addLine(doodleView, 0, scaleY(1950), scaleX(1440), scaleY(1950), 5,
//                Color.rgb(145,123,76));
    }

    /**
     * Adds an image to the doodleView with the given position and size.
     *
     * @param doodleView    View to draw image in
     * @param imageResId resource id for image in 'res/drawable'.
     * @param x Horizontal location from top left in px.
     * @param y Vertical location from top left px.
     * @param width Width of image on-screen in px.
     * @param height Height of image on-screen in px.
     * @return ImageView which has been added to doodleView.
     */
    public ImageView addImage(ConstraintLayout doodleView, int imageResId, float x, float y, int width, int height) {
        // Creates ImageView and add it to doodleView.
        ImageView imageView = new ImageView(this);
        doodleView.addView(imageView);

        // set size
        imageView.getLayoutParams().height = height;
        imageView.getLayoutParams().width = width;

        // set position
        imageView.setX(x);
        imageView.setY(y);

        // set image contents using filename
        imageView.setImageResource(imageResId);

        return imageView;
    }

    /**
     * Adds text to the doodleView with the given position, size, and color.
     *
     * @param doodleView    View to draw the text in.
     * @param text  Text to display on-screen.
     * @param x Horizontal location from top left in px.
     * @param y Vertical location from top left px.
     * @param fontSize  Scaled pixel size for text.
     * @param color Color for text in RGB.
     * @return TextView which has been added to doodleView.
     */
    public TextView addText(ConstraintLayout doodleView, String text, float x, float y, int fontSize, int color) {
        TextView textview = new TextView(this);
        doodleView.addView(textview);
        textview.setTextColor(color);
        textview.setTextSize(fontSize);

        textview.setX(x);
        textview.setY(y);

        textview.setText(text);

        return textview;
    }

    public float scaleX(float x) {
        return x*width;
    }

    public float scaleY(float y) {
        return y*height;
    }

}