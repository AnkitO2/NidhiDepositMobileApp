package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberSavingLedger {
    @SerializedName("Deposit")
    @Expose
    private String deposit;
    @SerializedName("TransDate")
    @Expose
    private String transDate;
    @SerializedName("TransId")
    @Expose
    private String transId;
    @SerializedName("Withdrawl")
    @Expose
    private String withdrawl;

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getWithdrawl() {
        return withdrawl;
    }

    public void setWithdrawl(String withdrawl) {
        this.withdrawl = withdrawl;
    }
}
