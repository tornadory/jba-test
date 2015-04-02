<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <jsp:include page="../layouts/taglib.jsp" /> --%>
<%@include file="../layouts/taglib.jsp" %>

<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %> --%>
<%-- <%@ page isELIgnored='true'%> --%> <!-- 开始这里接收不到users变量的问题所在 -->
<%-- <%@ page session="true" %> --%>
<!-- 禁止报错退出 ${users}找不到 -->

	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>user name</th> <!-- users传不过来 问题解决-->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td> <a href="<spring:url value='/users/${user.id}.html' />">
							${user.name} </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>