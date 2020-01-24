package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bottle;
    private Random random = new Random();
    private int lastDirection;
    private boolean spinmo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);

    }

    public void spinBottle(View v) {
        if (!spinmo) {
            int newDirection = random.nextInt(2000);
            float pivx = bottle.getWidth() / 2;
            float pivy = bottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDirection, newDirection, pivx, pivy);
            rotate.setDuration(2800);
            rotate.setFillAfter(true);

            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinmo = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinmo = false;

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDirection = newDirection;
            bottle.startAnimation(rotate);

        }
    }
}
