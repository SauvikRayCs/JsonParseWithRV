package com.ray.sauvik.jsonparsewithrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();


    }
    public void onClickParse(View view){
        processJSON();
    }
    private void processJSON(){
        String jsonString = loadJSONFromAsset();
        if(jsonString != null)
        {
            try
            {
                JSONArray mJSONArray = new JSONArray(jsonString);

                for(int i = 0; i < mJSONArray.length(); i++)
                {
                    JSONObject mJSONObject = mJSONArray.getJSONObject(i);

                    String userName = mJSONObject.getString("name");
                    String userAddress = mJSONObject.getString("email");

                        int id = mJSONObject.getInt("id");



                    mExampleList.add(new ExampleItem(userName, userAddress, id));
                }
                mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                mRecyclerView.setAdapter(mExampleAdapter);


            } catch (JSONException e)
            {
                e.printStackTrace();
            }

        }
    }

    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("UserList.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
