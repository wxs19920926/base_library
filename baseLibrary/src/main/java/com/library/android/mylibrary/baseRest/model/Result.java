package com.library.android.mylibrary.baseRest.model;

import java.io.Serializable;

/**
 * Created by wxs on 2017/12/11.
 */
public class Result<E> implements Serializable {
    private String code;

    private String message;

    private ResultData<E> object;

    private String success;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultData<E> getObject() {
        return object;
    }

    public void setObject(ResultData<E> object) {
        this.object = object;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
