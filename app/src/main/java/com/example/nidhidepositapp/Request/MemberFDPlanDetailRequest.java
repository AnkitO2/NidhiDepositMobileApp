package com.example.nidhidepositapp.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberFDPlanDetailRequest {
    @SerializedName("MemberId")
    @Expose
    private String memberId;
    @SerializedName("AccountId")
    @Expose
    private String accountId;
    @SerializedName("TokenString")
    @Expose
    private String tokenString;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }
}
