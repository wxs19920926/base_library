package com.library.android.mylibrary.baseRest.model;

import java.util.ArrayList;

/**
 * Created by wxs on 2019/4/4.
 */

public interface CallSaveBack<R> {

    public String callBackObject(R result);

    public void callBackResult(R result);

}
