<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ page isELIgnored='true'%> --%> 
<!-- 接收不到变量user的原因  
在web.xml的＜jsp-property-group＞中可以控制一组JSP是否使用EL，
在每个JSP中也可以指定是否该JSP使用EL。
在page directive中的isELIgnored属性用来指定是否忽略。
＜%@ page isELIgnored＝"true|false"%＞
如果设定为真，那么JSP中的表达式被当成字符串处理。
比如下面这个表达式＜p＞${2000 % 20}＜/p＞在isELIgnored＝"true"时输出为${2000 % 20}，
而isELIgnored＝"false"时输出为100。
Web容器默认isELIgnored＝"false"。 
-->


<h1>User: ${user.name}</h1>
