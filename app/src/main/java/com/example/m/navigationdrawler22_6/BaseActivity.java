package com.example.m.navigationdrawler22_6;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();

        try {
            SharedPreferences settings = getSharedPreferences("com.example.m.navigationdrawler22_6", Context.MODE_PRIVATE);

            String fontSizePref = settings.getString("FONT_SIZE", "Medium");

            int themeID = R.style.FontSizeMedium;
            if (fontSizePref.equals("Small")) {
                themeID = R.style.FontSizeSmall;
            }
            else if (fontSizePref.equals("Large")) {
                themeID = R.style.FontSizeLarge;
            }

            setTheme(themeID);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
