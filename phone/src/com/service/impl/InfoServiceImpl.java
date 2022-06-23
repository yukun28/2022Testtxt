package com.service.impl;

import com.dao.InfoDao;
import com.dao.impl.InfoDaoImpl;
import com.entity.Information;
import com.utils.Page;

/**
 * Created by Administrator on 2019/7/30.
 */
public class InfoServiceImpl implements com.service.InfoService {
    private InfoDao infoDao=new InfoDaoImpl();
    @Override
    public Page getPage(String pageNo) {
        return infoDao.getPage(pageNo);
    }

    @Override
    public Information getInfoById(Integer id) {
        return infoDao.getInfoById(id);
    }
}
