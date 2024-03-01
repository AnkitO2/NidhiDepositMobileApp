package com.example.nidhidepositapp.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberHomePageAndDashboardRequest {
    @SerializedName("MemberId")
    @Expose
    private String memberId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
