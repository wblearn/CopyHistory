package com.xhorse.entity.response;


import java.util.List;

public class CopyHistoryResponse<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
