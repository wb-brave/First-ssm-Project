<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>

<style type="text/css">
body {
	background-image: url('${proPath}/img/bgmain.jpg');
	background-size: cover;
}
</style>

<title></title>

<script type="text/javascript">
	$(function() {
		//获得点击的 <a 标签
		$("a[title]")
				.click(
						function() {
							var text = this.href;
							alert(text);
							//判断是否存在
							if ($('#tt').tabs("exists", this.title)) {
								//存在则选中
								$('#tt').tabs("select", this.title);
							} else {
								$('#tt')
										.tabs(
												'add',
												{
													title : this.title,
													//面板有关闭按键
													closable : true,
													//href对远程页面js的支持不好 
													//href: text			
													//可以加载内容填充到选项卡，页面有Js时，也可加载
													content : "<iframe src='"
															+ text
															+ "' title='"
															+ this.title
															+ "' height='100%' width='100%' frameborder='0px' ></iframe>"

												});

							}
							return false;

						});
	});
</script>

</head>


<body class="easyui-layout">
	<!-- 头部 -->
	<div data-options="region:'north',title:'欢迎使用进销存管理系统',split:true"
		style="height:130px; background-image: url('${proPath}/img/top1.jpg'); color : red">
		<span style="font-size: 20px">欢迎您 ：</span>${sessionScope.acc}
		<c:if test="${sessionScope.flag==0}">
			<a href="${proPath}/base/goURL/account/update.action" style="margin-left: 900px ;text-decoration :none; position: absolute; color: red">修改密码</a>
		</c:if>
		<c:if test="${sessionScope.flag==2}">
			<a href="${proPath}/base/goURL/account/update.action" style="margin-left: 900px ;text-decoration :none; position: absolute; color: red">修改密码</a>
		</c:if>
		<c:if test="${sessionScope.flag==1}">
			<a href="${proPath}/base/goURL/user/updatepass.action" style="margin-left: 900px ;text-decoration :none; position: absolute; color: red">修改密码</a>
		</c:if>
		
		<c:if test="${sessionScope.flag==0}">
			<a href="${proPath}/account/login.action" style="margin-left : 960px;text-decoration :none; position: absolute; color: red;">退出登录</a>
		</c:if>
		<c:if test="${sessionScope.flag==1}">
			<a href="${proPath}/user/login.action" style="margin-left : 960px;text-decoration :none; position: absolute; color: red">退出登录</a>
		</c:if>
	</div>
	<!-- 左边导航 -->
	<div data-options="region:'west',title:'导航菜单',split:true"
		style="width:150px; background-image: url('${proPath}/img/bghead3.jpg');">

		<div id="aa" class="easyui-accordion"
			style="width:300px;height:200px; background-image: url('${proPath}/img/bghead3.jpg');">

			<div title="基础数据录入"
				style="background-image: url('${proPath}/img/bghead3.jpg');">


				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none; padding: 0px; margin: 0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/supplier/supplierlist.action"
						title="供应商管理"
						style="text-decoration: none; display: block; font-weight: bold;">供应商管理</a>
					</li>
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/goods/goodslist.action" title="商品管理"
						style="text-decoration: none; display: block; font-weight: bold;">商品管理</a>
					</li>
				</ul>
			</div>




			<div title="采购管理"
				style="background-image: url('${proPath}/img/bghead3.jpg');">


				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none; padding: 0px; margin: 0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/buyorder/insert.action" title="商品采购"
						style="text-decoration: none; display: block; font-weight: bold;">商品采购</a>
					</li>
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/returnorder/returnorder.action"
						title="商品退货"
						style="text-decoration: none; display: block; font-weight: bold;">商品退货</a>
					</li>
				</ul>
			</div>

			<div title="用户管理"
				style="background-image: url('${proPath}/img/bghead3.jpg');">
				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none; padding: 0px; margin: 0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/account/acctlist.action" title="管理员信息"
						style="text-decoration: none; display: block; font-weight: bold;">管理员信息</a>
					</li>
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/user/userlist.action" title="用户信息"
						style="text-decoration: none; display: block; font-weight: bold;">用户信息</a>
					</li>

				</ul>
			</div>
			
			<div title="库存管理"
				style="background-image: url('${proPath}/img/bghead3.jpg');">


				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none; padding: 0px; margin: 0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/store/list.action" title="库存信息"
						style="text-decoration: none; display: block; font-weight: bold;">库存信息</a>
					</li>
				</ul>
			</div>

			<div title="报表查询"
				style="background-image: url('${proPath}/img/bghead3.jpg');">
				<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
				<ul style="list-style: none; padding: 0px; margin: 0px;">
					<li style="padding: 6px;"><a
						href="${proPath}/base/goURL/datareport/selectsupplier.action"
						title="供应商采购额统计"
						style="text-decoration: none; display: block; font-weight: bold;">供应商采购额统计</a>
					</li>

				</ul>
			</div>
		</div>



	</div>

	<!-- 主体内容 -->
	<div data-options="region:'center',title:'主要信息'"
		style="padding:5px;">
		<div id="tt" class="easyui-tabs" data-options="fit:true"
			style="width: 500px; height: 250px;">
			<div title="系统介绍"
				style="padding:20px; color:red; background-image: url('${proPath}/img/bghead3.jpg');">进销存系统
			</div>

		</div>

	</div>
	<div id="win"></div>

</body>

</html>