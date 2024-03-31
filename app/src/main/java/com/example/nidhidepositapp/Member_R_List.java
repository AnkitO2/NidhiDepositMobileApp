package com.example.nidhidepositapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nidhidepositapp.Request.MemberRDPlanListRequest;
import com.example.nidhidepositapp.Response.MemberRDPlan;
import com.example.nidhidepositapp.Response.MemberRDPlanListResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.ListRMemberBinding;
import com.google.android.material.navigation.NavigationView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Member_R_List extends AppCompatActivity {
private ListRMemberBinding binding;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ListRMemberBinding.inflate(getLayoutInflater());
        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        RDPlanListData();
        setContentView(binding.getRoot());

        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });
        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1){
                    Intent intent = new Intent(Member_R_List.this,HomeActivity.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan2) {
                    Intent intent = new Intent(Member_R_List.this,PlanList.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(Member_R_List.this,LedgerList.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent =new Intent(Member_R_List.this,MemberDashboard.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                }    else if (itemId == R.id.Loan5) {
                    Intent intent = new Intent(Member_R_List.this,LoginActivity.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("loginStatus", "");
                    editor.apply();
                    startActivity(intent);
                }
                return true; // Return true to indicate that the item click is handled
            }
        });
    }
    void RDPlanListData(){
        MemberRDPlanListRequest request =new MemberRDPlanListRequest();
        request.setMemberId(getIntent().getStringExtra("memberId"));
        request.setTokenString(getIntent().getStringExtra("token"));

        RetrofitClient.getClient().RDPlanListActivity(request).enqueue(new Callback<MemberRDPlanListResponse>() {
            @Override
            public void onResponse(Call<MemberRDPlanListResponse> call, Response<MemberRDPlanListResponse> response) {
            if(response.body().getMessage().equalsIgnoreCase("Successful")){
                Log.d("Response", "Body: " + response.body().toString());
                 //binding.accountId1.setText(response.body().getMessage());
                List<MemberRDPlan>list = response.body().getMemberRDPlanList();

                if (list.size()>0){

                    binding.recyclerview.setLayoutManager(new LinearLayoutManager(Member_R_List.this, RecyclerView.VERTICAL,false));
                    binding.recyclerview.setAdapter(new MemberListAdapter(list,Member_R_List.this));
                }

            }
            else {
                Toast.makeText(Member_R_List.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(Member_R_List.this,LoginActivity.class);
                startActivity(intent);
            }
            }
            @Override
            public void onFailure(Call<MemberRDPlanListResponse> call, Throwable t) {
                Toast.makeText(Member_R_List.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}