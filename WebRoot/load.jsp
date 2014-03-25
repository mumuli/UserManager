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
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
  </head>
  
  <body>
		<h1>修改用户</h1>
		<s:form action="user_modify.do" method="post">
			<s:hidden name="user.id"/>
			<s:textfield name="user.name" label="姓名"/>
			<s:date name="user.birthday" format="yyyy-mm-dd" var="birthday"/>
			<s:textfield id="birthday" name="birthday" label="生日" onclick="WdatePicker({el:'birthday'})"/>
			<s:date name="user.hireDate" format="yyyy-mm-dd" var="hireDate"/>
			<s:textfield id="hireDate" name="hireDate" label="入职" onclick="WdatePicker({el:'hireDate'})"/>
			<s:select name="groupList" list="groupList" listKey="gid" listValue="name" label="组别" value="%{user.group.gid}"/>
			<s:submit value="修改"/><s:reset value="复原"/>
		</s:form>
		<s:debug/>
  </body>
</html>
