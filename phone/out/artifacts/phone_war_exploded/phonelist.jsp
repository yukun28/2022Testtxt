<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 800px;margin: 0 auto">
    <h3 style="text-align: center">手机资讯</h3>
    <table style="width: 100%">
        <tr style="text-align: center">
            <td>序号</td>
            <td>标题</td>
            <td>回复/查看</td>
            <td>发表时间</td>
            <td>最新回复时间</td>
        </tr>
        <c:if test="${sessionScope.page.list!=null}">
            <c:forEach var="information" items="${sessionScope.page.list}">
                <tr>
                    <td>${information.id}</td>
                    <td><a href="${pageContext.request.contextPath}/infoview.do?id=${information.id}">${information.title}</a></td>
                    <td>${information.replycount}/${information.viewcount}</td>
                    <td><fmt:formatDate value="${information.reporttime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${information.lastposttime}"
                                        pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                </tr>
            </c:forEach>
        </c:if>

        <tr style="text-align: center">
            <td colspan="5">
                <a href="${pageContext.request.contextPath}/index.do?pageNo=1">首页</a>
                <a href="${pageContext.request.contextPath}/index.do?pageNo=${sessionScope.page.pageNo-1}">上一页</a>
                <a href="${pageContext.request.contextPath}/index.do?pageNo=${sessionScope.page.pageNo+1}">下一页</a>
                <a href="${pageContext.request.contextPath}/index.do?pageNo=${sessionScope.page.pageTotal}">尾页</a>
                第${sessionScope.page.pageNo}页/共${sessionScope.page.pageTotal}页
            </td>
        </tr>
    </table>
</div>
</body>
</html>
