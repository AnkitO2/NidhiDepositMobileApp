package com.example.nidhidepositapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.nidhidepositapp.Request.MemberLoginWithIDAndPasswordRequest;
import com.example.nidhidepositapp.Response.MemberLoginWithIDAndPasswordResponse;
import com.example.nidhidepositapp.Retrofit.RetrofitClient;
import com.example.nidhidepositapp.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    SharedPreferences sharedPreferences;
    String memberId ="",password ="" ,token="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences =getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        binding.loginBtn.setOnClickListener( v -> {
            if (binding.usernameInputEditText.getText().toString().isEmpty()){
                Toast.makeText(this, "Please enter User Id", Toast.LENGTH_SHORT).show();
            } else if (binding.passwordInputEditText.getText().toString().isEmpty()) {
                Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            }
            else {
                userLogin();
            }
        });
    }
    void userLogin(){
        MemberLoginWithIDAndPasswordRequest request = new MemberLoginWithIDAndPasswordRequest();
        request.setMemberId(binding.usernameInputEditText.getText().toString());
        request.setPassword(binding.passwordInputEditText.getText().toString());



        RetrofitClient.getClient().LoginIdAndPassword(request).enqueue(new Callback<MemberLoginWithIDAndPasswordResponse>() {
            @Override
            public void onResponse(Call<MemberLoginWithIDAndPasswordResponse> call, Response<MemberLoginWithIDAndPasswordResponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getLoginMessage().equalsIgnoreCase("Member Login Successfull")){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("loginStatus", response.body().getLoginMessage());
                        editor.apply();

                        SharedPreferences.Editor  memberId= sharedPreferences.edit(); // Corrected variable name
                        memberId.putString("memberId", response.body().getMemberLoginWithIDAndPassword().getMemberId());
                        memberId.apply(); // Corrected variable name

                        //advisor token as a variable (token) leke gaye
                        SharedPreferences.Editor token = sharedPreferences.edit();
                        token.putString("token", response.body().getMemberLoginWithIDAndPassword().getTokenString());
                        token.apply();

                        Toast.makeText(LoginActivity.this, ""+response.body().getMemberLoginWithIDAndPassword().getMemberId(), Toast.LENGTH_SHORT).show();
                        Intent intent =  new Intent(LoginActivity.this,MemberDashboard.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this,"response is not successfully"+response.body().getLoginMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<MemberLoginWithIDAndPasswordResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}