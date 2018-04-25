<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jspf"%>

<html>
  <head>
    <title>没有权限</title>
  </head>
  <style type="text/css">
	body {
	background-image: url('${proPath}/img/bgmain.jpg');
	background-size: cover;
	
	}
</style>
  <body style="background-image: url('${proPath}/img/bghead3.jpg'); align-content: center;">
    	对不起！您没有访问此功能的权限；请联系系统管理员。&nbsp;&nbsp;&nbsp;&nbsp;
    	<a href="javascript:history.go(-1)">《《返回</a>
  </body>
</html>
