package com.library.android.mylibrary.baseRest.imp;

import java.util.ArrayList;

/**
 * Created by wxs on 2019/4/4.
 */

public interface CallListBack<T, R> {

    //返回json解析对象
    public String callBackObject(R result);

    //返回数组
    public void callBackList(ArrayList<T> arrayList);

    //保存校验返回
    public boolean callBackResult(R result);
}
