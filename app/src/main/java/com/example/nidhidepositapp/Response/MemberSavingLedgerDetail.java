package com.example.nidhidepositapp.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberSavingLedgerDetail {
    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("Deposit")
    @Expose
    private String deposit;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("EntryType")
    @Expose
    private String entryType;
    @SerializedName("MemberId")
    @Expose
    private String memberId;
    @SerializedName("MemberName")
    @Expose
    private String memberName;
    @SerializedName("SavingId")
    @Expose
    private String savingId;
    @SerializedName("TransId")
    @Expose
    private String transId;
    @SerializedName("TransactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("VoucherId")
    @Expose
    private String voucherId;
    @SerializedName("Withdrawl")
    @Expose
    private String withdrawl;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSavingId() {
        return savingId;
    }

    public void setSavingId(String savingId) {
        this.savingId = savingId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public String getWithdrawl() {
        return withdrawl;
    }

    public void setWithdrawl(String withdrawl) {
        this.withdrawl = withdrawl;
    }
}
