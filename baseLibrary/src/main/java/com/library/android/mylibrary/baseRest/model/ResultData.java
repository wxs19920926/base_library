package com.library.android.mylibrary.baseRest.model;

import java.util.ArrayList;

/**
 * Created by wxs on 2017/12/11.
 */
public class ResultData<E> {
    //当前页
    private int currentPage;
    //当前数据数
    private int currentResult;
    //数据数组
    private ArrayList<E> data;
    //当前查询数量
    private int showCount;
    //总页数
    private int totalPage;
    //总数据数
    private int totalResult;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }

    public ArrayList<E> getData() {
        return data;
    }

    public void setData(ArrayList<E> data) {
        this.data = data;
    }

    public int getShowCount() {
        return showCount;
    }

    public void setShowCount(int showCount) {
        this.showCount = showCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }
}
