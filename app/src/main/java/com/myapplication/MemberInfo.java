package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MemberInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);

        Intent intent = getIntent();
        ArrayList<Member> memberArrayList = intent.getParcelableArrayListExtra("mList");
        ArrayList<String> mb_id = new ArrayList<>();

        for (int i = 0; i < memberArrayList.toArray().length; i++) {
            String str = memberArrayList.get(i).getMb_email().toString();
            mb_id.add(str);
        }
        TextView tv = (TextView) findViewById(R.id.noResult);
        tv.setText(mb_id.toString());

    }
}