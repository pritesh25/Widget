package com.example.user.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.support.constraint.solver.widgets.WidgetContainer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerview;
    private MyAdapter myAdapter;
    private List<DataModel> dataModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        List<AppWidgetProviderInfo> infoList = manager.getInstalledProviders();
        for (AppWidgetProviderInfo info : infoList) {
            Log.d(TAG,"******************************");
            Log.d(TAG, "Name                    : " + info.label);
            Log.d(TAG, "Provider PNGName        : " + info.provider.getPackageName());
            Log.d(TAG, "Provider Name           : " + info.provider);
            Log.d(TAG, "Configure Name          : " + info.configure);
            Log.d(TAG, "Configure Icon          : " + info.icon);
            Log.d(TAG, "Configure previewImage  : " + info.previewImage);
            Log.d(TAG, "Configure widgetCategory: " + info.widgetCategory);

            dataModels.add(new DataModel(info.label,info.provider.getPackageName(),info.provider,info.configure,info.icon,info.previewImage,info.widgetCategory));

        }

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(getApplicationContext(),dataModels);
        recyclerview.setAdapter(myAdapter);


    }
}
