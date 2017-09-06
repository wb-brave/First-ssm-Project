<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="common/common.jspf" %>
<html>
<head>


<title>My JSP 'MyJsp.jsp' starting page</title>

<script type="text/javascript">
	$(function(){
		$("#bt1").click(
			function(){
				$.post(
					"supplier/json.action"	,
					{
						sup_id : 326,
						sup_name : "daddy"
					},
					function(data) {
						alert(data.supName)
					}					
				)
			}	
		)
	}
	);
</script>
</head>

<body>

	<button id="bt1">test</button>
</body>
</html>