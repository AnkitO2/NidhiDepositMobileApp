package com.example.nidhidepositapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.nidhidepositapp.databinding.MemberDashboardBinding;
import com.google.android.material.navigation.NavigationView;

public class MemberDashboard extends AppCompatActivity {
 private MemberDashboardBinding binding;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MemberDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });
       // memberDashboard();
  binding.memberId.setText(sharedPreferences.getString("memberId",""));
  binding.tokenId.setText(sharedPreferences.getString("token",""));
        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1) {
                    Intent intent = new Intent(MemberDashboard.this,HomeActivity.class);
                    intent.putExtra("memberId",""+sharedPreferences.getString("memberId",""));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                }
                 else if (itemId == R.id.Loan2) {
                    Intent intent = new Intent(MemberDashboard.this,PlanList.class);
                    intent.putExtra("memberId",""+sharedPreferences.getString("memberId",""));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId ==R.id.Loan3) {
                    Intent intent = new Intent(MemberDashboard.this,PlanDetail.class);
                    intent.putExtra("memberId",""+sharedPreferences.getString("memberId",""));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent =new Intent(MemberDashboard.this,LedgerList.class);
                    intent.putExtra("memberId",""+sharedPreferences.getString("memberId",""));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan5) {
                    Intent intent = new Intent(MemberDashboard.this,LedgerDetail.class);
                    intent.putExtra("memberId",""+sharedPreferences.getString("memberId",""));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan6) {
                    Intent intent = new Intent(MemberDashboard.this,Member_R_List.class);
                    intent.putExtra("memberId",""+sharedPreferences.getString("memberId",""));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId == R.id.Loan7) {
                    Intent intent = new Intent(MemberDashboard.this,Member_R_Detail.class);
                    intent.putExtra("memberId",""+sharedPreferences.getString("memberId",""));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId == R.id.Loan8) {
                    Intent intent = new Intent(MemberDashboard.this,LoginActivity.class);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("loginStatus", "");
                    editor.apply();
                    startActivity(intent);
                }
                return true; // Return true to indicate that the item click is handled
            }
        });
    }
//    void memberDashboard(){
//        MemberLoginWithIDAndPasswordRequest request = new MemberLoginWithIDAndPasswordRequest();
//
//        //request.setMemberId(sharedPreferences.getString("memberId","")));
//
//        request.setMemberId(sharedPreferences.getString("memberId",""));
//        RetrofitClient.getClient().LoginIdAndPassword(request).enqueue(new Callback<MemberLoginWithIDAndPasswordResponse>() {
//            @Override
//            public void onResponse(Call<MemberLoginWithIDAndPasswordResponse> call, Response<MemberLoginWithIDAndPasswordResponse> response) {
//                if (response.isSuccessful()){
//
//                   // Toast.makeText(MemberDashboard.this, "Login Succesfuly", Toast.LENGTH_SHORT).show();
//
//                }else {
//                   // Toast.makeText(MemberDashboard.this, "Response Not Succesfuly", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<MemberLoginWithIDAndPasswordResponse> call, Throwable t) {
//               // Toast.makeText(MemberDashboard.this, "Something Went Grong", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}