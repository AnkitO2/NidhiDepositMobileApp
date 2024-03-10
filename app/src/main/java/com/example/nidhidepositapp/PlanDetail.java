package com.example.nidhidepositapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nidhidepositapp.Request.MemberFDPlanDetailRequest;
import com.example.nidhidepositapp.Response.MemberFDPlanDetailResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.DetailPlanBinding;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanDetail extends AppCompatActivity {
private DetailPlanBinding binding;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetailPlanBinding.inflate(getLayoutInflater());
        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        PlanDetailData();
        setContentView(binding.getRoot());

        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });
        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1){
                    Intent intent = new Intent(PlanDetail.this,HomeActivity.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan2) {
                    Intent intent = new Intent(PlanDetail.this,PlanList.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(PlanDetail.this,MemberDashboard.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent =new Intent(PlanDetail.this,LedgerList.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan5) {
                    Intent intent = new Intent(PlanDetail.this,LedgerDetail.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId ==R.id.Loan6) {
                    Intent intent = new Intent(PlanDetail.this,Member_R_List.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan7) {
                    Intent intent = new Intent(PlanDetail.this,Member_R_Detail.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId ==R.id.Loan8) {
                    Intent intent = new Intent(PlanDetail.this,LoginActivity.class);
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
    void PlanDetailData(){
        MemberFDPlanDetailRequest request = new MemberFDPlanDetailRequest();
        request.setMemberId(getIntent().getStringExtra("memberId"));
        request.setTokenString(getIntent().getStringExtra("token"));
        request.setAccountId("MI101000006");
        RetrofitClient.getClient().PlanDetailActivity(request).enqueue(new Callback<MemberFDPlanDetailResponse>() {
            @Override
            public void onResponse(Call<MemberFDPlanDetailResponse> call, Response<MemberFDPlanDetailResponse> response) {
              if (response.body().getMessage().equalsIgnoreCase("Successful")){
                  Log.d("Response", "Body: " + response.body().toString());
                  binding.homeData1.setText(response.body().getMessage());
                  binding.homeData2.setText(response.body().getMemberFDPlanDetail().getAccountExpiryDate());
                  binding.homeData3.setText(response.body().getMemberFDPlanDetail().getAccountId());
                  binding.homeData4.setText(response.body().getMemberFDPlanDetail().getAccountOpenDate());
                  binding.homeData5.setText(response.body().getMemberFDPlanDetail().getAccountOpenStatus());
                  binding.homeData6.setText(response.body().getMemberFDPlanDetail().getApproveDate());
                  binding.homeData7.setText(response.body().getMemberFDPlanDetail().getBeneficiaryAge());
                  binding.homeData8.setText(response.body().getMemberFDPlanDetail().getBeneficiaryName());
                  binding.homeData9.setText(response.body().getMemberFDPlanDetail().getBeneficiaryRelation());
                  binding.homeData10.setText(response.body().getMemberFDPlanDetail().getBranchName());
                  binding.homeData11.setText(response.body().getMemberFDPlanDetail().getCollectorId());
                  binding.homeData12.setText(response.body().getMemberFDPlanDetail().getCollectorName());
                  binding.homeData13.setText(response.body().getMemberFDPlanDetail().getLockStatus());
                  binding.homeData14.setText(response.body().getMemberFDPlanDetail().getLockType());
                  binding.homeData15.setText(response.body().getMemberFDPlanDetail().getMIPAmount());
                  binding.homeData16.setText(response.body().getMemberFDPlanDetail().getMIPMode());
                  binding.homeData17.setText(response.body().getMemberFDPlanDetail().getMaturityAmount());
                  binding.homeData18.setText(response.body().getMemberFDPlanDetail().getMaturityPaid());
                  binding.homeData19.setText(response.body().getMemberFDPlanDetail().getMaturityPaidDate());
                  binding.homeData20.setText(response.body().getMemberFDPlanDetail().getMaturityPaidMode());
                  binding.homeData21.setText(response.body().getMemberFDPlanDetail().getMaturityPayable());
                  binding.homeData22.setText(response.body().getMemberFDPlanDetail().getMaturityStatus());
              }
              else {
                  Toast.makeText(PlanDetail.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(PlanDetail.this,LoginActivity.class);
                  startActivity(intent);
              }
            }
            @Override
            public void onFailure(Call<MemberFDPlanDetailResponse> call, Throwable t) {
                Toast.makeText(PlanDetail.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}