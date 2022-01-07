package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

public class MemberInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);

        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);
        TextView text4 = findViewById(R.id.text4);
        TextView noResult = findViewById(R.id.noResult);
        Gson gson = new GsonBuilder().create();

        Intent intent = getIntent();
        String str = intent.getStringExtra("str");
        Member member = gson.fromJson(str, Member.class);

        if(str != null){
            text1.setText(member.getMb_name());
            text2.setText(member.getMb_email());
            text3.setText(member.getMb_password());
            text4.setText(member.getMb_birthdt());
        }else {
            noResult.setText("검색결과 없음!");
        }

    }
}