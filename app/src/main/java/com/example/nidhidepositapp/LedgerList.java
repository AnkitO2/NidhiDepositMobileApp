package com.example.nidhidepositapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
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
        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
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
                    Intent intent = new Intent(LedgerList.this,HomeActivity.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan2) {
                    Intent intent = new Intent(LedgerList.this,PlanList.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan3) {
                    Intent intent = new Intent(LedgerList.this,MemberDashboard.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    intent.putExtra("AccountId",""+sharedPreferences.getString("AccountId",""));
                    startActivity(intent);
                } else if (itemId==R.id.Loan4) {
                    Intent intent =new Intent(LedgerList.this,Member_R_List.class);
                    intent.putExtra("memberId",""+getIntent().getStringExtra("memberId"));
                    intent.putExtra("token",""+sharedPreferences.getString("token",""));
                    startActivity(intent);
                }
                 else if (itemId == R.id.Loan5) {
                    Intent intent = new Intent(LedgerList.this,LoginActivity.class);
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
        request.setMemberId(getIntent().getStringExtra("memberId"));
        request.setTokenString(getIntent().getStringExtra("token"));
        request.setFromDate("null");
        request.setToDate("null");

        RetrofitClient.getClient().LedgerListActivity(request).enqueue(new Callback<MemberSavingLedgerListResponse>() {
            @Override
            public void onResponse(Call<MemberSavingLedgerListResponse> call, Response<MemberSavingLedgerListResponse> response) {
                if (response.body().getMessage().equalsIgnoreCase("Successful")){
                    Log.d("Response", "Body: " + response.body().toString());

                    List<MemberSavingLedger>list = response.body().getMemberSavingLedgerList();

                    if (list.size()>0){
                        binding.recyclerview.setLayoutManager(new LinearLayoutManager(LedgerList.this, RecyclerView.VERTICAL,false));
                        binding.recyclerview.setAdapter(new LedgerListAdapter(list));
                    }

                }else {
                    Toast.makeText(LedgerList.this, "response is not successfully", Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(LedgerList.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<MemberSavingLedgerListResponse> call, Throwable t) {
                Toast.makeText(LedgerList.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}