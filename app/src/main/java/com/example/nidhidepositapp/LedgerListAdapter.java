package com.example.nidhidepositapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nidhidepositapp.Response.MemberSavingLedger;

import java.util.List;

public class LedgerListAdapter extends RecyclerView.Adapter<LedgerListAdapter.ViewHolder> {


    private List<MemberSavingLedger> memberSavingLedgerList; // Replace String with your data model
    Context context;

    public LedgerListAdapter(List<MemberSavingLedger> memberSavingLedgerList, Context context) {
        this.memberSavingLedgerList = memberSavingLedgerList;
        this.context = context;
    }

    public LedgerListAdapter(List<MemberSavingLedger> memberSavingLedgerList) {
        this.memberSavingLedgerList = memberSavingLedgerList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ledger_list_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MemberSavingLedger memberSavingLedger= memberSavingLedgerList.get(position);
        holder.TransId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent =  new Intent(context,LedgerDetail.class);
            intent.putExtra("TransId",memberSavingLedger.getTransId());
            context.startActivity(intent);
            }
        });

        holder.Deposit.setText(""+memberSavingLedger.getDeposit());
        holder.TransDate.setText(""+memberSavingLedger.getTransDate());
        holder.TransId.setText(""+memberSavingLedger.getTransId());
        holder.Withdrawl.setText(""+memberSavingLedger.getWithdrawl());
    }
    @Override
    public int getItemCount() {return memberSavingLedgerList.size();}
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Deposit ,TransDate,TransId ,Withdrawl ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //textView = itemView.findViewById(R.id.text_view);
            Deposit = itemView.findViewById(R.id.Deposit);
            TransDate = itemView.findViewById(R.id.TransDate);
            TransId = itemView.findViewById(R.id.TransId);
            Withdrawl = itemView.findViewById(R.id.Withdrawl);

        }
    }
}
