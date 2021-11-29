package com.example.roomdatamvvm.Network;


import com.example.roomdatamvvm.Model.REPORT;
import com.example.roomdatamvvm.Model.RechargeListResponse;
import com.example.roomdatamvvm.Model.Userdetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface IGoogleApi {


//    @GET("data.php")
//    Call<List<Actor>> getAllActors();

    @FormUrlEncoded
    @POST("api/AppService/login")
    Call<Userdetail> login(@Field("Name") String name,
                            @Field("Pass") String pass,
                            @Field("IMEI") String imei,
                            @Field("Version") String version);

    @FormUrlEncoded
    @POST("Api/App/webservice/RechargeReport")
    Call<RechargeListResponse> rechargreportdata(@Field("Tokenid") String token, @Field("Startdate") String Startdate,
                                                       @Field("Enddate") String Enddate, @Field("MobileNo") String MobileNo,
                                                       @Field("PageNumber") int pageNumber, @Field("PageSize") int pageSize,
                                                       @Field("Version") String Version, @Field("TypeId") String TypeId);






}

