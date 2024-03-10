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
        binding = ListPlanBinding.inflate(getLayoutInflater());
        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
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
                    Intent intent = new Intent(PlanList.this,HomeActivity.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan2) {
                    Intent intent = new Intent(PlanList.this,MemberDashboard.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(PlanList.this,PlanDetail.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent = new Intent(PlanList.this,LedgerList.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan5) {
                    Intent intent =new Intent(PlanList.this,LedgerDetail.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan6) {
                    Intent intent = new Intent(PlanList.this,Member_R_List.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId ==R.id.Loan7) {
                    Intent intent = new Intent(PlanList.this,Member_R_Detail.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId ==R.id.Loan8) {
                    Intent intent = new Intent(PlanList.this,LoginActivity.class);
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
    void PlanListData(){
        MemberFDPlanListRequest request = new MemberFDPlanListRequest();
        request.setMemberId(getIntent().getStringExtra("memberId"));
        request.setTokenString(getIntent().getStringExtra("token"));
        RetrofitClient.getClient().PlanListActivity(request).enqueue(new Callback<MemberFDPlanListResponse>() {
            @Override
            public void onResponse(Call<MemberFDPlanListResponse> call, Response<MemberFDPlanListResponse> response) {
                if (response.body().getMessage().equalsIgnoreCase("Successful")){
                    Log.d("Response", "Body: " + response.body().toString());
                    binding.massage.setText(response.body().getMessage());
                    List<MemberFDPlan>list = response.body().getMemberFDPlanList();
                    binding.accountId1.setText(list.get(0).getAccountId());
                    binding.oDate1.setText(list.get(0).getAccountOpenDate());
                    binding.mAmmount1.setText(list.get(0).getMIPAmount());
                    binding.maturatityAmmount1.setText(list.get(0).getMaturityAmount());
                    binding.pAmmount1.setText(list.get(0).getPlanAmount());
                    binding.pNo1.setText(list.get(0).getPlanNo());
                    binding.pType1.setText(list.get(0).getPlanType());

                    binding.accountId2.setText(list.get(0).getAccountId());
                    binding.oDate2.setText(list.get(0).getAccountOpenDate());
                    binding.mAmmount2.setText(list.get(0).getMIPAmount());
                    binding.maturatityAmmount2.setText(list.get(0).getMaturityAmount());
                    binding.pAmmount2.setText(list.get(0).getPlanAmount());
                    binding.pNo2.setText(list.get(0).getPlanNo());
                    binding.pType2.setText(list.get(0).getPlanType());

                }else {
                    Toast.makeText(PlanList.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PlanList.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<MemberFDPlanListResponse> call, Throwable t) {
                Toast.makeText(PlanList.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}