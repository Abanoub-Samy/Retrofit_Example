package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit ;
    JsonApi jsonApi ;
    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);

        retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").
                addConverterFactory(GsonConverterFactory.create()).build();
        jsonApi = retrofit.create(JsonApi.class);
        createpost();

    }
    private void getpost(){
        Map<String,String> map = new HashMap<>();
        map.put("userId","3");
        map.put("_sort","id");
        map.put("_order","desc");

        Call<List<Model>> call = jsonApi.getUserId(map);
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(!response.isSuccessful()){
                    textView.setText("Code : " + response.code());
                    return;
                }

                List<Model> list = response.body();
                for (Model model : list) {
                    String content = "";
                    content += "ID: " + model.getId() + "\n";
                    content += "User ID: " + model.getUserId() + "\n";
                    content += "Title: " + model.getTitle() + "\n";
                    content += "Text: " + model.getBody() + "\n\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "some thing wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }




    private void createpost(){

        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "25");
        fields.put("title", "New Title");

        Model model = new Model(1,"abanoub","samy"); // id will generate auto
        Call<Model> call=jsonApi.createPosts(model);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(!response.isSuccessful()){
                    textView.setText("Code : " + response.code());
                    return;
                }
               Model body = response.body();

                    String content = "";
                    content += "CODE : " + response.code() + "\n"; //code should be 201
                    content += "ID: " + body.getId() + "\n";
                    content += "User ID: " + body.getUserId() + "\n";
                    content += "Title: " + body.getTitle() + "\n";
                    content += "Text: " + body.getBody() + "\n\n";

                    textView.append(content);


            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, " some thing wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
