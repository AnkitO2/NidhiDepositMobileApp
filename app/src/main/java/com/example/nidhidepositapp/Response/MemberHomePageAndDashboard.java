package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberHomePageAndDashboard {
    @SerializedName("AdvisorBalance")
    @Expose
    private String advisorBalance;
    @SerializedName("AdvisorId")
    @Expose
    private String advisorId;
    @SerializedName("AdvisorRank")
    @Expose
    private String advisorRank;
    @SerializedName("MemberBalance")
    @Expose
    private String memberBalance;
    @SerializedName("MemberId")
    @Expose
    private String memberId;
    @SerializedName("MemberName")
    @Expose
    private String memberName;
    @SerializedName("SavingBalance")
    @Expose
    private String savingBalance;
    @SerializedName("SavingId")
    @Expose
    private String savingId;
    @SerializedName("TotalBalance")
    @Expose
    private String totalBalance;


    public String getAdvisorBalance() {
        return advisorBalance;
    }

    public void setAdvisorBalance(String advisorBalance) {
        this.advisorBalance = advisorBalance;
    }

    public String getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId;
    }

    public String getAdvisorRank() {
        return advisorRank;
    }

    public void setAdvisorRank(String advisorRank) {
        this.advisorRank = advisorRank;
    }

    public String getMemberBalance() {
        return memberBalance;
    }

    public void setMemberBalance(String memberBalance) {
        this.memberBalance = memberBalance;
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

    public String getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(String savingBalance) {
        this.savingBalance = savingBalance;
    }

    public String getSavingId() {
        return savingId;
    }

    public void setSavingId(String savingId) {
        this.savingId = savingId;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }
}
