package com.study.bean;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.study.common.IdTypeEnum;

public class UserConvert implements Converter<String> {

    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    /**
     * 将excel的数据类型转为java数据类型
     * @param cellData
     * @param excelContentProperty
     * @param globalConfiguration
     * @return
     * @throws Exception
     */
    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {

        return IdTypeEnum.getTypeByDesc(cellData.getStringValue());
    }

    /**
     * 将java的数据类型转为excel数据类型
     * @param s
     * @param excelContentProperty
     * @param globalConfiguration
     * @return
     * @throws Exception
     */

    @Override
    public CellData convertToExcelData(String s, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(IdTypeEnum.getDescByType(s));
    }


}
