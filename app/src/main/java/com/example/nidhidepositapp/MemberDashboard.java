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

import com.example.nidhidepositapp.Request.MemberLoginWithIDAndPasswordRequest;
import com.example.nidhidepositapp.Response.MemberLoginWithIDAndPasswordResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.MemberDashboardBinding;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberDashboard extends AppCompatActivity {
 private MemberDashboardBinding binding;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MemberDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        memberDashboard();
        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });

  binding.MemberID.setText("Member Id  :"+getIntent().getStringExtra("MemberID"));

        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1) {
                    Intent intent = new Intent(MemberDashboard.this,MainActivity.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                }
                 else if (itemId == R.id.Loan2) {
                    Intent intent = new Intent(MemberDashboard.this,HomeActivity.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(MemberDashboard.this,LoginActivity.class);
                    startActivity(intent);
                }
                return true; // Return true to indicate that the item click is handled
            }
        });
    }
    void memberDashboard(){
        MemberLoginWithIDAndPasswordRequest request = new MemberLoginWithIDAndPasswordRequest();
        request.setMemberId(getIntent().getStringExtra("MemberID"));

//        if (sharedPreferences.getString("MemberID","").isEmpty()){
//            request.setMemberId("MemberID"+getIntent().getStringExtra("MemberID"));
//        }else {
//            request.setMemberId("MemberID"+sharedPreferences.getString("memberId","M101000002"));
//        }

        RetrofitClient.getClient().LoginIdAndPassword(request).enqueue(new Callback<MemberLoginWithIDAndPasswordResponse>() {
            @Override
            public void onResponse(Call<MemberLoginWithIDAndPasswordResponse> call, Response<MemberLoginWithIDAndPasswordResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MemberDashboard.this, "Login Succesfuly", Toast.LENGTH_SHORT).show();
                    binding.MemberID.setText(response.body().getMemberLoginWithIDAndPassword().getMemberId());
                }else {
                    Toast.makeText(MemberDashboard.this, "Response Not Succesfuly", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MemberLoginWithIDAndPasswordResponse> call, Throwable t) {
                Toast.makeText(MemberDashboard.this, "Something Went Grong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}