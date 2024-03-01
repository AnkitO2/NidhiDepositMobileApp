package com.example.nidhidepositapp.Retrofit;
import com.example.nidhidepositapp.Request.MemberHomePageAndDashboardRequest;
import com.example.nidhidepositapp.Request.MemberLoginWithIDAndPasswordRequest;
import com.example.nidhidepositapp.Response.MemberHomePageAndDashboardResponse;
import com.example.nidhidepositapp.Response.MemberLoginWithIDAndPasswordResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {

@POST("Service/MemberLoginWithIDAndPassword")
Call<MemberLoginWithIDAndPasswordResponse>LoginIdAndPassword(
        @Body MemberLoginWithIDAndPasswordRequest memberLoginWithIDAndPasswordRequest
);

@POST("Service/MemberHomePageAndDashboard")
Call<MemberHomePageAndDashboardResponse>ClientDashboard(
        @Body MemberHomePageAndDashboardRequest memberHomePageAndDashboardRequest
);
//
//@POST("Service/MemberLoanCardPrinting")
//    Call<MemberLoanCardPrintingResponse>ClientPrinting(
//            @Body MemberLoanCardPrintingRequest memberLoanCardPrintingRequest
//              );
//@POST("Service/MemberLoanFullReport")
//    Call<MemberLoanFullReportResponse>ClientReport(
//            @Body MemberLoanFullReportRequest memberLoanFullReportRequest
//              );
}
