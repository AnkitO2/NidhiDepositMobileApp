package com.example.nidhidepositapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nidhidepositapp.Response.MemberRDPlan;

import java.util.List;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.ViewHolder> {


    private List<MemberRDPlan> memberRDPlanList; // Replace String with your data model
    Context context;

    public MemberListAdapter(List<MemberRDPlan> memberRDPlanList, Context context) {
        this.memberRDPlanList = memberRDPlanList;
        this.context = context;
    }

    public MemberListAdapter(List<MemberRDPlan> memberRDPlanList) {
        this.memberRDPlanList = memberRDPlanList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_member, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MemberRDPlan memberRDPlan= memberRDPlanList.get(position);
        holder.accountId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(context,Member_R_Detail.class);
                intent.putExtra("AccountId",memberRDPlan.getAccountId());
                context.startActivity(intent);
            }
        });

        holder.accountId.setText(""+ memberRDPlan.getAccountId());
        holder.oDate.setText(""+memberRDPlan.getAccountOpenDate());
        holder.pAmmount.setText(""+memberRDPlan.getPlanAmount());
        holder.pMode.setText(""+memberRDPlan.getPlanMode());
        holder.pNo.setText(""+memberRDPlan.getPlanNo());
        holder.pType.setText(""+memberRDPlan.getPlanType());
    }
    @Override
    public int getItemCount() {return memberRDPlanList.size();}
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView accountId,oDate,pAmmount ,pMode ,pNo,pType;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //textView = itemView.findViewById(R.id.text_view);
            accountId = itemView.findViewById(R.id.accountId);
            oDate = itemView.findViewById(R.id.oDate);
            pAmmount = itemView.findViewById(R.id.pAmmount);
            pMode = itemView.findViewById(R.id.pMode);
            pNo = itemView.findViewById(R.id.pNo);
            pType = itemView.findViewById(R.id.pType);

        }
    }
}
