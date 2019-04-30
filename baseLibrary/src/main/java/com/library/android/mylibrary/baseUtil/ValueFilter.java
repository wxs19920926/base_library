package com.library.android.mylibrary.baseUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by wxs on 2019/4/29.
 */

public abstract class ValueFilter {
    /**
     * 清空JSONObject 值前后空格
     * @param object
     */
    private void jsonParameterTrimObject(JSONObject object){
        for(String str: object.keySet()){
            Object o = object.get(str);
            if(null != o){
                if(o instanceof String){ //值为字符串类型
                    jsonObjectFilter(object, str, o);
//                    object.put(str,((String) o).trim()); //清空值前后空格
                }
                if(o instanceof JSONObject){ //值为JSON对象
                    jsonParameterTrimObject((JSONObject)o);
                }
                if(o instanceof JSONArray) { //值为JSON数组
                    jsonParameterTrimArray((JSONArray)o);
                }
            }
        }
    }

    /**
     * 清空JSONArray 值前后空格
     * @param array
     */
    private void jsonParameterTrimArray(JSONArray array){
        if(array.size() > 0){
            for(int i=0; i< array.size();i++){
                Object oa = array.get(i);
                if(null != oa){
                    if(oa instanceof String){ //值为字符串类型
                        jsonArrayFilter(array, i, oa);
//                        array.set(i,((String) oa).trim()); //清空值前后空格
                    }
                    if(oa instanceof JSONObject){ //值为JSON对象
                        jsonParameterTrimObject((JSONObject)oa);
                    }
                    if(oa instanceof JSONArray) { //值为JSON数组
                        jsonParameterTrimArray((JSONArray)oa);
                    }
                }
            }
        }
    }

    public abstract void jsonArrayFilter(JSONArray array, int i, Object oa);

    public abstract void jsonObjectFilter(JSONObject array, String str, Object o);
}
