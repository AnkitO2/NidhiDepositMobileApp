package com.example.nidhidepositapp.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberLoginWithIDAndPasswordRequest {
    @SerializedName("MemberId")
    @Expose
    private String memberId;
    @SerializedName("Password")
    @Expose
    private String password;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
