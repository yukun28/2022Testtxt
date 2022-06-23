package com.web;

import com.service.InfoService;
import com.service.impl.InfoServiceImpl;
import com.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/7/30.
 */
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNo");
        InfoService infoService;
        infoService = new InfoServiceImpl();
        Page page=infoService.getPage(pageNo);
        request.getSession().setAttribute("page",page);
        response.sendRedirect(request.getContextPath()+"/phonelist.jsp");
    }
}
