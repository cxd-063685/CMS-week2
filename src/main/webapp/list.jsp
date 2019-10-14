<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css.css">
</head>
<body>
<center>
<table border="1" cellspacing="0">
	<tr>
		<td colspan="526">
			<form action="list.do" method="post">
				价格范围:<input type="text" name="pricebegin" style="width:40px;" value="${sessionScope.selectModel.pricebegin}"/>-<input type="text" name="priceend" style="width:40px;" value="${sessionScope.selectModel.priceend}"/>&nbsp;&nbsp;
				已售百分比:<input type="text" name="printbegin" style="width:40px;" value="${sessionScope.selectModel.printbegin}"/>-<input type="text" name="printend" style="width:40px;" value="${sessionScope.selectModel.printend}"/>%&nbsp;&nbsp;
				排序:<select name="sortby"><option ${sessionScope.selectModel.sortby eq "已售百分比"?'selected':''}>已售百分比</option><option ${selectModel.sortby eq "价格"?"selected":""}>价格</option></select>
					<select name="sortto"><option ${sessionScope.selectModel.sortto eq "正序"?'selected':''}>正序</option><option ${selectModel.sortto eq "倒序"?"selected":""}>倒序</option></select> &nbsp;&nbsp;
				<input type="submit" value="查询"/>
				<button type="button" onclick="location='list.do'">清除查询</button>
			</form>
		</td>
	</tr>
	<tr>
		<td>ID</td>
		<td>商品名称</td>
		<td>秒杀价格</td>
		<td>已售百分比</td>
	</tr>
	<c:forEach items="${list.pageList}"  var="goods">
		<tr>
		<td>${goods.gid}</td>
		<td>${goods.gname}</td>
		<td>￥${goods.price}</td>
		<td>${goods.print}%</td>
	</tr>
	</c:forEach>
	<tr>
		<td align="center" colspan="456">
			${list.pageInfo}
		</td>
	</tr>
</table>
</center>
</body>
</html>