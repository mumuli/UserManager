<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mfn" uri="http://www.alan.com/jsp/jstl/functions/util" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改用户</title>
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
		<h1>修改用户</h1>
		<s:form action="user_modify.do" method="post">
			<s:textfield key="user.name" name="姓名"/>
			<s:date id="user.birthday" name="生日" format="yyyy-mm-dd" var="birthday"/>
			<s:select name="groupList" list="groupList" listKey="gid" listValue="name"/>
			<s:submit value="修改"/><s:reset value="复原"/>
		</s:form>
		<s:debug/>
  </body>
</html>
