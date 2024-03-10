package com.example.nidhidepositapp.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberFDPlan {
    @SerializedName("AccountId")
    @Expose
    private String accountId;
    @SerializedName("AccountOpenDate")
    @Expose
    private String accountOpenDate;
    @SerializedName("MIPAmount")
    @Expose
    private String mIPAmount;
    @SerializedName("MaturityAmount")
    @Expose
    private String maturityAmount;
    @SerializedName("PlanAmount")
    @Expose
    private String planAmount;
    @SerializedName("PlanNo")
    @Expose
    private String planNo;
    @SerializedName("PlanType")
    @Expose
    private String planType;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountOpenDate() {
        return accountOpenDate;
    }

    public void setAccountOpenDate(String accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }

    public String getMIPAmount() {
        return mIPAmount;
    }

    public void setMIPAmount(String mIPAmount) {
        this.mIPAmount = mIPAmount;
    }

    public String getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(String maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public String getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(String planAmount) {
        this.planAmount = planAmount;
    }

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo;
    }

    public String getPlanType() {
        return planType;
    }
    public void setPlanType(String planType) {
        this.planType = planType;
    }
}
