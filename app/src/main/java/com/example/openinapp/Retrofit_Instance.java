package com.example.openinapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Instance {

    private  static  final String BASEURL="https://api.inopenapp.com/";
    static Retrofit retrofit;
    static Retrofit  getRetrofit_Instance(){
       if(retrofit==null){
           retrofit=new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();

       }

return  retrofit;
     }
}
