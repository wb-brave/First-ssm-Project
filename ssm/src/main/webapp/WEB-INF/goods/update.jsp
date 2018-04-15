<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>My JSP</title>
</head>
<body>

	<form id="ff" method="post">
	   <div>
			<label for="goodsId">货品编号:</label> <input type="text" name="goodsId" />
		</div>
		<div>
			<label for="goodsName">货品名:</label> <input type="text" name="goodsName" />
		</div>
		<div>
			<label for="goodsUnit">货品单位:</label> <input type="text"
				name="goodsUnit" />
		</div>
		<div>
			<label for="goodsType">货品类型:</label> <input type="text"
				name="goodsType" />
		</div>
		<div>
			<label for="goodsColor">货品颜色:</label> <input type="text"
				name="goodsColor" />
		</div>
				<div>
			<label for="goodsStore">货品仓库:</label> <input type="text"
				name="goodsStore" />
		</div>
				<div>
			<label for="goodsLimit">货品限制：</label> <input type="text" 
				name = "goodsLimit"> 									
		</div>
		<div>
			<label for="goodsCommission">货品交易:</label> <input type="text"
				name="goodsCommission" />
		</div>
		<div>
			<label for="goodsProducer">制造商:</label> <input type="text"
				name="goodsProducer" />
		</div>
				<div>
			<label for="goodsSelPrice">售价:</label> <input type="text"
				name="goodsSelPrice" />
		</div>
				<div>
			<label for="goodsBuyPrice">进价：</label> <input type="text" 
				name = "goodsBuyPrice"> 									
		</div>
		<div>
			<label for="goodsRemark">备注:</label>
			<textarea name="goodsRemark"></textarea>
		</div>
		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='商品管理']").get(0).contentWindow;//返回ifram页面窗体对象（window)
		
			var row = win.$('#dg').datagrid("getSelected");
			//alert(row.supId);
			
			$('#ff').form('load',{
				goodsId:row.goodsId,
				goodsName:row.goodsName,
				goodsUnit:row.goodsUnit,
				goodsType:row.goodsType,
				goodsColor:row.goodsColor,
				goodsStore:row.goodsStore,
				goodsLimit:row.goodsLimit,
				goodsCommission:row.goodsCommission,
				goodsProducer:row.goodsProducer,
				goodsRemark:row.goodsRemark,
				goodsSelPrice:row.goodsSelPrice,
				goodsBuyPrice:row.goodsBuyPrice
			});
			
			$("[name='goodsName']").validatebox({
				required : true,
				missingMessage : '请填写货品名称！'
			});
			$("[name='goodsSelPrice']").validatebox({
				required : true,
				missingMessage : '请填写售价！'
			});
			$("[name='goodsBuyPrice']").validatebox({
				required : true,
				missingMessage : '请填写进价！'
			});
			$("[name='goodsProducer']").validatebox({
				required : true,
				missingMessage : '请填写制造商！'
			});
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/goods/update.action',
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
