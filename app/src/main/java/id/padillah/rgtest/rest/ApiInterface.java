package id.padillah.rgtest.rest;

import id.padillah.rgtest.model.ResponseGift;
import id.padillah.rgtest.model.ResponseItem;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    //Login
//    @FormUrlEncoded
//    @POST("auth/login")
//    Call<ResponseData> signIn(@Field("username_or_email") String username_or_email,
//                              @Field("password") String password);
    //Gifts List
    @GET("gift")
    Call<ResponseGift> getGift();

    @GET("gift")
    Call<ResponseGift> getGiftBySlug(@Query("slug") String slug);
}

