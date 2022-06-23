package com.dao.impl;

import com.dao.ReplyDao;
import com.entity.Reply;
import com.utils.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/30.
 */
public class ReplyDaoImpl implements ReplyDao {
    private QueryRunner queryRunner = new QueryRunner(C3p0Util.getDatasource());

    @Override
    public List<Reply> getReplyListByInfoId(Integer id) {
        try {
            return queryRunner.query("select * from reply where infold=?  ORDER BY replytime DESC", new BeanListHandler<Reply>(Reply.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean AddReply(String infoid, String replycontent) {
        boolean b=false;
        try {
            Date date = new Date();

            int n = queryRunner.update("insert into reply values(null,?,?,?)", replycontent,date, Integer.parseInt(infoid));
            int m = queryRunner.update("update information set lastposttime=? where id=?", date, Integer.parseInt(infoid));
            if(n>0&&m>0){
                b=true;
            }else {
                b=false;
            }
            return b;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
