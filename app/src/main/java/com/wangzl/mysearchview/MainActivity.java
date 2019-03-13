package com.wangzl.mysearchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wangzl.searchview.view.MySerachView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MySerachView mySerachView;

    private List<String> mOptionsItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySerachView =  findViewById(R.id.my_search_view);

        mOptionsItems.add("简书-创作你的创作1");
        mOptionsItems.add("双肩包刷金宝2");
        mOptionsItems.add("简书-创作你的创作3");
        mOptionsItems.add("item34");
        mOptionsItems.add("简书-创作你的创作5");
        mOptionsItems.add("item56");
        mOptionsItems.add("简书-创作你的创作7");
        mOptionsItems.add("item7");
        mOptionsItems.add("简书-创作你的创作");
        mOptionsItems.add("item9");
        mOptionsItems.add("简书-创作你的创作");
        mOptionsItems.add("item11");

        mySerachView.setData(mOptionsItems);
        mySerachView.invalidate();


        mySerachView.setOnClickListenerOnSearch(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chooseStr = mySerachView.chooseData();
                Toast.makeText(MainActivity.this,chooseStr+"",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
