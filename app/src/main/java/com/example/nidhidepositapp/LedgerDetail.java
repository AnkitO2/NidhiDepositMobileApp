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

import com.example.nidhidepositapp.Request.MemberSavingLedgerDetailRequest;
import com.example.nidhidepositapp.Response.MemberSavingLedgerDetailResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.DetailLedgerBinding;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LedgerDetail extends AppCompatActivity {
    String TransId = "";
private DetailLedgerBinding binding;
SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetailLedgerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        if (!getIntent().getStringExtra("TransId").isEmpty()){
            TransId = getIntent().getStringExtra("TransId");
            LedgerDetailData();
        }

        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });

        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1){
                    Intent intent = new Intent(LedgerDetail.this,HomeActivity.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan2) {
                    Intent intent = new Intent(LedgerDetail.this,PlanList.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(LedgerDetail.this,LedgerListAdapter.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));

                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent =new Intent(LedgerDetail.this,Member_R_List.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                }  else if (itemId ==R.id.Loan5) {
                    Intent intent = new Intent(LedgerDetail.this,LoginActivity.class);
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
    void LedgerDetailData(){
        MemberSavingLedgerDetailRequest request = new MemberSavingLedgerDetailRequest();
        request.setMemberId(sharedPreferences.getString("memberId",""));
//        request.setMemberId(getIntent().getStringExtra("memberId"));
        request.setTokenString(sharedPreferences.getString("token",""));
//        request.setTokenString(getIntent().getStringExtra("token"));
        request.setTransId(TransId);
        RetrofitClient.getClient().LedgerDetailActivity(request).enqueue(new Callback<MemberSavingLedgerDetailResponse>() {
            @Override
            public void onResponse(Call<MemberSavingLedgerDetailResponse> call, Response<MemberSavingLedgerDetailResponse> response) {
                if (response.body().getMessage().equalsIgnoreCase("Successful")){
                    Log.d("Response", "Body: " + response.body().toString());
                       binding.homeData1.setText(response.body().getMessage());
                       binding.homeData2.setText(response.body().getMemberSavingLedgerDetail().getBranchName());
                       binding.homeData3.setText(response.body().getMemberSavingLedgerDetail().getDeposit());
                       binding.homeData4.setText(response.body().getMemberSavingLedgerDetail().getDescription());
                       binding.homeData5.setText(response.body().getMemberSavingLedgerDetail().getEntryType());
                       binding.homeData6.setText(response.body().getMemberSavingLedgerDetail().getMemberId());
                       binding.homeData7.setText(response.body().getMemberSavingLedgerDetail().getMemberName());
                       binding.homeData8.setText(response.body().getMemberSavingLedgerDetail().getSavingId());
                       binding.homeData9.setText(response.body().getMemberSavingLedgerDetail().getTransId());
                       binding.homeData10.setText(response.body().getMemberSavingLedgerDetail().getTransactionDate());
                       binding.homeData11.setText(response.body().getMemberSavingLedgerDetail().getVoucherId());
                       binding.homeData12.setText(response.body().getMemberSavingLedgerDetail().getWithdrawl());
                }else {
                    Toast.makeText(LedgerDetail.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(LedgerDetail.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<MemberSavingLedgerDetailResponse> call, Throwable t) {
                Toast.makeText(LedgerDetail.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}