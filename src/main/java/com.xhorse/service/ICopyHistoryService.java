package com.xhorse.service;

import com.xhorse.entity.model.XhCopyHistory;

import java.util.List;


public interface ICopyHistoryService {
    List<XhCopyHistory> queryCopyHistoryByType(String json);
    void uploadCopyHistory(String json);
    void updateCopyHistoryById(String json);
}
