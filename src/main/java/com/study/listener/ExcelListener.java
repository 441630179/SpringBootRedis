package com.study.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.study.Utils.ValidateUtils;
import com.study.service.ServiceUpload;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public  class ExcelListener<T> extends AnalysisEventListener<T> {
    private final List<T> rows = new ArrayList<>();
    private final List<T> errrows = new ArrayList<>();
    private static final int BATCH_COUNT = 5;
    private ServiceUpload serviceUpload;

    public ExcelListener(ServiceUpload serviceUpload) {
        this.serviceUpload = serviceUpload;
    }

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {

        try {
            ValidateUtils.validateEntity(t);
            rows.add(t);
            log.info("解析到一条正确数据:{} ", JSONObject.toJSONString(t));
            if (rows.size() >= BATCH_COUNT) {
                saveData();
                // 存储完成清理 list
                rows.clear();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            errrows.add(t);
            log.info("解析到一条错误数据:{} ", JSONObject.toJSONString(t));
        }


    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("共解析正确数据:{}，错误数据:{} ", rows.size(),errrows.size());
        saveData();
    }

    public void saveData() {
        log.info("{}正确条数据，开始存储数据库！", rows.size());
        if (CollectionUtils.isNotEmpty(rows)) {
            serviceUpload.saveData(rows);

        }
        log.info("存储数据库成功！");
    }


    public List<T> getCorrectRows() {
        return rows;
    }
    public List<T> getErrorRows() {
        return errrows;
    }
}
