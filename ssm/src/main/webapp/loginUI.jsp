<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/common/common.jspf" %>
<html>
<head>


<title>用户登录界面</title>

<script type="text/javascript">
</script>
<style type="text/css">      
     body{      
        background-image: url('${proPath}/img/bg.jpg');      
        background-size:cover;    
     }      
 </style> 
</head>
<body>
	<div id="loginDiv">
		<form id="ff" method="post" action="${proPath}/user/login.action">
			<div style="align-content: center; margin-top: 15px">
				<label for="userLogin" style="align-content: center; margin: 0px 0px 0px 15px" >用户账号:</label>
				<!-- 采用 js验证 -->
				<input type="text" name="userLogin" style="width: 200px;"  />
			</div>
			<div style="align-content: center; margin-top: 10px">
				<label for="userPass" style="align-content: center; margin: 0px 0px 0px 15px">用户密码:</label>
				<input type="text" name="userPass" style="width: 200px;" />
			</div>
			<div style="align-content: center; margin-left: 70px">
				 <input class="text" name="vcode" type="text" placeholder="请输入验证码" style="width: 120px;margin-top: 10px;height: 24px">
          		<img title="点击图片切换验证码" style="height: 24px; width:80px; margin-top: 10px; position: absolute;" id="vcodeImg" src="${proPath}/user/vcode.action"></div>
			</div>
		</form>
		<div style="color:red">${requestScope.msg}</div>
	</div>
	<script type="text/javascript">
		/*
		 *＄｛选择器｝把ｄｏｍ对象转为ｊｑｕｅｒｙ对象，一般再处理成easyUI对象
		 *例如　把$("name='accName'")validatebox({})转为easyUI对象
		 *easyUI对象就可以使用相关的语法进行处理，如：$('selector').plugin('method', parameter); 
		 */
		//alert("ddddd");
		//这里的大括号相关于写json格式的数据：{属性：值，属性：值}
		//alert("ddddd");
		//点击图片切换验证码
		$("#vcodeImg").click(function(){
   			 this.src = "${proPath}/user/vcode.action?t=" + new Date().getTime();
		});
		$("[name='userLogin']").validatebox({
			required : true,
			missingMessage : '请填写账号！'
		});
		$("[name='userPass']").validatebox({
			required : true,
			missingMessage : '请填写密码！'
		});
		$("[name='vcode']").validatebox({
			required : true,
			missingMessage : '请填写验证码！'
		});
		
		
		//禁用验证
		$("#ff").form("disableValidation");
		
		//把div的内容作为对话框方式弹出
		$('#loginDiv').dialog({
			title : '登陆入口',
			width : 300,
			height : 180,
			closed : false,
			cache : false,
			//设置关闭按钮可见
			closable : false,
			//模式化窗口.如果为true将锁屏
			modal : true,
			buttons:[{
				text:'登陆',
				handler:function(){
					//启用验证
					$("#ff").form("enableValidation");
					//进行验证，通过就提交
					if($("#ff").form("validate")){
					//提交
							$("#ff").submit();
					}
					
				}
			},{
				text:'管理员登录',
				handler:function(){
					window.location.href='${proPath}/account/loginUI.action';
			}
			}]
			
		});
		
	</script>
</body>
</html>