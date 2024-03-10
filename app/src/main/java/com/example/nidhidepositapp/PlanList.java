package com.example.nidhidepositapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nidhidepositapp.Request.MemberFDPlanListRequest;
import com.example.nidhidepositapp.Response.MemberFDPlan;
import com.example.nidhidepositapp.Response.MemberFDPlanListResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.ListPlanBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanList extends AppCompatActivity {
private ListPlanBinding binding;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ListPlanBinding.inflate(getLayoutInflater());
        PlanListData();
        setContentView(binding.getRoot());
        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });
        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1){
                    Intent intent = new Intent(PlanList.this,MainActivity.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan2) {
                    Intent intent = new Intent(PlanList.this,HomeActivity.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(PlanList.this,MemberDashboard.class);
                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent = new Intent(PlanList.this,PlanDetail.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan5) {
                    Intent intent =new Intent(PlanList.this,LedgerList.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan6) {
                    Intent intent = new Intent(PlanList.this,LedgerDetail.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId == R.id.Loan9) {
                    Intent intent = new Intent(PlanList.this,LoginActivity.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("loginStatus", "");
                    editor.apply();
                    startActivity(intent);
                }
                return true; // Return true to indicate that the item click is handled
            }
        });
    }
    void PlanListData(){
        MemberFDPlanListRequest request = new MemberFDPlanListRequest();
        request.setMemberId(getIntent().getStringExtra("MemberID"));
        request.setTokenString(getIntent().getStringExtra("token"));
        RetrofitClient.getClient().PlanListActivity(request).enqueue(new Callback<MemberFDPlanListResponse>() {
            @Override
            public void onResponse(Call<MemberFDPlanListResponse> call, Response<MemberFDPlanListResponse> response) {
                if (response.isSuccessful()){
                    Log.d("Response", "Body: " + response.body().toString());
                    List<MemberFDPlan>list = response.body().getMemberFDPlanList();
                    binding.homeData1.setText(response.body().getMessage());
                    binding.homeData2.setText(list.get(0).getAccountId());
//                    binding.homeData3.setText(list.get(0).getAccountOpenDate());
//                    binding.homeData4.setText(list.get(0).getMIPAmount());
//                    binding.homeData5.setText(list.get(0).getMaturityAmount());
//                    binding.homeData6.setText(list.get(0).getPlanAmount());
//                    binding.homeData7.setText(list.get(0).getPlanNo());
//                    binding.homeData8.setText(list.get(0).getPlanType());
                }else {
                    Toast.makeText(PlanList.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MemberFDPlanListResponse> call, Throwable t) {
                Toast.makeText(PlanList.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}