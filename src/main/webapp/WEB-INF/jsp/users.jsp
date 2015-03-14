<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored='true'%>
<!-- 禁止报错退出 ${users}找不到 -->
<body>
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>user name: ${users}</th> <!-- users传不过来 -->>
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
</body>
</html>