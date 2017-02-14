package com.example.wangjiawei.testplugin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_plugin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componentName = new ComponentName(MainActivity.this, "com.example.wangjiawei.plugin.TargetActivity");
                Intent intent = new Intent();
                intent.setComponent(componentName);
                startActivity(intent);
            }
        });
    }
}
