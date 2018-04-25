<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>My JSP</title>
</head>
<body>

	<form id="ff" method="post">
	   <div>
			<label for="userId">用户编号:</label> <input type="text" name="userId" />
		</div>
		<div>
			<label for="userLogin">登录名:</label> <input type="text" name="userLogin" />
		</div>
		<div>
			<label for="userName">用户名:</label> <input type="text"
				name="userName" />
		</div>
		<div>
			<label for="userPass">初始密码:</label> <input type="text" name="userPass"/>
		</div>
		<div>
			<label for="userPhone">联系电话:</label> <input type="text"
				name="userPhone" />
		</div>
		<div>
			<label for="userAddress">联系地址:</label> <input type="text"
				name="userAddress" />
		</div>
				<div>
			<label for="userType">用户类别:</label> <input type="text"
				name="userType" />

		<div>
			<label for="userRemark">备注:</label>
			<textarea name="userRemark"></textarea>
		</div>
		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='用户信息']").get(0).contentWindow;//返回ifram页面窗体对象（window)
			
			var row = win.$('#dg').datagrid("getSelected");
			//alert(row.supId);
			
			$('#ff').form('load',{
				userId:row.userId,
				userLogin:row.userLogin,
				userName:row.userName,
				userPass:row.userPass,
				userType:row.userType,
				userAddress:row.userAddress,
				userPhone:row.userPhone,
				userRemark:row.userRemark
			});

			
		
			$("[name='userName']").validatebox({
				required : true,
				missingMessage : '请填写用户名！'
			});
			$("[name='userAddress']").validatebox({
				required : true,
				missingMessage : '请填写地址！'
			});
			$("[name='supPhone']").validatebox({
				required : true,
				missingMessage : '请填写联系电话！'
			});
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					//alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/user/update.action',
						onSubmit : function() {
							return true;
						},
						success : function(count) {							
								//可以定义为对应消息框
								if(count>0){
									alert("修改成功！");									
								}else{
									alert("修改失败！");
								}
								parent.$("#win").window("close");
								win.$("#dg").datagrid("reload");							
						}
					});

				}

			});

		});
	</script>
</body>
</html>
