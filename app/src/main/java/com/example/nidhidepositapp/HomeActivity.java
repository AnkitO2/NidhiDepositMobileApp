package com.example.nidhidepositapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import com.example.nidhidepositapp.Request.MemberHomePageAndDashboardRequest;
import com.example.nidhidepositapp.Response.MemberHomePageAndDashboardResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.ActivityHomeBinding;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
private ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        homeDashboardData();
        setContentView(binding.getRoot());
        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });
        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1){
                    Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId ==R.id.Loan2) {
                    Intent intent = new Intent(HomeActivity.this , MemberDashboard.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                }

                return true; // Return true to indicate that the item click is handled
            }
        });
    }
    void homeDashboardData(){
        MemberHomePageAndDashboardRequest memberHomePageAndDashboardRequest = new MemberHomePageAndDashboardRequest();
        memberHomePageAndDashboardRequest.setMemberId(getIntent().getStringExtra("MemberID"));

        RetrofitClient.getClient().ClientDashboard(memberHomePageAndDashboardRequest).enqueue(new Callback<MemberHomePageAndDashboardResponse>() {
            @Override
            public void onResponse(Call<MemberHomePageAndDashboardResponse> call, Response<MemberHomePageAndDashboardResponse> response) {
                if(response.isSuccessful()){
                    Log.d("Response", "Body: " + response.body().toString());
                    binding.homeData1.setText(response.body().getMessage());
                    binding.homeData2.setText("Advisor Balance :"+response.body().getMemberHomePageAndDashboard().getAdvisorBalance());
                    binding.homeData3.setText("Advisor Id :"+response.body().getMemberHomePageAndDashboard().getAdvisorId());
                    binding.homeData4.setText("Advisor Rank :"+response.body().getMemberHomePageAndDashboard().getAdvisorRank());
                    binding.homeData5.setText("Member Balance :"+response.body().getMemberHomePageAndDashboard().getMemberBalance());
                    binding.homeData6.setText("Member Id :"+response.body().getMemberHomePageAndDashboard().getMemberId());
                    binding.homeData7.setText("Member Name :"+response.body().getMemberHomePageAndDashboard().getMemberName());
                    binding.homeData8.setText("Saving Balance :"+response.body().getMemberHomePageAndDashboard().getSavingBalance());
                    binding.homeData9.setText("SavingId :"+response.body().getMemberHomePageAndDashboard().getSavingId());

                } else  {
                    Toast.makeText(HomeActivity.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MemberHomePageAndDashboardResponse> call, Throwable t) {
                Toast.makeText(HomeActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}