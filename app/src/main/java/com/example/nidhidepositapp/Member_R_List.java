package com.example.nidhidepositapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.nidhidepositapp.Request.MemberRDPlanListRequest;
import com.example.nidhidepositapp.Response.MemberRDPlan;
import com.example.nidhidepositapp.Response.MemberRDPlanListResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.ListRMemberBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Member_R_List extends AppCompatActivity {
private ListRMemberBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ListRMemberBinding.inflate(getLayoutInflater());
        RDPlanListData();
        setContentView(binding.getRoot());

        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });
    }
    void RDPlanListData(){
        MemberRDPlanListRequest request =new MemberRDPlanListRequest();
        request.setMemberId(getIntent().getStringExtra("MemberID"));
        request.setTokenString(getIntent().getStringExtra("token"));

        RetrofitClient.getClient().RDPlanListActivity(request).enqueue(new Callback<MemberRDPlanListResponse>() {
            @Override
            public void onResponse(Call<MemberRDPlanListResponse> call, Response<MemberRDPlanListResponse> response) {
            if(response.isSuccessful()){
                Log.d("Response", "Body: " + response.body().toString());

                List<MemberRDPlan>list = response.body().getMemberRDPlanList();

                binding.accountId1.setText(list.get(0).getAccountId());
                binding.oDate1.setText(list.get(0).getAccountOpenDate());
                binding.pAmmount1.setText(list.get(0).getPlanAmount());
                binding.pMode1.setText(list.get(0).getPlanMode());
                binding.pNo1.setText(list.get(0).getPlanNo());
                binding.pType1.setText(list.get(0).getPlanType());
            }
            else {
                Toast.makeText(Member_R_List.this, "response is not successfully", Toast.LENGTH_SHORT).show();
            }
            }
            @Override
            public void onFailure(Call<MemberRDPlanListResponse> call, Throwable t) {
                Toast.makeText(Member_R_List.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}