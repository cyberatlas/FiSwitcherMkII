package com.example.fiswitchermkii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sprint_btn = findViewById(R.id.sprint);
        Button uscellular_btn = findViewById(R.id.uscellular);
        Button tmobile_btn = findViewById(R.id.tmobile);
        Button auto_btn = findViewById(R.id.auto);
        Button dialer_btn = findViewById(R.id.dialer);

        sprint_btn.setOnClickListener(this);
        uscellular_btn.setOnClickListener(this);
        tmobile_btn.setOnClickListener(this);
        auto_btn.setOnClickListener(this);
        dialer_btn.setOnClickListener(this);
    }


    /**
     * when button is clicked, adds the proper secret code to clipboard or opens the dialer
     * @param view
     */
    @Override
    public void onClick(View view){
        ClipboardManager clipboard;
        clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        String cliptext = "";
        switch(view.getId()) {
            case R.id.auto:
                cliptext = "*#*#342886#*#*";
                break;
            case R.id.dialer:
                Intent intent = new Intent("android.intent.action.DIAL");
                startActivity(intent);
//                sendBroadcast(new Intent("android.provider.Telephony.SECRET_CODE", Uri.parse("android_secret_code://4636")));
            case R.id.sprint:
                cliptext ="*#*#34777#*#*";
                break;
            case R.id.tmobile:
                cliptext = "*#*#34866#*#*";
                break;
            case R.id.uscellular:
                cliptext = "*#*#34872#*#*";
                break;

        }

        ClipData mydata;
        mydata = ClipData.newPlainText("text", cliptext);
        clipboard.setPrimaryClip(mydata);

    }
}