package com.web;

import com.dao.ReplyDao;
import com.dao.impl.ReplyDaoImpl;
import com.entity.Information;
import com.entity.Reply;
import com.service.InfoService;
import com.service.impl.InfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2019/7/30.
 */
public class AddreplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String infoid = request.getParameter("infoid");
        String replycontent = request.getParameter("replycontent");
        ReplyDao replyDao = new ReplyDaoImpl();
        if(replyDao.AddReply(infoid,replycontent)){
            InfoService infoService = new InfoServiceImpl();
            Information information = infoService.getInfoById(Integer.parseInt(infoid));
            ReplyDao replyDao1 = new ReplyDaoImpl();
            List<Reply> replyList = replyDao1.getReplyListByInfoId(information.getId());
            request.getSession().setAttribute("replyList", replyList);
            request.getSession().setAttribute("information", information);
            response.getWriter().print("<script>alert('评论成功!');location.href='"+request.getContextPath()+"/infoview.jsp';</script>");
           // response.sendRedirect(request.getContextPath() + "/infoview.jsp");
        } else {
            response.getWriter().print("<script>alert('评论失败！);history.go(-1);</script>");
        }
    }
}
