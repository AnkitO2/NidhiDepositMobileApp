package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberHomePageAndDashboardResponse {

    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;
    @SerializedName("MemberHomePageAndDashboard")
    @Expose
    private MemberHomePageAndDashboard memberHomePageAndDashboard;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public MemberHomePageAndDashboard getMemberHomePageAndDashboard() {
        return memberHomePageAndDashboard;
    }

    public void setMemberHomePageAndDashboard(MemberHomePageAndDashboard memberHomePageAndDashboard) {
        this.memberHomePageAndDashboard = memberHomePageAndDashboard;
    }

}
