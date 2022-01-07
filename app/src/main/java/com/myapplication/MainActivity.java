package com.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringReader;
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
        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        Gson gson = new GsonBuilder().create();
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                int i =0;
                str = editText.getText().toString();

                while (i<memberList.stream().count()) {
                    if (memberList.get(i).getMb_email().equals(str)) {
                        Intent intent = new Intent(MainActivity.this, MemberInfo.class);
                        intent.putExtra("str", gson.toJson(memberList.get(i)));
                        startActivity(intent);
                        break;
                    }else if(i == memberList.stream().count() - 1 && !memberList.get(i).getMb_email().equals(str)) {
                        Intent intent = new Intent(MainActivity.this, MemberInfo.class);
                        startActivity(intent);
                    }
                    i++;
                }
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
                Log.d(TAG, "doInBackground: " + memberList.stream().count());
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