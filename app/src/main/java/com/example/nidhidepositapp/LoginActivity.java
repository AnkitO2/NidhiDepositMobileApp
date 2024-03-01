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
    String memberId ="",password ="";
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

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("memberId",binding.usernameInputEditText.getText().toString());
        editor.putString("password",binding.passwordInputEditText.getText().toString());
        editor.apply();

//        SharedPreferences.Editor editor = sharedpreferences.edit();
//        editor.putString("userId",binding.usernameInputEditText.getText().toString());
//        editor.putString("password",binding.passwordInputEditText.getText().toString());
//        editor.apply();

        RetrofitClient.getClient().LoginIdAndPassword(request).enqueue(new Callback<MemberLoginWithIDAndPasswordResponse>() {
            @Override
            public void onResponse(Call<MemberLoginWithIDAndPasswordResponse> call, Response<MemberLoginWithIDAndPasswordResponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getLoginMessage().equalsIgnoreCase("Member Login Successfull")){
                        SharedPreferences.Editor editor =sharedPreferences.edit();
                        editor.putString("loginStatus",response.body().getLoginMessage());
                        editor.apply();

                        Intent intent =  new Intent(LoginActivity.this,MemberDashboard.class);
                       // intent.putExtra("Year",""+response.body().getMemberLoginWithIDAndPassword().getFinYear());
                        intent.putExtra("MemberID",""+response.body().getMemberLoginWithIDAndPassword().getMemberId());
                        intent.putExtra("MemberID",""+binding.usernameInputEditText.getText().toString());
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