package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MemberFDPlanListResponse {
    @SerializedName("MemberFDPlanList")
    @Expose
    private List<MemberFDPlan> memberFDPlanList;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;

    public List<MemberFDPlan> getMemberFDPlanList() {
        return memberFDPlanList;
    }

    public void setMemberFDPlanList(List<MemberFDPlan> memberFDPlanList) {
        this.memberFDPlanList = memberFDPlanList;
    }
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
}
