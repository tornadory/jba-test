<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="../layouts/taglib.jsp"%>

<h1>Latest news from the Java World:</h1>


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>date</th>
			<th>item</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>
				<c:out value="${item.publishedDate}" />
				<br />
				<c:out value="${item.blog.name}" />
				</td>
				<td><strong> <a href="<c:out value="${item.link}" />"
						target="_blank"> <c:out value="${item.title}" />
					</a>
				</strong> <br /> <%-- <c:out value="${item.description}" /> --%>
					${item.description}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>