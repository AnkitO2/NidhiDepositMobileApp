package com.example.nidhidepositapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nidhidepositapp.Request.MemberRDPlanDetailRequest;
import com.example.nidhidepositapp.Response.MemberRDPlanDetailResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.DetailRMemberBinding;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Member_R_Detail extends AppCompatActivity {
private DetailRMemberBinding binding;
SharedPreferences sharedPreferences;
String AccountId ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetailRMemberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        if (!getIntent().getStringExtra("AccountId").isEmpty()){
            AccountId = getIntent().getStringExtra("AccountId");
            RDPlanDetailData();
        }


        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });
        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1){
                    Intent intent = new Intent(Member_R_Detail.this,HomeActivity.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan2) {
                    Intent intent = new Intent(Member_R_Detail.this,PlanList.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(Member_R_Detail.this,PlanDetail.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent =new Intent(Member_R_Detail.this,LedgerList.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                }  else if (itemId == R.id.Loan5) {
                    Intent intent = new Intent(Member_R_Detail.this,LoginActivity.class);
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
void RDPlanDetailData(){
    MemberRDPlanDetailRequest request =new  MemberRDPlanDetailRequest();
    request.setMemberId(sharedPreferences.getString("memberId",""));
    //request.setMemberId(getIntent().getStringExtra("memberId"));
    request.setTokenString(sharedPreferences.getString("token",""));
   // request.setTokenString(getIntent().getStringExtra("token"));
    request.setAccountId(AccountId);

    RetrofitClient.getClient().RDPlanDetailActivity(request).enqueue(new Callback<MemberRDPlanDetailResponse>() {
        @Override
        public void onResponse(Call<MemberRDPlanDetailResponse> call, Response<MemberRDPlanDetailResponse> response) {
         if (response.body().getMessage().equalsIgnoreCase("Successful")){
             binding.homeData1.setText(response.body().getMessage());
             binding.homeData2.setText(response.body().getMemberRDPlanDetail().getAccountExpiryDate());
             binding.homeData3.setText(response.body().getMemberRDPlanDetail().getAccountId());
             binding.homeData4.setText(response.body().getMemberRDPlanDetail().getAccountOpenDate());
             binding.homeData5.setText(response.body().getMemberRDPlanDetail().getAccountOpenStatus());
             binding.homeData6.setText(response.body().getMemberRDPlanDetail().getApproveDate());
             binding.homeData7.setText(response.body().getMemberRDPlanDetail().getBeneficiaryAge());
             binding.homeData8.setText(response.body().getMemberRDPlanDetail().getBeneficiaryName());
             binding.homeData9.setText(response.body().getMemberRDPlanDetail().getBeneficiaryRelation());
             binding.homeData10.setText(response.body().getMemberRDPlanDetail().getBranchName());
             binding.homeData11.setText(response.body().getMemberRDPlanDetail().getCollectorId());
             binding.homeData12.setText(response.body().getMemberRDPlanDetail().getCollectorName());
             binding.homeData13.setText(response.body().getMemberRDPlanDetail().getLockStatus());
             binding.homeData14.setText(response.body().getMemberRDPlanDetail().getLockType());
//             binding.homeData15.setText(response.body().getMemberRDPlanDetail().getMIPAmount());
//             binding.homeData16.setText(response.body().getMemberRDPlanDetail().getMIPMode());
             binding.homeData17.setText(response.body().getMemberRDPlanDetail().getMaturityAmount());
             binding.homeData18.setText(response.body().getMemberRDPlanDetail().getMaturityPaid());
             binding.homeData19.setText(response.body().getMemberRDPlanDetail().getMaturityPaidDate());
             binding.homeData20.setText(response.body().getMemberRDPlanDetail().getMaturityPaidMode());
             binding.homeData21.setText(response.body().getMemberRDPlanDetail().getMaturityPayable());
             binding.homeData22.setText(response.body().getMemberRDPlanDetail().getMaturityStatus());
         }
         else {
             Toast.makeText(Member_R_Detail.this, "response is not successfully", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(Member_R_Detail.this,LoginActivity.class);
             startActivity(intent);
         }
        }

        @Override
        public void onFailure(Call<MemberRDPlanDetailResponse> call, Throwable t) {
            Toast.makeText(Member_R_Detail.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    });

    }
}