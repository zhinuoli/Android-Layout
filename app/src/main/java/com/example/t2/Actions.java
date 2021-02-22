package com.example.t2;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class Actions extends Build{
    @Override
    public ImageView addImage(FrameLayout doodleView, String imageName, float x, float y, int size) {
        // Creates ImageView and add it to doodleView.
        ImageView imageView = new ImageView(this);
        doodleView.addView(imageView);

        //set size
        imageView.getLayoutParams().height = size;
        imageView.getLayoutParams().width = size;

        //set position
        imageView.setX(x);
        imageView.setY(y);

        //set image contents using filename
        int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imageView.setImageResource(resID);

        return imageView;
    }

    @Override
    public TextView addText(FrameLayout doodleView, String text, float x, float y, int fontSize,
                            int color) {

        TextView textview = new TextView(this);
        doodleView.addView(textview);
        textview.setTextColor(color);
        textview.setTextSize(fontSize);

        textview.setX(x);
        textview.setY(y);

        textview.setText(text);
        return textview;
    }

}
