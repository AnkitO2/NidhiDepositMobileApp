package com.example.nidhidepositapp.Request;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberSavingLedgerDetailRequest {
    @SerializedName("MemberId")
    @Expose
    private String memberId;
    @SerializedName("TransId")
    @Expose
    private String transId;
    @SerializedName("TokenString")
    @Expose
    private String tokenString;
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }
}
