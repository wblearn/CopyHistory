package com.xhorse.entity.request;

import com.xhorse.entity.model.XhCopyHistory;

public class CopyHistoryRequest {
    XhCopyHistory item;

    public XhCopyHistory getItem() {
        return item;
    }

    public void setItem(XhCopyHistory item) {
        this.item = item;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    String json;
}
