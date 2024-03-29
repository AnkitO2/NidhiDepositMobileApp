package com.example.nidhidepositapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.nidhidepositapp.Request.MemberFDPlanListRequest;
import com.example.nidhidepositapp.Response.MemberFDPlan;
import com.example.nidhidepositapp.Response.MemberFDPlanListResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    RecyclerView recyclerview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview1=findViewById(R.id.recyclerview1);

        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);


        PlanListData();

    }

    void PlanListData(){
        MemberFDPlanListRequest request = new MemberFDPlanListRequest();
        request.setMemberId(getIntent().getStringExtra("memberId"));
        request.setTokenString(getIntent().getStringExtra("token"));
        RetrofitClient.getClient().PlanListActivity(request).enqueue(new Callback<MemberFDPlanListResponse>() {
            @Override
            public void onResponse(Call<MemberFDPlanListResponse> call, Response<MemberFDPlanListResponse> response) {
                if (response.body().getMessage().equalsIgnoreCase("Successful")){
                    Log.d("Response", "Body: " + response.body().toString());

                    List<MemberFDPlan> data = response.body().getMemberFDPlanList();
                    RecyclerView recyclerView = findViewById(R.id.recyclerview1);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(new MyAdapter(data));
                }else {
                    Toast.makeText(MainActivity.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<MemberFDPlanListResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}