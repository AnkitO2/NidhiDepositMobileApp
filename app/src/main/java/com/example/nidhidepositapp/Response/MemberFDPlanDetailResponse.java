package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberFDPlanDetailResponse {
    @SerializedName("MemberFDPlanDetail")
    @Expose
    private MemberFDPlanDetail memberFDPlanDetail;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;

    public MemberFDPlanDetail getMemberFDPlanDetail() {
        return memberFDPlanDetail;
    }

    public void setMemberFDPlanDetail(MemberFDPlanDetail memberFDPlanDetail) {
        this.memberFDPlanDetail = memberFDPlanDetail;
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
