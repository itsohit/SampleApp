package com.example.sampleapp;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class RetrofitClass {

    private Retrofit retrofit=null;
    private ApiClass apiClass =null;
    private String Baseurl = "";
    private String RegistrationUrl = "";

    public ApiClass getApiClass(){
        return setRetrofitUrl(Baseurl);
    }

    private ApiClass setRetrofitUrl(String url){
        if(apiClass == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiClass = retrofit.create(ApiClass.class);
        }
        return apiClass;
    }


    public ApiClass getLoginRegistertion(){
        return setRetrofitUrl(RegistrationUrl);
    }

    public interface ApiClass{

        @GET("api/exchange/odds/eventType/4")
        Call<Void> getMatches();

        @FormUrlEncoded
        @POST("Api/testing.php")
        Call<Void> setRegistration(@Field("username") String name, @Field("mail") String email, @Field("password") String password, @Field("refferralcode") String refcode);

    }
}