package com.panfengyu.day41textdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kervin on 2016/11/21.
 *
 *
 * 2、创建一个请求 是一个接口服务 apiService:
 */
 interface MyGetInterface {
    //get请求   value = "请求地址的后半部分"
    @GET(value = "channels/1?pageNo=1&pageSize=20&serialIds=2143,3404&v=4.0.0")
    public Call<ResponseBody> getData();
}
