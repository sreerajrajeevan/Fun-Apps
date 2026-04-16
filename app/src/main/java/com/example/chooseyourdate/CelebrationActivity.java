package com.example.chooseyourdate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class CelebrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebration);

        TextView emoji1 = findViewById(R.id.celebrationEmoji);
        
        // Simple "falling" animation for the emojis
        Animation animation = new TranslateAnimation(0, 0, -500, 500);
        animation.setDuration(2000);
        animation.setRepeatCount(Animation.INFINITE);
        emoji1.startAnimation(animation);
    }
}
