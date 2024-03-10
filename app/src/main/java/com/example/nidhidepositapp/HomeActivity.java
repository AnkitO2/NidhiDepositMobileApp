package com.example.nidhidepositapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.nidhidepositapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
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
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(HomeActivity.this,PlanList.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent = new Intent(HomeActivity.this,PlanDetail.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan5) {
                    Intent intent = new Intent(HomeActivity.this,LedgerList.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan6) {
                    Intent intent = new Intent(HomeActivity.this,LedgerDetail.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan9) {
                    Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("loginStatus", "");
                    startActivity(intent);
                }
                return true; // Return true to indicate that the item click is handled
            }
        });
    }
    void homeDashboardData(){
        MemberHomePageAndDashboardRequest request = new MemberHomePageAndDashboardRequest();
        request.setMemberId(getIntent().getStringExtra("MemberID"));
        request.setTokenString(getIntent().getStringExtra("token"));

        RetrofitClient.getClient().ClientDashboard(request).enqueue(new Callback<MemberHomePageAndDashboardResponse>() {
            @Override
            public void onResponse(Call<MemberHomePageAndDashboardResponse> call, Response<MemberHomePageAndDashboardResponse> response) {
                if(response.isSuccessful()){
                    Log.d("Response", "Body: " + response.body().toString());
                    binding.homeData1.setText(response.body().getMessage());

  //                  binding.homeData2.setText(response.body().getMemberHomePageAndDashboard().getAdvisorBalance());
//                    binding.homeData3.setText(response.body().getMemberHomePageAndDashboard().getAdvisorId());
//                    binding.homeData4.setText(response.body().getMemberHomePageAndDashboard().getAdvisorRank());
//                    binding.homeData5.setText(response.body().getMemberHomePageAndDashboard().getMemberBalance());
//                    binding.homeData6.setText(response.body().getMemberHomePageAndDashboard().getMemberId());
//                    binding.homeData7.setText("Member Name :"+response.body().getMemberHomePageAndDashboard().getMemberName());
//                    binding.homeData8.setText(response.body().getMemberHomePageAndDashboard().getSavingBalance());
//                    binding.homeData9.setText(response.body().getMemberHomePageAndDashboard().getSavingId());
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