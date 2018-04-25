<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<title></title>
<style type="text/css">
.searchbox {
	margin: -3
}
</style>

<script type="text/javascript">
	$(function(){
	
			$('#dg').datagrid({    
			    //url:'${proPath}/supplier/selectPage.action', //通过关键字查询
			    //支持多条件查询
			    url:'${proPath}/user/userPageDyc.action', 
			    
			    fitColumns:true,
			    nowrapL:true,
			    idField:'userId',
			    rownumbers:true,
			    pagination:true,
			    pageSize:5,
			    pageList:[2,5,10,20],
			    
			     queryParams: {
					userLogin: '%%'		
				}, 
						    
			    toolbar: [{
					iconCls: 'icon-add',
					text:'新增',
					handler: function(){
						/* alert('新增按钮'); */
						if(${sessionScope.flag==0}){
							parent.$('#win').window({    
								title :'添加用户',						
							    width:600,    
							    height:400,    
							    modal:true,
							    content:"<iframe src='${proPath}/base/goURL/user/insert.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
							}); 
						}else{
							window.location.href='${proPath}/noPermissionUI.jsp';
						}
						
					}
						

				},'-',{
					iconCls: 'icon-edit',
					text:'修改',
					handler: function(){
						/* alert('修改按钮'); */
						//判断是否选中一行，并且只能选中一行进行修改
						if(${sessionScope.flag==0}){
							var array = $('#dg').datagrid("getSelections");
							if(array.length!=1){
								alert("请选择需要修改的记录，并且只能选中一条！");
								return false;							
							}
							
							//打开修改窗口
							parent.$('#win').window({    
								title :'修改用户信息',
							    width:600,    
							    height:400,    
							    modal:true,
							    content:"<iframe src='${proPath}/base/goURL/user/update.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
							}); 
						}else{
							window.location.href='${proPath}/noPermissionUI.jsp';
						}
						
					}
				},'-',{
					iconCls: 'icon-remove',
					text:'删除',
					handler: function(){
						/* alert('删除按钮'); */
						if(${sessionScope.flag==0}){
							var array = $('#dg').datagrid("getSelections");
							if(array.length>0){
								
								
								//定义数组，通过下边的用来存储选中记录的Id
							var ids = new Array();
							for (i = 0; i < array.length; i++) {
								ids[i] = array[i].userId;
								alert(ids[i]);
							}
							//alert("ids" + ids);
							//如果需要锁整个页面，前面加parent.
							parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
								if (r) {
									//alert(r);
									$.ajax({
									  url: "${proPath}/user/deleteList.action",
									  type:"POST",
									  //设置为传统方式传送参数
									  traditional:true,
									  data:{pks:ids},
									  success: function(html){
										  if(html>0){
										  	alert("恭喜您 ，删除成功，共删除了"+html+"条记录");
										  }else{
										  	alert("对不起 ，删除失败");
										  }
									  //重新刷新页面
									    $("#dg").datagrid("reload");
									    //请除所有勾选的行
									    $("#dg").datagrid("clearSelections");
									  },
									  error: function (XMLHttpRequest, textStatus, errorThrown) {
										    $.messager.alert('删除错误','请联系管理员！','error');
										},
									  dataType:'json'
									});
	
	
								}
							});
						}else{
							alert("请选择需要删除的记录！");
						}
					}else{
						window.location.href='${proPath}/noPermissionUI.jsp';
					}
						
					}
				},'-',{
					text:"用户名：<input type='text' id='userLogin' name='userLogin'/>",					
				}],			       
			    

				columns : [ [{
					checkbox:true,
				}, {
				field : 'userId',
				title : '用户编号'
			}, {
				field : 'userLogin',
				title : '用户登录名',
				width : 100
			}, {
				field : 'userName',
				title : '用户名称',
				width : 100
			}, {
				field : 'userPhone',
				title : '联系电话',
				width : 100
			}, {
				field : 'userAddress',
				title : '地址',
				width : 100
			}, {
				field : 'userType',
				title : '用户类型',
				width : 100
				
			}, {
				field : 'userRemark',
				title : '备注',
				width : 100,
				align : 'right'
			} ] ]
		});
		
			$('#userLogin').searchbox({ 
			searcher:function(value,name){ 
				$('#dg').datagrid('load',{
					userLogin: '%'+$('#userName').val()+'%',	
				});					
			}, 
			prompt:'' 
		});
		
	/* 通过关键字查询
		$('#ss').searchbox({ 
			searcher:function(value,name){ 
				alert(value + "," + name); 
				$('#dg').datagrid('load',{
					keyWord: '%'+value+'%'					
				});					
			}, 
			prompt:'请输入供应商名称' 
		}); */ 

	});
</script>
</head>

<body>

	<table id="dg"></table>
</body>
</html>