package com.service;

import com.entity.Information;
import com.utils.Page;

/**
 * Created by Administrator on 2019/7/30.
 */
public interface InfoService {
    Page getPage(String pageNo);

    Information getInfoById(Integer id);
}
