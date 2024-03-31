package com.example.nidhidepositapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nidhidepositapp.Response.MemberFDPlan;

import java.util.List;


public class PlanFdListAdapter extends RecyclerView.Adapter<PlanFdListAdapter.ViewHolder> {
static SharedPreferences sharedPreferences;

    private List<MemberFDPlan> memberFDPlanList; // Replace String with your data model
    Context context;

    public PlanFdListAdapter(List<MemberFDPlan> memberFDPlanList, Context context) {
        this.memberFDPlanList = memberFDPlanList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itremlist, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MemberFDPlan memberFDPlan= memberFDPlanList.get(position);
     holder.data1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(context,PlanDetail.class);
             intent.putExtra("AccountId",memberFDPlan.getAccountId());
             context.startActivity(intent);
         }
     });

        holder.data1.setText(""+memberFDPlan.getAccountId());
        holder.data2.setText(""+memberFDPlan.getAccountOpenDate());
        holder.data3.setText(""+memberFDPlan.getMIPAmount());
       // holder.data4.setText(""+memberFDPlan.getMaturityAmount());
        //holder.data5.setText(""+memberFDPlan.getPlanAmount());
        holder.data6.setText(""+memberFDPlan.getPlanNo());
        holder.data7.setText(""+memberFDPlan.getPlanType());
    }
    @Override
    public int getItemCount() {
        return memberFDPlanList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView data1 ,data2,data3 ,data4 ,data5,data6,data7;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //textView = itemView.findViewById(R.id.text_view);
            data1 = itemView.findViewById(R.id.accountId1);
            data2 = itemView.findViewById(R.id.openDate1);
            data3 = itemView.findViewById(R.id.mipAmmount1);
            data4 = itemView.findViewById(R.id.maturatityAmmount1);
            data5 = itemView.findViewById(R.id.pAmmount1);
            data6 = itemView.findViewById(R.id.planNo1);
            data7 = itemView.findViewById(R.id.planType1);
        }
    }

}

