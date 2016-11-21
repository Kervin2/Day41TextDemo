package com.panfengyu.day41textdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1、创建Retrofit对象  建造者模式
 * 2、创建一个请求 是一个接口服务 apiService:
 * 3、使用 get post
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * /  完整的请求地址：2
     * http://mrobot.pcauto.com.cn/v2/cms/channels/1?pageNo=1&pageSize=20&serialIds=2143,3404&v=4.0.0
     * // pageNo=1&pageSize=20&serialIds=2143,3404&v=4.0.0
     *
     * @param view
     */

//get请求
    public void MygetClick(View view) {
        //1、创建Retrofit对象  建造者模式
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mrobot.pcauto.com.cn/v2/cms/")//请求地址的前半部分
                .addConverterFactory(GsonConverterFactory.create())//添加转换工厂
                .build();


        MyGetInterface myGetInterface = retrofit.create(MyGetInterface.class);
        myGetInterface.getData().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    response.body().string();
                    Log.d("flag", "onResponse() called with: " + "call = [" + call + "], response = [" + response + "]");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    //post请求
    public void MyPostClick(View view) {

    }
    //

    //get带请求头
    public void MyGetHeaderClick(View view) {

    }
}
