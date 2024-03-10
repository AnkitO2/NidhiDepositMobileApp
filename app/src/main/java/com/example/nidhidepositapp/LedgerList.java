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

import com.example.nidhidepositapp.Request.MemberSavingLedgerListRequest;
import com.example.nidhidepositapp.Response.MemberSavingLedger;
import com.example.nidhidepositapp.Response.MemberSavingLedgerListResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.ListLedgerBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LedgerList extends AppCompatActivity {
private ListLedgerBinding binding;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
      binding =ListLedgerBinding.inflate(getLayoutInflater());
        SavingLedgerData();
        setContentView(binding.getRoot());
        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });
        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1){
                    Intent intent = new Intent(LedgerList.this,MainActivity.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan2) {
                    Intent intent = new Intent(LedgerList.this,HomeActivity.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(LedgerList.this,PlanList.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent =new Intent(LedgerList.this,PlanDetail.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId==R.id.Loan5) {
                    Intent intent = new Intent(LedgerList.this,MemberDashboard.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId ==R.id.Loan6) {
                    Intent intent = new Intent(LedgerList.this,LedgerDetail.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                } else if (itemId == R.id.Loan9) {
                    Intent intent = new Intent(LedgerList.this,LoginActivity.class);
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
    void SavingLedgerData(){
        MemberSavingLedgerListRequest request = new MemberSavingLedgerListRequest();
        request.setMemberId(getIntent().getStringExtra("MemberID"));
        request.setTokenString(getIntent().getStringExtra("token"));
        request.setFromDate("null");
        request.setToDate("null");
        RetrofitClient.getClient().LedgerListActivity(request).enqueue(new Callback<MemberSavingLedgerListResponse>() {
            @Override
            public void onResponse(Call<MemberSavingLedgerListResponse> call, Response<MemberSavingLedgerListResponse> response) {
                if (response.isSuccessful()){
                    Log.d("Response", "Body: " + response.body().toString());
                    List<MemberSavingLedger>list = response.body().getMemberSavingLedgerList();
                    binding.homeData1.setText(response.body().getMessage());
//                    binding.homeData2.setText(list.get(0).getDeposit());
//                    binding.homeData3.setText(list.get(0).getTransId());
//                    //binding.homeData4.setText(list.get(0).getTransactionDate());
//                    binding.homeData5.setText(list.get(0).getWithdrawl());
                }else {
                    Toast.makeText(LedgerList.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MemberSavingLedgerListResponse> call, Throwable t) {
                Toast.makeText(LedgerList.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}