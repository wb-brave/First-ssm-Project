<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
	<body>
		<h2 align="center">供应商</h2>
		<form action="supplier/insert.action" method="post">
			<table align="center" border="1" style="border-bottom-color: red; padding: 2px;">
				<tr>
					<td>
						名称：<input type="text"	name="supName">
					</td>
				</tr>
				<tr>
					<td>
						地址：<input type="text"	name="supAddress">
					</td>
				</tr>
				<tr>
				<td  align="center"  colspan="2"><button type="submit" >提交</button></td>
				</tr>
			</table>
		</form>
	</body>
</html>
