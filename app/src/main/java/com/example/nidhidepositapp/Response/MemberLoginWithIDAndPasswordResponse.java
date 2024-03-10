package com.example.nidhidepositapp.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberLoginWithIDAndPasswordResponse {
    @SerializedName("LoginMessage")
    @Expose
    private String loginMessage;
    @SerializedName("MemberLoginWithIDAndPassword")
    @Expose
    private MemberLoginWithIDAndPassword memberLoginWithIDAndPassword;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private boolean status;

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public MemberLoginWithIDAndPassword getMemberLoginWithIDAndPassword() {
        return memberLoginWithIDAndPassword;
    }

    public void setMemberLoginWithIDAndPassword(MemberLoginWithIDAndPassword memberLoginWithIDAndPassword) {
        this.memberLoginWithIDAndPassword = memberLoginWithIDAndPassword;
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
