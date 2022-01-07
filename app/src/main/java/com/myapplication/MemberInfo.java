package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MemberInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);

        TextView textView = findViewById(R.id.test);
        Gson gson = new GsonBuilder().create();

        Intent intent = getIntent();
        String str = intent.getStringExtra("str");
        Member member = gson.fromJson(str, Member.class);

        if(str != null){
            textView.setText(member.getMb_password());
        }else {
            textView.setText("검색결과 없음!");
        }

    }
}