package com.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static List<Member> memberList = new ArrayList<>();
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new HttpAsyncTask().execute("Http://192.168.0.56:8080/member");

        Button btn = findViewById(R.id.btn);
        EditText editText = findViewById(R.id.editText);
        btn.setOnClickListener(view -> {
            int i =0;
            str = editText.getText().toString();
            ArrayList<Member> mList = new ArrayList<>();

            while (i<memberList.size()) {
                if (memberList.get(i).getMb_email().contains(str)) {
                    mList.add(memberList.get(i));
                }
                i++;
            }
            if (mList.size() > 0) {
                Intent intent = new Intent(MainActivity.this, MemberInfo.class);
                intent.putExtra("mList", mList);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "검색결과가 없습니다", Toast.LENGTH_SHORT).show();
            }
        });



    }
    private static class HttpAsyncTask extends AsyncTask<String, Void, String> {


        OkHttpClient client = new OkHttpClient();

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected String doInBackground(String... params) {

            String result = null;
            String strUrl = params[0];
            try {
                Request request = new Request.Builder()
                        .url(strUrl)
                        .build();

                Response response = client.newCall(request).execute();
                Gson gson = new Gson();

                Type listType = new TypeToken<ArrayList<Member>>() {}.getType();
                memberList = gson.fromJson(response.body().string(), listType);

                Log.d(TAG, "doInBackground: " + memberList.toString());
                Log.d(TAG, "doInBackground: " + memberList.size());
                Log.d(TAG, "doInBackground: " + memberList.get(1).getMb_email());
                Log.d(TAG, "doInBackground: " + gson.toJson(memberList.get(1)));


            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                Log.d(TAG, s);
            }
        }
    }


}