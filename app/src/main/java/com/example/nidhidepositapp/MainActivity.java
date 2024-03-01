package com.example.nidhidepositapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.nidhidepositapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.year.setText("Student Year :"+getIntent().getStringExtra("Year"));
        binding.memberId.setText("Member Id  :"+getIntent().getStringExtra("MemberID"));

        binding.menuIcon.setOnClickListener(v -> {
            binding.drawerLayout1.openDrawer(GravityCompat.START);
        });
        binding.navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.Loan1){
                    Intent intent = new Intent(MainActivity.this,MemberDashboard.class);
                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
                    startActivity(intent);
                }
//                 else if (itemId ==R.id.Loan2) {
//                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
//                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
//                    startActivity(intent);
//                } else if (itemId ==R.id.Loan3) {
//                    Intent intent = new Intent(MainActivity.this,PrintingActivity.class);
//                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
//                    startActivity(intent);
//                } else if (itemId==R.id.Loan4) {
//                    Intent intent = new Intent(MainActivity.this,ReportActivity.class);
//                    intent.putExtra("MemberID",""+getIntent().getStringExtra("MemberID"));
//                    startActivity(intent);
//                } else if (itemId ==R.id.Loan5) {
//                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//                    startActivity(intent);
//                }
                return true; // Return true to indicate that the item click is handled
            }
        });
    }
}