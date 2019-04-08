package com.library.android.mylibrary.baseRest;

import com.library.android.mylibrary.baseRest.model.Result;

import java.util.ArrayList;

/**
 * Created by wxs on 2019/4/4.
 */

public interface CallListBack<T, R> {

    public String callBackObject(R result);

    public void callBackList(ArrayList<T> arrayList);

    public boolean callBackResult(R result);
}
