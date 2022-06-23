package com.dao;

import com.entity.Reply;

import java.util.List;

/**
 * Created by Administrator on 2019/7/30.
 */
public interface ReplyDao {
    List<Reply> getReplyListByInfoId(Integer id);

    boolean AddReply(String infoid, String replycontent);

}
