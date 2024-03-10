package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberSavingLedgerDetailResponse {
    @SerializedName("MemberSavingLedgerDetail")
    @Expose
    private MemberSavingLedgerDetail memberSavingLedgerDetail;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;


    public MemberSavingLedgerDetail getMemberSavingLedgerDetail() {
        return memberSavingLedgerDetail;
    }

    public void setMemberSavingLedgerDetail(MemberSavingLedgerDetail memberSavingLedgerDetail) {
        this.memberSavingLedgerDetail = memberSavingLedgerDetail;
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
