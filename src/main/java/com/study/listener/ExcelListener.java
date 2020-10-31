package com.study.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.study.service.ServiceUpload;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class ExcelListener<T> extends AnalysisEventListener<T> {
    private final List<T> rows = new ArrayList<>();
    private static final int BATCH_COUNT = 5;
    private ServiceUpload serviceUpload;

    public ExcelListener(ServiceUpload serviceUpload) {
        this.serviceUpload = serviceUpload;
    }

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{} ", JSONObject.toJSONString(t));
        rows.add(t);
        if (rows.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            rows.clear();
        }
    }

    private void saveData() {
        log.info("{}条数据，开始存储数据库！", rows.size());
        serviceUpload.saveData(rows);
        log.info("存储数据库成功！");
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("共解析数据:{} ", rows.size());
        saveData();
    }

    public List<T> getRows() {
        return rows;
    }
}
