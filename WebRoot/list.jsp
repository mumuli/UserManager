<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mfn" uri="http://www.alan.com/jsp/jstl/functions/util" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="js/json2.js"></script>
	<script type="text/javascript">
		function selectAll() {
			$("input[name='uidcb']").attr("checked", true);
		}
		function unselectAll() {
			$("input[name='uidcb']").attr("checked", false);
		}
		function reverseSelection() {
		 	$("input[name='uidcb']").each(function () {  
              this.checked = !this.checked;  
         });  
		}
		function deleteSelection() {
			var selectedUsers = $("input[name='uidcb']:checkbox:checked");
			var uidArray = new Array();
			var index = 0;
			selectedUsers.each(function() {
				// this is current DOM element, it's also valid with below code
				// this.value or this.getAttribute("value");
				uidArray[index++] = $(this).attr("value");
			});
			
			var actionStr = "user_delete.do?uidsToBeDeleted=" + JSON.stringify(uidArray);
			$("#user_form").attr("action", actionStr);
			$("#user_form").submit();
		}
	</script>
  </head>
  
  <body>
	<h1>用户列表</h1>
	<form id="user_form" method="post" action="">
		<input type="hidden" name="page" value="${page}">
		<input type="hidden" name="pageSize" value="${pageSize}" />
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<th></th>
				<th>ID</th>
				<th>Name</th>
				<th>Birthday</th>
				<th>Age</th>
				<th>HireDate</th>
				<th>Group</th>
				<th>Operation</th>
			</tr>
			<c:choose>
				<c:when test="${empty userList}}">
					<tr>
						<td colspan="8">无相关数据</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td><input type="checkbox" name="uidcb" value="${user.id}"/></td>
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td><fmt:formatDate value="${user.birthday}" pattern="yyyy年mm月dd日"/></td>
							<td>${mfn:getAge(user.birthday)}</td>
							<td><fmt:formatDate value="${user.hireDate}" pattern="yyyy年mm月dd日"/></td>
							<td>${user.group.name}</td>
							<td>
								<a href="#">Detail</a> | <a href="#">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="8" align="left">
					<a href="javascript:void(0)" onclick="javascript:selectAll(); return false;">全选   </a>
					<a href="javascript:void(0)" onclick="javascript:unselectAll(); return false;">全不选  </a>
					<a href="javascript:void(0)" onclick="javascript:reverseSelection(); return false;">反选   </a>
					<input type="button" value="删除选中" onclick="javascript:deleteSelection(); return false;"/>
				</td>
			</tr>
			<tr>
				<td colspan="8" align="right">
					总共${pageModel.totalCount}条， 每页${pageModel.pageSize}条, 当前${pageModel.page}/${pageModel.pageCount}  
					<a href="user_list.do?page=1">首页</a> 
					|
					<a href="user_list.do?page=${pageModel.page == 1 ? 1 : pageModel.page - 1}"> 上一页</a>
					| 
					<a href="user_list.do?page=${pageModel.page == pageModel.pageCount ? pageModel.pageCount : pageModel.page + 1}"> 下一页</a> 
					| 
					<a href="user_list.do?page=${pageModel.pageCount}">尾页</a> 
				</td>
			</tr>
		</table>
	</form>
	<s:debug/>
  </body>
</html>
