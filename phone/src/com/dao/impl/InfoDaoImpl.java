package com.dao.impl;

import com.dao.InfoDao;
import com.entity.Information;
import com.utils.C3p0Util;
import com.utils.Page;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * Created by Administrator on 2019/7/30.
 */
public class InfoDaoImpl implements InfoDao {
    private QueryRunner queryRunner=new QueryRunner(C3p0Util.getDatasource());
    @Override
    public Page getPage(String pageNo) {
        Integer pageSize=3;
        if(pageNo==null||pageNo.equals("")){
            pageNo="1";
        }
        Integer rows=0;
       try{
            StringBuilder sb=new StringBuilder();
            sb.append("select count(*) from information");
           String s = queryRunner.query(sb.toString(), new ScalarHandler()).toString();
           rows=Integer.parseInt(s);
           Page page=new Page(pageSize,Integer.parseInt(pageNo),rows);
           List<Information> list=queryRunner.query("select * from information limit ?,?",new BeanListHandler<Information>(Information.class),(page.getPageNo()-1)*pageSize,pageSize);
           page.setList(list);
           return page;
       }catch (Exception e){
            throw new RuntimeException(e);
       }
    }

    @Override
    public Information getInfoById(Integer id) {
        try{
           return queryRunner.query("select * from information where id=?",new BeanHandler<Information>(Information.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
