package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class MemberLoginWithIDAndPassword implements Serializable
{
    @SerializedName("MemberId")
    @Expose
    private String memberId;
    @SerializedName("TokenString")
    @Expose
    private String tokenString;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

}