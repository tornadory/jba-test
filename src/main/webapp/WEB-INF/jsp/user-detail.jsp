<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layouts/taglib.jsp"%>

<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %> --%>
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

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">New Blog</button>

<form:form commandName="blog" cssClass="form-horizontal">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Blog</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name:</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">URL:</label>
						<div class="col-sm-10">
							<form:input path="url" cssClass="form-control" />
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Save" />
				</div>
			</div>
		</div>
	</div>
</form:form>

<c:forEach items="${user.blogs}" var="blog">
	<h1>${blog.name}</h1>
	<p>${blog.url}</p>
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Link</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blog.items}" var="item">
				<tr>
					<td>${item.title}</td>
					<td>${item.link}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:forEach>
