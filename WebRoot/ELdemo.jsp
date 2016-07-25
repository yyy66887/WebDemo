<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tomcat.apache.org/myfn" prefix="myfn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'ELdemo.jsp' starting page</title>
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
  <jsp:useBean id="p" class="domain.Student"></jsp:useBean>
  <jsp:setProperty property="name" name="p" value="gggg"/>
  ${p.name}
  <%String str[]={"a","b","c"};
  pageContext.setAttribute("str", str);
   %>
   ${str[1]}
   <%
   List list = new ArrayList();
   list.add("aa");
   list.add("bb");
   list.add("cc");
   pageContext.setAttribute("list", list);
   Map map = new LinkedHashMap();
   map.put("a", "aaa");
   map.put("b", "bbb");
   pageContext.setAttribute("map", map);
   
    %>
    ${list[2]}
    ${map["a"]}
    ${empty map }
    
    <%
       pageContext.setAttribute("yyy","hhhsfafd");
     %>
    
    ${myfn:toUpperCase(yyy)}
    ${fn:toUpperCase(yyy) }
    <c:if test="${!empty yyy}">hh</c:if>
    <!-- var 指向的是Map.Entry类型的 -->
    <c:forEach items="${map}" var="de">
    ${de.key}<br/>
    
    </c:forEach>
  </body>
</html>
