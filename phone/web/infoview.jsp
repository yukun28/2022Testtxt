<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div><h3>${sessionScope.information.title}</h3></div>
    <div>发表于:<fmt:formatDate value="${sessionScope.information.reporttime}"
                             pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></div>
    <p>${sessionScope.information.content}</p>
    <div>
        <h3>读者回应：</h3>
        <c:if test="${sessionScope.replyList!=null}">
            <c:forEach var="reply" items="${sessionScope.replyList}">
                <div>
                    <div>发表于:<fmt:formatDate value="${reply.replytime}"
                                             pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></div>
                    <div>${reply.content}</div>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <div style="font-size: 16px">快速评论:</div>
    <form style="margin-top: 0px" action="${pageContext.request.contextPath}/addreply.do?infoid=${sessionScope.information.id}" method="post">
        <textarea cols="40" rows="3" name="replycontent" id="replycontent"></textarea><br>
        <input type="submit" id="btnsubmit" name="btnsubmit" value="提交"> <a
            href="${pageContext.request.contextPath}/index.jsp">返回首页</a>
    </form>
</div>
</div>
</body>
</html>
