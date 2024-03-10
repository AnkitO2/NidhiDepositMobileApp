package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MemberRDPlanListResponse {
    @SerializedName("MemberRDPlanList")
    @Expose
    private List<MemberRDPlan> memberRDPlanList;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;


    public List<MemberRDPlan> getMemberRDPlanList() {
        return memberRDPlanList;
    }

    public void setMemberRDPlanList(List<MemberRDPlan> memberRDPlanList) {
        this.memberRDPlanList = memberRDPlanList;
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
