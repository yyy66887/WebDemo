<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>欢迎界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  ${pageContext.request.contextPath }
  <c:if test="${sessionScope.user==null}">
  <a href="${pageContext.request.contextPath }/login.jsp">登录</a>
  <a href="${pageContext.request.contextPath }/regist.jsp">还没有账号</a>
  </c:if>
  <c:if test="${sessionScope.user!=null}">
  	欢迎你：${sessionScope.user.nick }!
  	<a href="${pageContext.request.contextPath}/servlet/CenterController?operation=loginout" >注销 </a>
  </c:if>
    欢迎光临！ <br> 
  </body>
</html>
