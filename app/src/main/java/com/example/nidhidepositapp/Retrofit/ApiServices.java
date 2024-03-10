package com.example.nidhidepositapp.Retrofit;
import com.example.nidhidepositapp.Request.MemberFDPlanDetailRequest;
import com.example.nidhidepositapp.Request.MemberFDPlanListRequest;
import com.example.nidhidepositapp.Request.MemberHomePageAndDashboardRequest;
import com.example.nidhidepositapp.Request.MemberLoginWithIDAndPasswordRequest;
import com.example.nidhidepositapp.Request.MemberRDPlanListRequest;
import com.example.nidhidepositapp.Request.MemberSavingLedgerDetailRequest;
import com.example.nidhidepositapp.Request.MemberSavingLedgerListRequest;
import com.example.nidhidepositapp.Response.MemberFDPlanDetailResponse;
import com.example.nidhidepositapp.Response.MemberFDPlanListResponse;
import com.example.nidhidepositapp.Response.MemberHomePageAndDashboardResponse;
import com.example.nidhidepositapp.Response.MemberLoginWithIDAndPasswordResponse;
import com.example.nidhidepositapp.Response.MemberRDPlanListResponse;
import com.example.nidhidepositapp.Response.MemberSavingLedgerDetailResponse;
import com.example.nidhidepositapp.Response.MemberSavingLedgerListResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {
@POST("Service/MemberLoginWithIDAndPassword")
Call<MemberLoginWithIDAndPasswordResponse>LoginIdAndPassword(@Body MemberLoginWithIDAndPasswordRequest memberLoginWithIDAndPasswordRequest);

@POST("Service/MemberHomePageAndDashboard")
Call<MemberHomePageAndDashboardResponse>ClientDashboard(@Body MemberHomePageAndDashboardRequest memberHomePageAndDashboardRequest);

@POST("Service/MemberFDPlanList")
Call<MemberFDPlanListResponse>PlanListActivity(@Body MemberFDPlanListRequest memberFDPlanListRequest);

@POST("Service/MemberFDPlanDetail")
    Call<MemberFDPlanDetailResponse>PlanDetailActivity(@Body MemberFDPlanDetailRequest memberFDPlanDetailRequest);

@POST("Service/MemberSavingLedgerList")
    Call<MemberSavingLedgerListResponse>LedgerListActivity(@Body MemberSavingLedgerListRequest memberSavingLedgerListRequest);

@POST("Service/MemberSavingLedgerDetail")
    Call<MemberSavingLedgerDetailResponse>LedgerDetailActivity(@Body MemberSavingLedgerDetailRequest memberSavingLedgerDetailRequest);
@POST("Service/MemberRDPlanList")
    Call<MemberRDPlanListResponse>RDPlanListActivity(@Body MemberRDPlanListRequest memberRDPlanListRequest);
}
