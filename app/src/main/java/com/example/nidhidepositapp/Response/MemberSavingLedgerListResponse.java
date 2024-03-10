package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MemberSavingLedgerListResponse {
    @SerializedName("MemberSavingLedgerList")
    @Expose
    private List<MemberSavingLedger> memberSavingLedgerList;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;


    public List<MemberSavingLedger> getMemberSavingLedgerList() {
        return memberSavingLedgerList;
    }

    public void setMemberSavingLedgerList(List<MemberSavingLedger> memberSavingLedgerList) {
        this.memberSavingLedgerList = memberSavingLedgerList;
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
