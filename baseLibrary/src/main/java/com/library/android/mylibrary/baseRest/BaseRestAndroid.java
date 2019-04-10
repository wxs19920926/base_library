package com.library.android.mylibrary.baseRest;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.library.android.mylibrary.baseRest.model.CallSaveBack;
import com.library.android.mylibrary.baseRest.model.Result;
import com.library.android.mylibrary.baseUtil.TestUtil;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wxs on 2019/4/4.
 */

public class BaseRestAndroid {
    private static BaseRestAndroid instance;

    public static synchronized BaseRestAndroid getInstance(){
        if(instance == null)
            instance = new BaseRestAndroid();
        return instance;
    }

    /**
     * get获取数组对象
     * @param url
     * @param data
     * @param oclass
     * @param <T>
     */
    public <T, R> void getSearchList(String url, String data, final Class<T> oclass, final Class<R> rclass, CallListBack callBack){
        searchList(Rx2AndroidNetworking
                .get(url).addQueryParameter("data", data)
                .build()
                .getStringObservable(), oclass, rclass, callBack);
    }

    /**
     * post获取数组对象
     * @param url
     * @param data
     * @param oclass
     * @param <T>
     */
    public <T, R> void postSearchList(String url, String data, final Class<T> oclass, final Class<R> rclass, CallListBack callBack){
        searchList(Rx2AndroidNetworking
                .post(url).addQueryParameter("data", data)
                .build()
                .getStringObservable(), oclass, rclass, callBack);
    }

    /**
     * 查询接口
     * @param observable
     * @param oclass
     * @param callBack
     * @param <T>
     */
    private  <T, R> void searchList(Observable observable, final Class<T> oclass, final Class<R> rclass, final CallListBack callBack) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<String, R>() {
                    @Override
                    public R apply(String str) throws Exception {
                        R result = JSON.parseObject(str, rclass);
                        return result;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<R>() {
                    @Override
                    public void accept(R result) throws Exception {
                        if(!callBack.callBackResult(result)) {
                            return;
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<R, ArrayList<T>>() {
                    @Override
                    public ArrayList<T> apply(R result) throws Exception {
                        ArrayList<T> arrayList = (ArrayList<T>) JSONArray.parseArray(callBack.callBackObject(result), oclass);
                        return arrayList;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<T>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArrayList<T> arrayLists) {
                        if(TestUtil.isNotNull(arrayLists)) {
                            callBack.callBackList(arrayLists);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        String error = e.getMessage();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * get保存对象
     * @param url
     * @param data
     */
    public  <R> void getSaveObject(String url, String data, final Class<R> rclass, CallSaveBack callBack){
        saveObject(Rx2AndroidNetworking
                .get(url).addQueryParameter("data", data)
                .build()
                .getStringObservable(), rclass, callBack);
    }

    /**
     * post保存对象
     * @param url
     * @param data
     */
    public  <R> void postSaveObject(String url, String data, final Class<R> rclass, CallSaveBack callBack){
        saveObject(Rx2AndroidNetworking
                .post(url).addQueryParameter("data", data)
                .build()
                .getStringObservable(), rclass, callBack);
    }

    private  <R> void saveObject(Observable observable, final Class<R> rclass,final CallSaveBack callBack) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<String, R>() {
                    @Override
                    public R apply(String str) throws Exception {
                        R result = JSON.parseObject(str, rclass);
                        return result;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<R>() {
                    @Override
                    public void accept(R result) throws Exception {
                        if(!callBack.callBackResult(result)) {
                            return;
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<R>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(R result) {
                        if(TestUtil.isNotNull(result)) {
                            callBack.callBackResult(result);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        String error = e.getMessage();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
