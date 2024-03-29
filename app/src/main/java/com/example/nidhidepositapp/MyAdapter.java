package com.example.nidhidepositapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nidhidepositapp.Response.MemberFDPlan;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<MemberFDPlan> memberFDPlanList; // Replace String with your data model


    public MyAdapter(List<MemberFDPlan> data) {
        this.memberFDPlanList = memberFDPlanList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MemberFDPlan memberFDPlan= memberFDPlanList.get(position);
        holder.data1.setText(memberFDPlan.getAccountId());
        holder.data2.setText(memberFDPlan.getAccountOpenDate());
        holder.data3.setText(memberFDPlan.getMIPAmount());
        holder.data4.setText(memberFDPlan.getMaturityAmount());
        holder.data5.setText(memberFDPlan.getPlanAmount());

//        holder.textView.setText("Plan No: " + memberFDPlan.getPlanNo() + "\n" +
//                "Plan Amount: " + memberFDPlan.getPlanAmount() + "\n" +
//                "Plan Type: " + memberFDPlan.getPlanType() + "\n" +
//                "Account ID: " + memberFDPlan.getAccountId() + "\n" +
//                "Class: " + memberFDPlan.getClass());

    }
    @Override
    public int getItemCount() {
        return memberFDPlanList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView data1 ,data2,data3 ,data4 ,data5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            data1 = itemView.findViewById(R.id.accountId1);
            data2 = itemView.findViewById(R.id.openDate1);
            data3 = itemView.findViewById(R.id.mipAmmount1);
            data4 = itemView.findViewById(R.id.maturatityAmmount1);
            data5 = itemView.findViewById(R.id.planNo1);
        }
    }
}

