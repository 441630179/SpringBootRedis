package com.study.controller;

import com.study.common.Constans;
import com.study.exception.BizException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pengwei.tan
 * @date 2019-01-27
 */

public class ControllerBase {

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Map<String, String> handlException(BizException e) {
        Map<String, String> map = new HashMap();
        map.put(Constans.RERUN_CODE, e.getCode());
        map.put(Constans.RERUN_MSG, e.getMessage());
        return map;
    }

    protected Map<String, String> successMap(String message) {
        Map<String, String> map = new HashMap<>();
        map.put(Constans.RERUN_MSG, message);
        map.put(Constans.RERUN_CODE, "000000");
        return map;
    }

    protected Map<String, String> failMap(String code, String message) {
        Map<String, String> map = new HashMap<>();
        map.put(Constans.RERUN_MSG, message);
        map.put(Constans.RERUN_CODE, code);
        return map;
    }

}
