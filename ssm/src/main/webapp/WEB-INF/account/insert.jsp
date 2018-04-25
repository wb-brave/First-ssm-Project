<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>添加管理员</title>
</head>
<body>

	<form id="ff" method="post">
	   <div>
			<label for="accId">管理员编号:</label> <input type="text" name="accId" />
		</div>
		<div>
			<label for="accLogin">管理员登录名:</label> <input type="text" name="accLogin" />
		</div>
		<div>
			<label for="accName">管理员姓名:</label> <input type="text"
				name="accName" />
		</div>
		<div>
			<label for="accPass">管理员密码:</label> <input type="text"
				name="accPass" />
		</div>
		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='用户管理']").get(0).contentWindow;//返回ifram页面窗体对象（window)
		
			$("[name='accLogin']").validatebox({
				required : true,
				missingMessage : '请填写供应商！'
			});
			$("[name='accName']").validatebox({
				required : true,
				missingMessage : '请填写出联系人！'
			});
			$("[name='accPass']").validatebox({
				required : true,
				missingMessage : '请填写联系电话！'
			});
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/account/insert.action',
						onSubmit : function() {
							return true;
						},
						success : function(count) {							
								//可以定义为对应消息框
								if(count>0){
									alert("添加成功！");									
								}else{
									alert("添加失败！");
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
