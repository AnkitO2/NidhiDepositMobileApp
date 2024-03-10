package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberRDPlanDetailResponse {
    @SerializedName("MemberRDPlanDetail")
    @Expose
    private MemberRDPlanDetail memberRDPlanDetail;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;

    public MemberRDPlanDetail getMemberRDPlanDetail() {
        return memberRDPlanDetail;
    }

    public void setMemberRDPlanDetail(MemberRDPlanDetail memberRDPlanDetail) {
        this.memberRDPlanDetail = memberRDPlanDetail;
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
