package com.example.t2;

import android.graphics.Point;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class Build extends AppCompatActivity {
    /**
     * Current phone dimensions.
     * Display width is stored in PHONE_DIMS.x and height in PHONE_DIMS.y.
     */
    protected static final Point PHONE_DIMS = new Point();

    /** Dimensions of the Pixel 2. Private because you should not need these. */
    private static final Point PIXEL_DIMS = new Point(1080, 1920);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindowManager().getDefaultDisplay().getSize(PHONE_DIMS);

        // Sets the UI layout to this activity.
        setContentView(R.layout.activity_main);
    }

    /**
     * Adds an image to the doodleView with the given position and size.
     *
     * @param doodleView    View to draw image in
     * @param imageName Filename for image in 'res/drawable'.
     * @param x Horizontal location from top left in px.
     * @param y Vertical location from top left px.
     * @param size Width and height of image on-screen in ox.
     * @return ImageView which has been added to doodleView.
     */
    public abstract ImageView addImage(FrameLayout doodleView, String imageName, float x, float y, int size);

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
    public abstract TextView addText(FrameLayout doodleView, String text, float x, float y, int fontSize,
                                     int color);


    public float scaleY(float y) {
        return y * PHONE_DIMS.y / PIXEL_DIMS.y;
    }

    public float scaleX(float x) {
        return x * PHONE_DIMS.x / PIXEL_DIMS.x;
    }
}
