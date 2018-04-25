<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>修改密码</title>
</head>
<body style="background-image: url('${proPath}/img/bg.jpg');">

	<form id="ff" method="post" >
	   <div>
			<label for="userLogin" style="align-content: center; margin: 0px 0px 0px 30px" >用户:</label> <input readonly="readonly" type="text" name="accLogin" value="${sessionScope.acc}"/>
		</div>
		<div>
			<label for="userPass" style="align-content: center; margin: 0px 0px 0px 30px">密码:</label><input type="password" name="userPass" value="${sessionScope.pass}"/>
		</div>
		<div>
			<label for="userPass" style="align-content: center; margin: 0px 0px 0px 30px">确认密码:</label> <input type="password" name="userPass2" />
		</div>
	</form>

	<script type="text/javascript">
	$(function() {
			/* var win = parent.$("iframe[title='欢迎使用进销存管理系统']").get(0).contentWindow; */
			//
			/* var row = win.$('#dg').datagrid("getSelected"); */
			//alert(row.supId);
			
			$("[name='userPass']").validatebox({
				required : true,
				missingMessage : '请填写修改密码！'
			});
			$("[name='userPass2']").validatebox({
				required : true,
				missingMessage : '请确认您要修改的密码！'
			});
		
			//禁用验证
			$("#ff").form("disableValidation");

			$('#ff').dialog({
				title : '修改密码',
				width : 300,
				height : 180,
				closed : false,
				cache : false,
				//设置关闭按钮可见
				closable : false,
				//模式化窗口.如果为true将锁屏
				modal : true,
				buttons:[{
					text:'修改',
					handler:function(){
						//启用验证
						$("#ff").form("enableValidation");
						//进行验证，通过就提交
						if($("#ff").form("validate")){
						//提交
							$('#ff').form('submit', {
								url : '${proPath}/user/updatepass.action',
								onSubmit : function() {
									return true;
								},
								success : function(count) {							
										//可以定义为对应消息框
										alert(count);
										if(count>0){
											alert("修改成功！");									
											window.location.href='${proPath}/user/login.action';
										}else if(count==-3){
											window.location.href='${proPath}/noPermissionUI.jsp';
										}else{
											alert("修改失败！");
										}
										/* parent.$("#win").window("close"); */
								}
							});
						}
						
					}
				}]
			});
	});
	</script>
</body>
</html>
