package com.study.service;

import java.util.List;

public interface ServiceUpload<T extends List> {
     int saveData(T t);
}
